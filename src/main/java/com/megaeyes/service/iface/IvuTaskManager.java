/**   
 * @Title: IvuTaskManager.java 
 * @Package com.megaeyes.consoleinterface.service.iface 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-6-18 下午1:14:09 
 * @version V1.0   
 */
package com.megaeyes.service.iface;

import java.math.BigDecimal;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.IvuTask;



/**
 * @ClassName: IvuTaskManager
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-6-18 下午1:14:09
 * 
 */
public interface IvuTaskManager extends BaseManager {

	public String createIvuTask(BigDecimal ivuTaskId, String cmsAccount,
			String taskId, String cmsAccountPassword, String ivuCode,
			Long algCode, Long algSupplierCode, Long videoSource, String rtsp,
			String http, String customerUserName, String customerUserPassword,
			String cmsIp, Long cmsPort, String cmsGuid, Long resultUpType,
			String resultUpUrl, String resultUpIp, Long resultUpPort,
			String picDataUpIp, Long picDataUpPort, String algPolicy,
			String taskStatus, String actionType, String cameraId,String organId);

	public void deleteIvuTask(String id);

	public List<IvuTask>  listIvuTask(String organId);

	public void updateIvuTask(String id, BigDecimal ivuTaskId,
			String cmsAccount, String taskId, String cmsAccountPassword,
			String ivuCode, Long algCode, Long algSupplierCode,
			Long videoSource, String rtsp, String http,
			String customerUserName, String customerUserPassword, String cmsIp,
			Long cmsPort, String cmsGuid, Long resultUpType,
			String resultUpUrl, String resultUpIp, Long resultUpPort,
			String picDataUpIp, Long picDataUpPort, String algPolicy,
			String taskStatus, String actionType, String cameraId,String organId);

}
