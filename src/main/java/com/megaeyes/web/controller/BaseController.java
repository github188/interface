/**   
 * @Title: BaseController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: controller的基类
 * @author liugaofeng liugaofeng@megaeyes.com   
 * @date 2012-2-28 下午5:46:01 
 * @version V1.0   
 */
package com.megaeyes.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.output.XMLOutputter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.UserManager;
import com.megaeyes.service.iface.VISManager;
import com.megaeyes.service.utils.DateTimeConvert;
import com.megaeyes.service.utils.JsonDateValueProcessor;
import com.megaeyes.service.utils.licence.AppLicenceUtil;
import com.megaeyes.service.utils.licence.LicenceNotFoundException;
import com.megaeyes.service.utils.licence.SignatureNotRightException;
import com.megaeyes.web.response.BaseResponse;

/**
 * @ClassName: BaseController
 * @Description: controller的基类
 * @author liugaofeng liugaofeng@megaeyes.com
 * @date 2012-2-28 下午5:46:01
 * 
 */
@Controller
public class BaseController {

	@Autowired
	UserManager userManager;

	@Autowired
	VISManager visManager;
	public static Logger log = Logger.getLogger(BaseController.class);

	/**
	 * @Title: writePageNoZip
	 * @Description: 将返回结果不以zip压缩的方式写在输出流上
	 * @param @param response
	 * @param @param resp 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void writePageNoZip(HttpServletResponse response, BaseResponse resp) {
		try {
			String jsonRtn = JSONObject.fromObject(resp).toString();
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.getWriter().write(
					new String(jsonRtn.getBytes("UTF-8"), "iso-8859-1"));
			response.getWriter().flush();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * @Description: 返回带日期属性的json字符串
	 * <br>此方法适合返回对象中包含Date类型的属性
	 * <br>日期格式按需指定 
	 * @author zhuanqi@megaeyes.com
	 * @param @param response
	 * @param @param resp
	 * @param @param formatType 
	 * @return void 
	 * @throws
	 */
	public void writeDateJSONPageNoZip(HttpServletResponse response, BaseResponse resp ,int formatType) {
		try {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(java.util.Date.class, new JsonDateValueProcessor(DateTimeConvert.getFormatStr(formatType)));
			String jsonRtn = JSONObject.fromObject(resp,jsonConfig).toString();
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.getWriter().write(new String(jsonRtn.getBytes("UTF-8"), "iso-8859-1"));
			response.getWriter().flush();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @Title: writePage
	 * @Description: 以GZIP压缩格式返回页面
	 * @param @param response
	 * @param @param resp 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void writePage(HttpServletResponse response, BaseResponse resp) {
		// 返回前移除ThreadLocal

		// 返回
		String jsonRtn = JSONObject.fromObject(resp).toString();

		response.setHeader("Content-Encoding", "gzip");

		GZIPOutputStream out;
		try {
			out = new GZIPOutputStream(response.getOutputStream());
			out.write(jsonRtn.getBytes("UTF-8"));
			out.finish();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 返回xml，带有Content-length头
	 * 
	 * @param response
	 * @param doc
	 *            xml内容
	 * @throws ServletException
	 * @throws IOException
	 */
	public void writePageWithContentLength(HttpServletResponse response,
			Document doc) throws ServletException, IOException {
		XMLOutputter out = new XMLOutputter("  ", true, "UTF-8");
		String body = out.outputString(doc);

		log.info(body);

		response.setCharacterEncoding("utf-8");
		response.setContentLength(body.getBytes("UTF-8").length);
		response.setContentType("application/xml");
		response.getWriter().write(body);
		response.getWriter().flush();
		response.getWriter().close();
	}

	public Integer checkLicence() {
		Integer result = 0;
		Map m = new HashMap();
		try {
			m = AppLicenceUtil.getLicence();
			Iterator iterator = m.keySet().iterator();
		} catch (LicenceNotFoundException e) {
			result = Integer.valueOf(ErrorCode.LICENCE_NOT_FOUND);
		} catch (SignatureNotRightException e) {
			result = Integer.valueOf(ErrorCode.WRONG_SIGNATURE);
		} catch (Exception e) {
			e.printStackTrace();
			result = Integer.valueOf(ErrorCode.ERROR);
		}
		// 获取数据库内容
		if (result == 0) {

			try {
				Integer userCount = userManager.countAllUser();
				Integer videoCount = visManager.countAllVic();
				Date currentDate = new Date();
				Integer licenceUserCount = Integer.valueOf(m.get("userCount")
						.toString());
				Integer licenceVideoCount = Integer.valueOf(m.get("videoCount")
						.toString());
				Date licenceExpireDate = new SimpleDateFormat("yyyy-MM-dd")
						.parse(m.get("expireDate").toString());
				if (userCount > licenceUserCount)
					result = Integer.valueOf(ErrorCode.USER_COUNT_OVERFLOW);
				if (videoCount > licenceVideoCount)
					result = Integer.valueOf(ErrorCode.VIDEO_COUNT_OVERFLOW);
				if (currentDate.after(licenceExpireDate))
					result = Integer.valueOf(ErrorCode.PLATFORM_EXPIRE);
			} catch (ParseException e) {
				e.printStackTrace();
				result = Integer.valueOf(ErrorCode.ERROR);
			}
		}
		return result;

	}

	/**
	 * 添加摄像头前，检查VIC的License
	 * 
	 * @return
	 */
	public String checkVicLicence() {
		String result = ErrorCode.SUCCESS;
		Map m = new HashMap();
		try {
			m = AppLicenceUtil.getLicence();
			Iterator iterator = m.keySet().iterator();
		} catch (LicenceNotFoundException e) {
			result = ErrorCode.LICENCE_NOT_FOUND;
		} catch (SignatureNotRightException e) {
			result = ErrorCode.WRONG_SIGNATURE;
		} catch (Exception e) {
			e.printStackTrace();
			result = ErrorCode.ERROR;
		}
		// 获取数据库内容
		if (ErrorCode.SUCCESS.equals(result)) {

			try {
				Integer videoCount = visManager.countAllVic();
				Integer licenceVideoCount = Integer.valueOf(m.get("videoCount")
						.toString());
				if (videoCount >= licenceVideoCount) {
					result = ErrorCode.VIDEO_COUNT_OVERFLOW;
				}
			} catch (Exception e) {
				e.printStackTrace();
				result = ErrorCode.ERROR;
			}
		}
		return result;
	}

	/**
	 * 添加用户前，检查用户License
	 * 
	 * @return
	 */
	public String checkUserLicence() {
		String result = ErrorCode.SUCCESS;
		Map m = new HashMap();
		try {
			m = AppLicenceUtil.getLicence();
			Iterator iterator = m.keySet().iterator();
		} catch (LicenceNotFoundException e) {
			result = ErrorCode.LICENCE_NOT_FOUND;
		} catch (SignatureNotRightException e) {
			result = ErrorCode.WRONG_SIGNATURE;
		} catch (Exception e) {
			e.printStackTrace();
			result = ErrorCode.ERROR;
		}
		// 获取数据库内容
		if (ErrorCode.SUCCESS.equals(result)) {

			try {
				Integer userCount = userManager.countAllUser();
				Integer licenceUserCount = Integer.valueOf(m.get("userCount")
						.toString());
				if (userCount >= licenceUserCount) {
					result = ErrorCode.USER_COUNT_OVERFLOW;
				}
			} catch (Exception e) {
				e.printStackTrace();
				result = ErrorCode.ERROR;
			}
		}
		return result;
	}
}
