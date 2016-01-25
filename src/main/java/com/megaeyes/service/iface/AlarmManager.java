/**   
 * @Title: AlarmManager.java 
 * @Package com.megaeyes.service.iface 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-16 下午2:25:36 
 * @version V1.0   
 */
package com.megaeyes.service.iface;

import java.util.List;

import org.apache.avalon.framework.service.ServiceException;
import org.jdom.Document;

import com.megaeyes.persistence.ibatis.model.EpAlarmEvent;
import com.megaeyes.persistence.ibatis.model.EpScheme;
import com.megaeyes.persistence.ibatis.model.HistoryVideo;
import com.megaeyes.persistence.ibatis.model.PlatformResources;
import com.megaeyes.persistence.ibatis.model.SipServer;
import com.megaeyes.service.exception.BusinessException;

/**
 * @ClassName: AlarmManager
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-16 下午2:25:36
 * 
 */
public interface AlarmManager extends BaseManager {

	/**
	 * @Title: listSchemesDetail
	 * @Description: TODO(查询指定ID数组的预案详细内容，事件服务器接口用到)
	 * @param ids
	 *            预案ID数组
	 * @param @return
	 * @param @throws ServiceException 设定文件
	 * @return Document 返回类型
	 * @throws
	 */
	public Document listSchemesDetail(String[] ids) throws ServiceException;

	/**
	 * @Title: getSchemesLastUpdateTime
	 * @Description: TODO( 获取所有预案中最近的创建或修改时间)
	 * @param @return
	 * @param @throws ServiceException 设定文件
	 * @return Long 返回类型
	 * @throws
	 */
	public Long getSchemesLastUpdateTime() throws ServiceException;

	/**
	 * @Title: listEpScheme
	 * @Description: TODO(列表查询预案)
	 * @param @param organId 预案所属机构ID，可以为空，查询全部预案
	 * @param @return
	 * @param @throws ServiceException 设定文件
	 * @return List<EpScheme> 返回类型
	 * @throws
	 */
	public List<EpScheme> listEpScheme(String organId) throws ServiceException;

	/**
	 * 创建报警信息
	 * 
	 * @param sessionId
	 *            上报服务器会话ID
	 * @param sourceId
	 *            报警源ID
	 * @param sourceType
	 *            报警源类型
	 * @param threshold
	 *            报警阀值
	 * @param value
	 *            报警具体值
	 * @param beginTime
	 *            报警开始时间
	 * @param endTime
	 *            报警结束时间
	 * @param note
	 *            备注
	 * @param naming
	 *            报警事件Naming
	 * @param eventTypeName
	 *            报警类型
	 * @return String 返回类型
	 */
	public String insertEpAlarmEvent(String sessionId, String sourceId,
			String sourceType, String threshold, String value, Long beginTime,
			Long endTime, String note, String naming, String eventTypeName,
			String level);

	/**
	 * @Title: getEventTypeName
	 * @Description: TODO( 事件服务器发过来的
	 *               eventNaming形如：20121222110100_1024_0000000000200000000000000710002
	 *               )
	 * @param eventNaming
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getEventTypeName(String eventNaming);

	/**
	 * 
	 * @Title: listSharedAlarmDevice
	 * @Description: TODO( 分页查询所有共享的报警源设备（预案报警源设备）)
	 * @param begin
	 *            起始行，从1开始
	 * @param limit
	 *            要查询的行数
	 * @return 设定文件
	 * @return List<PlatformResources> 返回类型
	 * @throws
	 */
	public List<PlatformResources> listSharedAlarmDevice(int begin, int limit);

	/**
	 * 
	 * @Title: countSharedAlarmDevice
	 * @Description: TODO(统计所有共享的报警源设备（预案报警源设备）的记录数)
	 * @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public int countSharedAlarmDevice();

	/**
	 * 
	 * @Title: getSipServer
	 * @Description: TODO(获取平台注册的信令网关服务器)
	 * @return
	 * @throws ServiceException
	 *             设定文件
	 * @return SipServer 返回类型
	 * @throws
	 */
	public SipServer getSipServer() throws BusinessException;

	/**
	 * @Title: updateEpAlarmEvent
	 * @Description: 根据naming修改note
	 * @param naming
	 *            naming信息
	 * @param note
	 *            备注
	 * @param confirmTime
	 *            当前时间
	 * @return void 返回类型
	 * @throws BusinessException
	 */
	public void updateEpAlarmEvent(String naming, String note,
			String confirmTime) throws BusinessException;

	/**
	 * 
	 * 条件查询历史报警信息
	 * 
	 * @param organIds
	 *            机构ID列表
	 * @param begin
	 *            起始时间
	 * @param end
	 *            结束时间
	 * @param start
	 *            分页开始行
	 * @param limit
	 *            分页总的查询行数
	 * @return
	 * @throws BusinessException
	 */
	public List<EpAlarmEvent> listHistoryAlarmEvent(List<String> organIds,
			Long begin, Long end, int start, int limit)
			throws BusinessException;

	/**
	 * 统计满足条件的历史报警信息条数
	 * 
	 * @param organIds
	 *            报警预源设备所属机构ID列表
	 * @param begin
	 *            时间范围，起始时间
	 * @param end
	 *            时间范围， 结束时间
	 * @return 满足条件的历史报警信息条数
	 */
	public Integer countHistoryAlarmEvent(List<String> organIds, Long begin,
			Long end);

	/**
	 * 分页查询符合条件的指定报警源集合的报警信息
	 * 
	 * @param sourceIds
	 *            报警源集合ID列表
	 * @param types
	 *            类型集合 事件类型名称
	 * @param beginTime
	 *            按照时间段进行查询，起始时间
	 * @param endTime
	 *            按照时间段进行查询，结束时间
	 * @param level
	 *            报警级别
	 * @param start
	 *            查询起始行
	 * @param length
	 *            要查询的条数
	 * @return
	 */
	public List<EpAlarmEvent> listEpAlarmEventInDevices(List<String> sourceIds,
			List<String> types, Long beginTime, Long endTime, String level,
			int start, int length);

	/**
	 * 统计符合条件的指定报警源集合的报警信息数目
	 * 
	 * @param sourceIds
	 *            报警源集合ID列表
	 * @param types
	 *            类型集合
	 * @param beginTime
	 *            按照时间段进行查询，起始时间
	 * @param endTime
	 *            按照时间段进行查询，结束时间
	 * @param level
	 *            报警级别
	 * @return
	 */
	public int countEpAlarmEventInDevices(List<String> sourceIds,
			List<String> types, Long beginTime, Long endTime, String level);

	/**
	 * 根据事件Naming获取设备类型
	 * 
	 * @param 事件Naming
	 * @return 设备类型
	 * @throws BusinessException
	 */
	public String getDeviceTypeByEventNaming(String naming)
			throws BusinessException;

	/**
	 * 
	 * 根据报警记录ID获取报警录像列表
	 * 
	 * @param eventId
	 *            报警记录ID
	 * @return 报警录像列表
	 * @throws BusinessException
	 */
	public List<HistoryVideo> listHistoryVideoByEventId(String eventId)
			throws BusinessException;

	/**
	 * 报警确认
	 * 
	 * @param id
	 *            报警事件31为ID
	 * @throws BusinessException
	 */
	public void confirmAlarm(String id) throws BusinessException;
}
