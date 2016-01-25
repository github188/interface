/**   
 * @Title: EpSchemeManager.java 
 * @Package com.megaeyes.service.iface 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-4-16 上午2:19:42 
 * @version V1.0   
 */
package com.megaeyes.service.iface;

import java.util.List;

import org.json.JSONException;

import com.megaeyes.persistence.ibatis.model.EpScheme;
import com.megaeyes.persistence.ibatis.vo.EpSchemeVO;
import com.megaeyes.persistence.ibatis.vo.VideoInputChannelAndSchemeVO;
import com.megaeyes.service.exception.BusinessException;

/**
 * @ClassName: EpSchemeManager
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-16 上午2:19:42
 * 
 */
public interface EpSchemeManager extends BaseManager {

	/**
	 * @Title: createES
	 * @Description: 创建
	 * @param name
	 *            预案名称
	 * @param organId
	 *            机构ID
	 * @param note
	 *            备注
	 * @param type
	 *            预案类型
	 * @param lastUpdateTime
	 *            最后更新时间
	 * @param actions
	 *            json对象
	 * @param userId
	 *            创建预案的用户ID
	 * @return String 返回类型
	 * @throws BusinessException
	 */
	public String createES(String name, String organId, String note,
			String type, Long lastUpdateTime, String actions, String userId)
			throws BusinessException, JSONException;

	/**
	 * @Title: deleteES
	 * @Description: 删除预案
	 * @param id
	 *            设定文件
	 * @return void 返回类型
	 * @throws BusinessException
	 */
	public void deleteES(String id) throws BusinessException;

	/**
	 * @Title: listESByOrganId
	 * @Description: 根据机构ID查询预案列表
	 * @param organId
	 * @return List<EpScheme> 返回类型
	 * @throws BusinessException
	 */
	public List<EpScheme> listESByOrganId(String organId)
			throws BusinessException;

	/**
	 * @Title: updateES
	 * @Description: 根据指定ID更新预案
	 * @param id
	 *            预案ID
	 * @param name
	 *            预案名称
	 * @param organId
	 *            机构ID
	 * @param note
	 *            备注
	 * @param type
	 *            类型
	 * @param lastUpdateTime
	 *            最后更新时间
	 * @param actions
	 *            设定文件
	 * @return void 返回类型
	 * @throws BusinessException
	 */
	public void updateES(String id, String name, String organId, String note,
			String type, Long lastUpdateTime, String actions)
			throws BusinessException, JSONException;

	/**
	 * @Title: getEpScheme
	 * @Description: 根据ID查询预案及命令
	 * @param id
	 * @return EpSchemeVO 返回类型
	 * @throws BusinessException
	 */
	public EpSchemeVO getEpScheme(String id) throws BusinessException;

	/**
	 * @Title: bindDeviceEpScheme
	 * @Description: 绑定设备作为触发源的预案
	 * @param deviceId
	 *            预案报警触发源的设备ID
	 * @param deviceType
	 *            设备类型
	 * @param schemeId
	 *            预案ID
	 * @param alarmType
	 *            报警事件类型
	 * @return String 返回类型
	 * @throws BusinessException
	 */
	public String bindDeviceEpScheme(String deviceId, String deviceType,
			String schemeId, String alarmType) throws BusinessException;

	/**
	 * @throws JSONException
	 * @Title: getEpRSchemeAlarmSource
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param sourceIds
	 * @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public List getEpRSchemeAlarmSource(String sourceIds) throws JSONException;

	/**
	 * 取消设备与预案的绑定关系
	 * 
	 * @param deviceId
	 *            设备ID
	 * @param deviceType
	 *            设备类型：1: 摄像头2: 数字探测器输入3: 数字探测器输出4: 模拟探测器6: 报警输入
	 * @param schemeId
	 *            预案ID
	 * @param alarmType
	 *            报警事件类型
	 * @throws BusinessException
	 */
	public void deleteDeviceEpScheme(String deviceId, String deviceType,
			String schemeId, String alarmType) throws BusinessException;

	/**
	 * 根据预案ID，更新预案的最后修改时间，仅修改下时间，为了即时通知到事件服务器重新取次预案关联
	 * 
	 * @param schemeId
	 *            预案ID
	 * @throws BusinessException
	 */
	public void updateESTimeById(String schemeId) throws BusinessException;

	/**
	 * 根据机构ID查询摄像头和相关联预案
	 * 
	 * @param organId
	 *            机构ID
	 * @throws BusinessException
	 */
	public List<VideoInputChannelAndSchemeVO> listVICAndSchemeByOrganId(
			String organId);
}
