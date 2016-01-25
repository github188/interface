/**   
 * @Title: AcEmployeesController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-4-23 上午2:24:51 
 * @version V1.0   
 */
package com.megaeyes.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.AcEmployees;
import com.megaeyes.persistence.ibatis.vo.AcEmployeesVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AcEmployeesManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.AcEmployeesResponse;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListAcEmployeesResponse;

/**
 * @ClassName: AcEmployeesController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-23 上午2:24:51
 * 
 */
@Controller
public class AcEmployeesController extends BaseController {

	@Autowired
	AcEmployeesManager acEmployeesManager;

	/**
	 * @Title: createAcEmployees
	 * @Description: 创建职员信息
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 *             设定文件
	 * @return void 返回类型
	 */
	@ControllerDescription(description = "创建职员信息", isLog = true, isCheckSession = true)
	@RequestMapping("/createAcEmployees.json")
	public void createAcEmployees(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		BaseResponse resp = new BaseResponse();
		resp.setCode(ErrorCode.ERROR);
		request.setCharacterEncoding("UTF-8");
		String name = null;
		String note = null;
		String mobile = null;
		String phone = null;
		String email = null;
		Short age = null;
		Short gender = null;
		String address = null;
		String empNo = null;
		String nation = null;
		String folk = null;
		String idCard = null;
		BigDecimal birthday = null;
		String place = null;
		byte[] image = null;
		String organId = null;
		String branchId = null;
		String userId = null;
		String position = null;
		Short isUser = 0;
		boolean nameFlag = false;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			resp.setCode(ErrorCode.SUCCESS);
			// 解析请求
			try {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List items = upload.parseRequest(request);
				Iterator iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					String fieldName = item.getFieldName();

					// 简单文本参数部分
					if (item.isFormField()) {
						if ("name".equals(fieldName)) {
							name = item.getString("UTF8");
							nameFlag = true;
							if (StringUtils.isBlank(name)) {
								resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
								resp.setMessage("name");
								break;
							}
						} else if ("note".equals(fieldName)) {
							note = item.getString("UTF8");
						} else if ("position".equals(fieldName)) {
							position = item.getString("UTF8");
						} else if ("branchId".equals(fieldName)) {
							branchId = item.getString("UTF-8");
						} else if ("empNo".equals(fieldName)) {
							empNo = item.getString("UTF-8");
						} else if ("mobile".equals(fieldName)) {
							mobile = item.getString("UTF8");
						} else if ("organId".equals(fieldName)) {
							organId = item.getString("UTF-8");
						} else if ("phone".equals(fieldName)) {
							phone = item.getString("UTF8");
						} else if ("email".equals(fieldName)) {
							email = item.getString("UTF8");
						} else if ("userId".equals(fieldName)) {
							userId = item.getString("UTF8");
						} else if ("age".equals(fieldName)) {
							String sAge = item.getString("UTF8");
							try {
								age = Short.parseShort(sAge);
							} catch (NumberFormatException e) {
								resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
								resp.setMessage("age");
								break;
							}
						} else if ("gender".equals(fieldName)) {
							String sGender = item.getString("UTF8");
							try {
								gender = Short.parseShort(sGender);
							} catch (NumberFormatException e) {
								resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
								resp.setMessage("gender");
								break;
							}
						} else if ("address".equals(fieldName)) {
							address = item.getString("UTF8");
						}
					}
					// 最后是图片流
					else {
						image = item.get();
					}
				}

				if (!nameFlag) {
					resp.setCode(ErrorCode.PARAMETER_NOT_FOUND);
					resp.setMessage("name");
				}

				if (resp.getCode().equals(ErrorCode.SUCCESS)) {
					if (!StringUtils.isBlank(userId)) {
						isUser = 1;
					}
					String id = acEmployeesManager
							.createAcEmployees(name, isUser, userId, note,
									mobile, phone, email, age, gender, address,
									empNo, nation, folk, idCard, birthday,
									place, image, organId, branchId, position);
					resp.setCode(ErrorCode.SUCCESS);
					resp.setMessage(id);
				}
			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
		writePageNoZip(response, resp);
	}

	/**
	 * @Title: deleteAcEmployees
	 * @Description: 删除职员信息
	 * @param request
	 * @param response
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "删除职员信息", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteAcEmployees.json")
	public void deleteAcEmployees(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try {
			acEmployeesManager.deleteAcEmployees(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * @Title: listAcEmployees
	 * @Description: 查询职员列表
	 * @param request
	 * @param response
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "查询职员列表 ", isLog = false, isCheckSession = true)
	@RequestMapping("/listAcEmployees.json")
	public void listAcEmployees(HttpServletRequest request,
			HttpServletResponse response) {
		ListAcEmployeesResponse resp = new ListAcEmployeesResponse();
		try {
			List<AcEmployeesVO> ae = acEmployeesManager.listAcEmployees();
			resp.setCode(ErrorCode.SUCCESS);
			resp.setAcEmployees(ae);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据部门ID查询职工 ", isLog = false, isCheckSession = true)
	@RequestMapping("/listAcEmployeesByGroupId.json")
	public void listAcEmployeesByGroupId(HttpServletRequest request,
			HttpServletResponse response) {
		ListAcEmployeesResponse resp = new ListAcEmployeesResponse();
		String branchId = (String) request.getAttribute("branchId");
		try {
			List<AcEmployeesVO> ae = acEmployeesManager.listAcEmployeesByBranchId(branchId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setAcEmployees(ae);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 * @Title: getAcEmployees
	 * @Description: 根据ID查询职员信息
	 * @param request
	 * @param response
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "根据ID查询职员信息 ", isLog = false, isCheckSession = true)
	@RequestMapping("/getAcEmployees.json")
	public void getAcEmployees(HttpServletRequest request,
			HttpServletResponse response) {
		AcEmployeesResponse resp = new AcEmployeesResponse();
		String id = (String) request.getAttribute("id");
		try {
			AcEmployees ae = acEmployeesManager.getAcEmployees(id);
			if (ae != null) {
				resp.setId(ae.getId());
				resp.setName(ae.getName());
				resp.setIsUser(ae.getIsUser());
				resp.setUserId(ae.getUserId());
				resp.setNote(ae.getNote());
				resp.setMobile(ae.getMobile());
				resp.setPhone(ae.getPhone());
				resp.setEmail(ae.getEmail());
				resp.setAge(ae.getAge());
				resp.setAddress(ae.getAddress());
				resp.setEmpNo(ae.getEmpNo());
				resp.setNation(ae.getNation());
				resp.setFolk(ae.getFolk());
				resp.setIdCard(ae.getIdCard());
				resp.setBirthday(ae.getBirthday());
				resp.setPlace(ae.getPlace());
			}
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据卡号查询职工", isLog = false, isCheckSession = true)
	@RequestMapping("/getAcEmployeeByCardNumber.json")
	public void getAcEmployeeByCardNumber(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String cardNumber =request.getParameter("cardNumber");
		System.out.println("qwqwqwq:"+cardNumber);
		AcEmployeesResponse resp = new AcEmployeesResponse();
		try {
			AcEmployees ae = acEmployeesManager
					.getAcEmployeeByCardNumber(cardNumber);
			if (ae != null) {
				resp.setId(ae.getId());
				resp.setName(ae.getName());
				resp.setIsUser(ae.getIsUser());
				resp.setUserId(ae.getUserId());
				resp.setNote(ae.getNote());
				resp.setMobile(ae.getMobile());
				resp.setPhone(ae.getPhone());
				resp.setEmail(ae.getEmail());
				resp.setAge(ae.getAge());
				resp.setAddress(ae.getAddress());
				resp.setEmpNo(ae.getEmpNo());
				resp.setNation(ae.getNation());
				resp.setFolk(ae.getFolk());
				resp.setIdCard(ae.getIdCard());
				resp.setBirthday(ae.getBirthday());
				resp.setPlace(ae.getPlace());
				resp.setImage(ae.getImage());
				resp.setCode(ErrorCode.SUCCESS);
			}
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);

	}

	@ControllerDescription(description = "根据ID查询职员图片 ", isLog = false, isCheckSession = true)
	@RequestMapping("/getAcEmployeesImage.json")
	public void getAcEmployeesImage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = (String) request.getAttribute("id");
		response.setContentType("image/jpeg");
		AcEmployees ae = acEmployeesManager.getAcEmployees(id);
		if (ae != null) {
			byte[] image = ae.getImage();
			for (int i = 0; i < image.length; i++) {
				response.getOutputStream().write(image[i]);
			}
		}
	}

	/**
	 * @Title: updateAcEmployees
	 * @Description: 根据指定ID修改职员信息
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 *             设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@ControllerDescription(description = "根据指定ID修改职员信息", isLog = false, isCheckSession = true)
	@RequestMapping("/updateAcEmployees.json")
	public void updateAcEmployees(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		BaseResponse resp = new BaseResponse();
		request.setCharacterEncoding("UTF-8");

		String id = null;
		String sessionId = null;
		String name = null;
		String note = null;
		String mobile = null;
		String phone = null;
		String email = null;
		Short age = null;
		Short gender = null;
		String address = null;
		String empNo = null;
		String nation = null;
		String folk = null;
		String idCard = null;
		BigDecimal birthday = null;
		String place = null;
		byte[] image = null;
		String userId = null;
		Short isUser = 0;
		// 检查是否是文件上传请求
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			// 解析请求
			try {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List items = upload.parseRequest(request);
				Iterator iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					String fieldName = item.getFieldName();

					// 简单文本参数部分
					if (item.isFormField()) {
						if ("id".equals(fieldName)) {
							id = item.getString("UTF8");
							if (StringUtils.isBlank(id)) {
								resp.setCode(ErrorCode.PARAMETER_NOT_FOUND + "");
								resp.setMessage("id");
								break;
							}
						} else if ("name".equals(fieldName)) {
							name = item.getString("UTF8");
						} else if ("note".equals(fieldName)) {
							note = item.getString("UTF8");
						} else if ("mobile".equals(fieldName)) {
							mobile = item.getString("UTF8");
						} else if ("phone".equals(fieldName)) {
							phone = item.getString("UTF8");
						} else if ("empNo".equals(fieldName)) {
							empNo = item.getString("UTF-8");
						} else if ("userId".equals(fieldName)) {
							userId = item.getString("UTF8");
						} else if ("email".equals(fieldName)) {
							email = item.getString("UTF8");
						} else if ("age".equals(fieldName)) {
							String sAge = item.getString("UTF8");
							try {
								age = Short.parseShort(sAge);
							} catch (NumberFormatException e) {
								resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED
										+ "");
								resp.setMessage("age");
								break;
							}
						} else if ("gender".equals(fieldName)) {
							String sGender = item.getString("UTF8");
							try {
								gender = Short.parseShort(sGender);
							} catch (NumberFormatException e) {
								resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED
										+ "");
								resp.setMessage("gender");
								break;
							}
						} else if ("address".equals(fieldName)) {
							address = item.getString("UTF8");
						}
					}
					// 最后是图片流
					else {
						image = item.get();
					}
				}
				if (resp.getCode().equals(ErrorCode.SUCCESS)) {
					if (!StringUtils.isBlank(userId)) {
						isUser = 1;
					}
					acEmployeesManager.updateACEmployee(id, name, isUser,
							userId, note, mobile, phone, email, age, gender,
							address, empNo, nation, folk, idCard, birthday,
							place, image);
				}

			} catch (BusinessException be) {
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
		writePageNoZip(response, resp);
	}
	
	
	@ControllerDescription(description = "根据员工组ID查询员工列表", isLog = false, isCheckSession = true)
	@RequestMapping("/getEmployeeListByGroupId.json")
	public void getEmployeeListByGroupId(HttpServletRequest request,
			HttpServletResponse response)throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String groupId = (String)request.getAttribute("groupId");
		ListAcEmployeesResponse resp = new ListAcEmployeesResponse();
		try {
			List<AcEmployeesVO> ae = acEmployeesManager.getAcEmployeeListByGroupId(groupId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setAcEmployees(ae);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
}
