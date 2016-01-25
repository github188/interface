package com.megaeyes.service.iface;

import java.math.BigDecimal;
import java.util.List;

import org.apache.avalon.framework.service.ServiceException;
import org.json.JSONException;

import com.megaeyes.persistence.ibatis.model.AcAccessControls;
import com.megaeyes.persistence.ibatis.vo.ListControlAndVicVO;
import com.megaeyes.persistence.ibatis.vo.UserSessionVO;
import com.megaeyes.service.exception.BusinessException;

/**
 * 门禁相关Manager
 * 
 * @author huangbuji huangbuji@megaeyes.com
 *         <p />
 *         2012-4-20 上午09:13:31
 */
public interface AccessControllerManager extends BaseManager {

	/**
	 * 查询门禁事件要通知的用户列表
	 * 
	 * @param id
	 *            门禁ID
	 * @return
	 */
	public List<UserSessionVO> listDoorNotifyUsers(String id);

	/**
	 * 增加一条门禁刷卡记录
	 * 
	 * @param triggerId
	 *            可能为用户ID，也可能是卡ID，现在只有这二种
	 * @param deviceType
	 *            Door：报警的门，Area：报警防区
	 * @param logType
	 *            Trigger：正常触发的log,Alarm：报警log
	 * @param triggerType
	 *            <pre>
	 *  	TriggerFingerPrint：指纹，这种方式下Trigger Id为用户ID
	 * 	TriggerPassword：密码，这种方式下Trigger Id为用户ID
	 * 	TriggerCard：门卡，这种方式下Trigger Id为卡ID
	 * 	TriggerOpenDoor：门开记录，Trigger Id值为空
	 * 	TriggerCloseDoor：门关记录，Trigger Id值为空
	 * 	TriggerHandleOpen：手动开门记录，Trigger Id值为空
	 * 	AlarmIllegalOpenDoor：非正常门开报警，TriggerId值为空
	 * 	AlarmIllegalCloseDoor：非正常门关报警（非正常开门后），Trigger Id值为空
	 * 	AlarmTimeoutOpenDoor：合法刷卡在规定延时内未开门进入报警，Trigger Id值为空
	 * 	AlarmTimeoutCloseDoor：合法进入后但在规定延时内未关好门报警，Trigger Id值为空
	 * 	AlarmInvalidCard：无效的用户卡刷卡记录报警，Trigger Id为卡ID
	 * 	AlarmInvalidFingerPrint：无效的指纹刷卡记录报警，Trigger Id为用户ID
	 * 	AlarmOverdueCard：已过有效期卡刷卡记录报警，Trigger Id为卡ID
	 * 	AlarmOverdueFingerPrint：已过有效期指纹刷卡记录报警，Trigger Id为用户ID
	 * 	AlarmPeriodLimit：当前时间无进入权限的用户卡刷卡记录报警，Trigger Id为卡ID
	 * 	AlarmPeriodLimitFingerPrint：当前无进入权限的用户指纹刷卡记录报警，Trigger Id为用户ID
	 * 	AlarmUserMenace: 胁迫报警,Trigger Id为用户ID
	 * </pre>
	 * @param deviceNaming
	 * @param note
	 * @param time
	 *            事件发生事件
	 * @param naming
	 *            事件Naming，逻辑主键
	 * @return
	 * @throws ServiceException
	 * @throws Exception
	 */
	public String addACLog(String triggerId, String deviceType, String logType,
			String triggerType, String deviceNaming, String note,
			BigDecimal time, String naming) throws BusinessException;

	/**
	 * createAcAccessControls 创建门
	 * 
	 * @param name
	 *            门名称
	 * @param installLocation
	 *            安装地址
	 * @param deviceNumber
	 *            物理编号
	 * @param channelId
	 *            通道号
	 * @param note
	 *            备注
	 * @param accessServerId
	 *            门禁控制器ID
	 * @param remoteOpen    
	 * 			  是否远程开门     
	 * @return String
	 * @throws BusinessException
	 */
	public String createAcAccessControls(String name, String installLocation,
			String deviceNumber, Integer channelId, String note,
			String accessServerId,String remoteOpen) throws BusinessException;

	/**
	 * 
	 * deleteAcAccessControls 删除门
	 * 
	 * @param id
	 *            门ID
	 * @throws BusinessException
	 */
	public void deleteAcAccessControls(String id) throws BusinessException;

	/**
	 * updateAcAccessControls 更新门
	 * 
	 * @param id
	 *            门ID
	 * @param name
	 *            门名称
	 * @param installLocation
	 *            安装地址
	 * @param deviceNumber
	 *            物理编号
	 * @param channelId
	 *            通道号
	 * @param note
	 *            备注
	 * @param accessServerId
	 *            门禁控制器ID
	 * @param remoteOpen
	 *            是否远程开门           
	 * @throws BusinessException
	 */
	public void updateAcAccessControls(String id, String name,
			String installLocation, String deviceNumber, Integer channelId,
			String note, String accessServerId,String remoteOpen) throws BusinessException;

	/**
	 * getAcAccessControlsById 根据ID查询门记录
	 * 
	 * @param id
	 *            门ID
	 * @return AcAccessControls
	 * @throws BusinessException
	 */
	public AcAccessControls getAcAccessControlsById(String id)
			throws BusinessException;

	/**
	 * 
	 * listAcAccessControlsByOrganId 根据机构ID查询门列表
	 * 
	 * @param organId
	 *            机构ID
	 * @return List<AcAccessControls>
	 * @throws BusinessException
	 */
	public List<AcAccessControls> listAcAccessControlsByOrganId(String organId)
			throws BusinessException;

	/**
	 * 
	 * listAcAccessControlsByAccessServerId 根据门禁控制器ID查询门列表
	 * 
	 * @param accessServerId
	 *            门禁控制器ID
	 * @return List<AcAccessControls>
	 * @throws BusinessException
	 */
	public List<AcAccessControls> listAcAccessControlsByAccessServerId(
			String accessServerId) throws BusinessException;

	/**
	 * 
	 * listAcAccessControlByGatewayId 根据门禁网关ID查询门列表
	 * 
	 * @param gatewayId
	 *            门禁网关ID
	 * @return List<AcAccessControls>
	 */
	public List<AcAccessControls> listAcAccessControlByGatewayId(
			String gatewayId) throws BusinessException;

	/**
	 * 
	 * bindDoorAndVic 绑定门和摄像头
	 * 
	 * @param jsonString
	 * @throws BusinessException
	 *             ,JSONException
	 */
	public void bindDoorAndVic(String jsonString) throws BusinessException,
			JSONException;

	/**
	 * 
	 * listControlAndVic 查询绑定门和摄像头列表
	 * @param organId 机构ID
	 * @return List<ListControlAndVicVO>
	 */
	public List<ListControlAndVicVO> listControlAndVic(String organId);

	/**
	 * 
	 * bindDoorAndUser 绑定门和用户
	 * 
	 * @param jsonString
	 * @param BusinessException
	 */
	public void bindDoorAndUser(String jsonString) throws BusinessException;

	/**
	 * 获取门关联的摄像头
	 * 
	 * @param doorId
	 *            门ID
	 * @return 摄像头Naming列表
	 * @throws BusinessException
	 */
	public List<String> listDoorBindVics(String doorId)
			throws BusinessException;

	/**
	 * 
	 * updateRemoteOpen 更新远程开门状态
	 * @param doorId
	 * @param remoteOpen
	 */
	public void updateRemoteOpen(String doorId, String remoteOpen);

}
