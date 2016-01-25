/**   
* @Title: LogManager.java 
* @Package com.megaeyes.service.iface 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-3-7 上午6:20:00 
* @version V1.0   
*/ 
package com.megaeyes.service.iface;

import java.math.BigDecimal;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpOperationLog;
import com.megaeyes.persistence.ibatis.vo.EpOperationLogVO;
import com.megaeyes.persistence.ibatis.vo.ListLogAndEmployeeVO;

/** 
 * @ClassName: LogManager 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-7 上午6:20:00 
 *  
 */
public interface LogManager extends BaseManager {
	/**
	* @Title: createLog 
	* @Description: 创建日志 
	* @param @param userId
	* @param @param userLoginName
	* @param @param userSessionId
	* @param @param operateTime
	* @param @param operateDescription
	* @param @param operateorIp
	* @param @param interfaceName
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String createLog(String userId, String userLoginName,
			String userSessionId, BigDecimal operateTime,
			String operateDescription, String operateorIp, String interfaceName);
	
	/**
	* @Title: deleteLogById 
	* @Description: 根据ID删除日志 
	* @param @param id    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void deleteLogById(String[] id);
	
	/**
	* @Title: getLogById 
	* @Description: 根据ID返回日志对象 
	* @param @param id
	* @param @return    设定文件 
	* @return EpOperationLog    返回类型 
	* @throws
	 */
	public EpOperationLog getLogById(String id);
	
	/**
	* @Title: updateLog 
	* @Description: 根据ID更新日志
	* @param @param id
	* @param @param userId
	* @param @param userLoginName
	* @param @param userSessionId
	* @param @param operateTime
	* @param @param operateDescription
	* @param @param operateorIp
	* @param @param interfaceName    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updateLog(String id,String userId, String userLoginName,
			String userSessionId, BigDecimal operateTime,
			String operateDescription, String operateorIp, String interfaceName);

	/**
	 * 
	* @Title: listEpOperationLog 
	* @Description: TODO(根据条件查询用户操作日志) 
	* @param startTime 开始时间
	* @param endTime 结束时间
	* @param userLoginName 用户登录名
	* @return    设定文件 
	* @return List<EpOperationLog>    返回类型 
	* @throws
	 */
	public List<EpOperationLog> listEpOperationLog(String startTime,
			String endTime, String userLoginName);

	/**
	 * 
	 * listLogEmployeeByDoorId 根据门ID和时间段查询员工信息
	 * @param endTime 结束时间
	 * @param startTime  开始时间
	 * @param doorId 门ID
	 * @return List<ListLogAndEmployeeVO>
	 */
	public List<ListLogAndEmployeeVO> listLogEmployeeByDoorId(String doorId, String startTime, String endTime);
}
