/**   
* @Title: AppLicenceUtil.java 
* @Package com.megaeyes.service.utils.licence 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liugaofeng liugaofeng@megaeyes.com   
* @date 2012-5-4 下午3:19:55 
* @version V1.0   
*/ 
package com.megaeyes.service.utils.licence;

/** 
 * @ClassName: AppLicenceUtil 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author liugaofeng liugaofeng@megaeyes.com 
 * @date 2012-5-4 下午3:19:55 
 *  
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/*
import net.common.exception.ApplicationException;
import net.common.exception.ApplicationRuntimeException;
*/
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;








/**
 * @author Administrator
 */
public class AppLicenceUtil
{
	/**
	 * licence使用的方式
	 * 		1>如果licenceMode是1的情况，使用licence文件来进行设置 
	 * 		2>如果licenceMode是2的情况，默认的最大的数量是50用户，50摄像头的授权
	 * 
	 * 增加licence模式的变化，主要是为了防止拷贝licence文件的拷贝
	 */
	private static int licenceMode=1;

    private static Log log = LogFactory.getLog(AppLicenceUtil.class);


    public static Map getLicence()
        throws LicenceNotFoundException, SignatureNotRightException
    {

        Map map = new HashMap();
        
        if(licenceMode==1){
        	try
            {
                map = VertifyLicence.getInfo("megaeyes.licence");                
            }
            catch (LicenceNotFoundException e)
            {            	
                throw new LicenceNotFoundException(e);
            }
            catch (SignatureNotRightException e)
            {
                throw new SignatureNotRightException("签名错误");
            }
            
        }else if(licenceMode==2){
        	log.info("本版本是试用版本。");
        	map.put("videoCount","50");
        	map.put("userCount","50");
        	map.put("expireDate","2010-01-01");
        }
        
        return map;
    }

    /*public static void videoVertify() throws ApplicationException, ApplicationRuntimeException
    {

        Map map = getLicence();
        String videoCount = (String) map.get("videoCount");
        if (videoCount != null)
        {
            //查询用户的个数与map中的值进行比较
            int count = Integer.valueOf(videoCount).intValue();

            IDAO dao = XIFDAOFactory.getInstance().getDataAccessObject();

            if (count <= dao.videoCount())
            {
                throw new BigVideoCountException("视频路数超出范围");
            }

        }
    }

    //  licence验证
    public static void userVertify() throws ApplicationException, ApplicationRuntimeException
    {

        Map map = getLicence();
        String userCount = (String) map.get("userCount");
        if (userCount != null)
        {
            //查询用户的个数与map中的值进行比较
            int count = Integer.valueOf(userCount).intValue();

            IDAO dao = XIFDAOFactory.getInstance().getDataAccessObject();

            if (count < dao.userCount())
            {
                throw new BigCountException("用户的个数超出范围");
            }

        }
    }

    public static void logonVertify() throws ApplicationException, ApplicationRuntimeException
    {

        Map map = getLicence();
        String expire = (String) map.get("expireDate");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        if (expire == null)
        {
            return;
        }
        try
        {
            Date expireDate = format.parse(expire);
            Date currentDate = new Date();
            if (currentDate.compareTo(expireDate) >= 0)
            {
                log.info("验证不通过:expire=" + expire + "  currentDate=" + format.format(currentDate));
                throw new AppExpireDateException("expireDate is  " + format.format(expireDate)
                    + "  已过期");

            }
            log.info("验证通过:expire=" + expire + "  currentDate=" + format.format(currentDate));
        }
        catch (ParseException e)
        {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
    	Map m = new HashMap();
    	try {
			m = AppLicenceUtil.getLicence();
		} catch (AppLicenceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AppSignatureNotRightExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  Iterator iterator = m.keySet().iterator();
		  while (iterator.hasNext()) {
              String key = (String) iterator.next();
              String value = (String) m.get(key);
              
              System.out.println(key + "=" + value);

          }
    }*/
}