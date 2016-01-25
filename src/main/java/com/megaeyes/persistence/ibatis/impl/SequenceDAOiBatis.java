/**   
 * @Title: SequenceDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: 数据库表主键序列号
 * @author liugaofeng liugaofeng@megaeyes.com   
 * @date 2012-2-21 上午10:42:46 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * @ClassName: SequenceDAOiBatis
 * @Description: 生成主键的类
 * @author liugaofeng liugaofeng@megaeyes.com
 * @date 2012-2-21 上午10:42:46
 * 
 */
public class SequenceDAOiBatis extends SqlMapClientDaoSupport {

	/**
	 * @Title: getACGatewaySeq
	 * @Description: 生成门禁网关主键
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getACGatewaySeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getACGatewaySeq");
	}

	/**
	 * @Title: getAccessServerSeq
	 * @Description: 接入服务器主键生成
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getAccessServerSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getAccessServerSeq");
	}

	/**
	 * @Title: getDispatchServerSeq
	 * @Description: 分发服务器主键生成
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getDispatchServerSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getDispatchServerSeq");
	}

	/**
	 * @Title: getStorageServerSeq
	 * @Description: TODO(存储逐渐生成)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getStorageServerSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getStorageServerSeq");
	}

	/**
	 * @Title: getEpUserViewSeq
	 * @Description: TODO()
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpUserViewSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpUserViewSeq");
	}

	/**
	 * @Title: getEpOperationLogSeq
	 * @Description:日志主键生成
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpOperationLogSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpOperationLogSeq");
	}

	/**
	 * @Title: getOrganSeq
	 * @Description: TODO(机构逐渐生成)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getOrganSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getOrganSeq");
	}

	/**
	 * @Title: getPlatformResourcesSeq
	 * @Description: TODO(平台资源)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getPlatformResourcesSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getPlatformResourcesSeq");
	}

	/**
	 * @Title: getTUserSeq
	 * @Description: 用户主键生成
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getTUserSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getTUserSeq");
	}

	/**
	 * @Title: getVISSeq
	 * @Description: 视屏服务器主键
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getVISSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getVISSeq");
	}

	/**
	 * @Title: getEpEventServerSeq
	 * @Description: 事件服务器主键生成
	 * @return String 返回类型
	 * @throws
	 */

	public String getEpEventServerSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpEventServerSeq");
	}

	/**
	 * @Title: getEpGatherServerSeq
	 * @Description: 采集服务器主键生成
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpGatherServerSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpGatherServerSeq");
	}

	/**
	 * @Title: getVideoDisPlayDeviceSeq
	 * @Description: 显示服务器主键生成
	 * @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getVideoDisPlayDeviceSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getVideoDisPlayDeviceSeq");
	}

	/**
	 * @Title: getAlarmOutputChannelSeq
	 * @Description: TODO(报警输出主键)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getAlarmOutputChannelSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getAlarmOutputChannelSeq");
	}

	/**
	 * @Title: getVideOutputChannelSeq
	 * @Description: 视频输出通道主键生成
	 * @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getVideOutputChannelSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getVideOutputChannelSeq");
	}

	public String getEpRoleSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpRoleSeq");
	}

	/**
	 * @Title: getEpIntelligentChannelSeq
	 * @Description: 智能分析单元主键生成@return
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpIntelligentChannelSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpIntelligentChannelSeq");
	}

	/**
	 * @Title: getEpRUserRoleSeq
	 * @Description: TODO(角色与用户关联逐渐生成)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpRUserRoleSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpRUserRoleSeq");
	}

	// /**
	// * @Title: getEpAssetsSeq
	// * @Description: 资产管理主键生成
	// * @return 设定文件
	// * @return String 返回类型
	// * @throws
	// */
	// public String getEpAssetsSeq() {
	// return (String) getSqlMapClientTemplate().queryForObject(
	// "SequenceSQL.getEpAssetsSeq");
	// }

	/**
	 * @Title: getEpDeviceSeq
	 * @Description: 电力设备主键生成
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpDeviceSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpDeviceSeq");
	}

	/**
	 * @Title: getEpRRoleOperationSeq
	 * @Description: TODO(角色与权限关联主键生成)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpRRoleOperationSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpRRoleOperationSeq");
	}

	/**
	 * @Title: getEpRAssetsSeq
	 * @Description: 获取资产管理和摄像头关系表ID
	 * @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpRAssetsSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpRAssetsSeq");
	}

	/**
	 * @Title: getEpRRoleResourceSeq
	 * @Description: TODO(角色与设备关联主键生成)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpRRoleResourceSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpRRoleResourceSeq");
	}

	/**
	 * @Title: getEpSchemeSeq
	 * @Description: 预案主键生成
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpSchemeSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpSchemeSeq");
	}

	/**
	 * @Title: getEpSchemeCommandSeq
	 * @Description: 预案动作主键生成
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpSchemeCommandSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpSchemeCommandSeq");
	}

	/**
	 * @Title: getEpRSchemeAlarmSourceSeq
	 * @Description: 绑定设备作为触发源的预案主键生成
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpRSchemeAlarmSourceSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpRSchemeAlarmSourceSeq");
	}

	/**
	 * getACLogSeq
	 * 
	 * @return
	 */
	public String getACLogSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getACLogSeq");
	}

	/**
	 * @Title: getAcEmployeesSeq
	 * @Description: 职员主键生成
	 * @return String 返回类型
	 * @throws
	 */
	public String getAcEmployeesSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getAcEmployeesSeq");
	}

	/**
	 * @Title: getEpRMapDeviceSeq
	 * @Description: TODO(地图与设备关联主键生成)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpRMapDeviceSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpRMapDeviceSeq");
	}

	/**
	 * @Title: getEpMonitorDeviceSeq
	 * @Description: 监控设备主键生成
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpMonitorDeviceSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpMonitorDeviceSeq");
	}

	/**
	 * @Title: getEpRMonitorDeviceSeq
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpRMonitorDeviceSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpRMonitorDeviceSeq");
	}

	/**
	 * @Title: getBranchSeq
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getBranchSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getBranchSeq");
	}

	/**
	 * 获取用户订阅表的下一个ID
	 * 
	 * @return
	 */
	public String getUserSubscribeSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getUserSubscribeSeq");
	}

	/**
	 * 获取平台订阅的下一个ID
	 * 
	 * @return
	 */
	public String getPlatformSubscribeSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getPlatformSubscribeSeq");
	}

	/**
	 * @Title: getEpControlServerSeq
	 * @Description: 自动生成太阳能控制器ID
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpControlServerSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpControlServerSeq");
	}

	/**
	 * @Title: getEpControlServerSeq
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpProberSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpProberSeq");
	}

	/**
	 * 
	 * @Title: getEpPresetSeq
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpPresetSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpPresetSeq");
	}

	public String getEpTaskSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpTaskSeq");
	}

	/**
	 * @Title: getEpTaskStepSeq
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpTaskStepSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpTaskStepSeq");
	}

	public String getEpRTaskStepMonitorSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpRTaskStepMonitorSeq");
	}

	/**
	 * 获取第三方平台（下级平台）的下一个ID
	 * 
	 * @return
	 */
	public String getThirdPartyPlatformSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getThirdPartyPlatformSeq");
	}

	/**
	 * 获取下级平台资源的下一个ID
	 * 
	 * @return
	 */
	public String getTempResourcesSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getTempResourcesSeq");
	}

	public String getEpRTaskEmployeeSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpRTaskEmployeeSeq");
	}

	/**
	 * @Title: getEpRProberVicSeq
	 * @Description: 探测器摄像头关系表生成
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpRProberVicSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpRProberVicSeq");
	}

	public String getEpTaskHistoryeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpTaskHistoryeq");
	}

	public String getEpTaskStepHistoryeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpTaskStepHistoryeq");
	}

	/**
	 * @Title: getAcAccessServersSeq
	 * @Description: 门禁控制器主键生成
	 * @return String 返回类型
	 * @throws
	 */
	public String getAcAccessServersSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getAcAccessServersSeq");
	}

	/**
	 * 
	 * getAcAccessServersSeq 门主键生成
	 * 
	 * @return String
	 */
	public String getAcAccessControlsSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getAcAccessControlsSeq");
	}

	/**
	 * getAcAccessControlsSeq 卡主键生成
	 * 
	 * @return String
	 */
	public String getAcAccessCardSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getAcAccessCardSeq");
	}

	/**
	 * 
	 * getAcAccessCardSeq 门和卡关系表主键生成
	 * 
	 * @return String
	 */
	public String getAcRDoorCardSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getAcRDoorCardSeq");
	}

	/**
	 * 
	 * @Title: getEpTaskInstanceSeq
	 * @Description: TODO(检查项id生成)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getEpTaskInstanceSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpTaskInstanceSeq");
	}

	/**
	 * 
	 * getAcREmployeeCardSeq 职工和卡关系表主键生成
	 * 
	 * @return String
	 */
	public String getAcREmployeeCardSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getAcREmployeeCardSeq");
	}
	
	/**
	 * 
	 * getEpRDoorVicSeq 门和摄像头关系表主键生成
	 * @return String
	 */
	public String getEpRDoorVicSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpRDoorVicSeq");
	}
	public String getIvuTaskSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getIvuTaskSeq");
	}

	/**
	 * 
	 * getSipServerSeq 信令网关ID主键生成
	 * @return String
	 */ 
	public String getSipServerSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
		"SequenceSQL.getSipServerSeq");
	}

	/**
	 * 
	 * getMediaGatewayServerSeq 媒体网关主键生成
	 * @return String
	 */
	public String getMediaGatewayServerSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
		"SequenceSQL.getMediaGatewayServerSeq");
	}
	
	/**
	 * 
	 * @Description: 视频服务器型号主键生成
	 * @author zhuanqi@megaeyes.com
	 * @param @return 
	 * @return String 
	 * @throws
	 */
	public String getVideoInputServerModelSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getVideoInputServerModelSeq");
	}
	/**
	 * 
	 * getEpClientGatewaySeq (客户端网管主键生成)
	 * @return
	 */
	public String getEpClientGatewaySeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
				"SequenceSQL.getEpClientGatewaySeq");
	}
	
	/**
	 * 
	 * @Description: 生成排班计划主键
	 * @author zhuanqi@megaeyes.com
	 * @param @return 
	 * @return String 
	 * @throws
	 */
	public String getAcEmployeeScheduleSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
		"SequenceSQL.getAcEmployeeScheduleSeq");
	}
	
	/**
	 * 
	 * @Description: 生成员工组主键
	 * @author zhuanqi@megaeyes.com
	 * @param @return 
	 * @return String 
	 * @throws
	 */
	public String getAcEmployeeGroupSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
		"SequenceSQL.getAcEmployeeGroupSeq");
	}
	
	/**
	 * 
	 * @Description: 生成员工-员工组关系主键
	 * @author zhuanqi@megaeyes.com
	 * @param @return 
	 * @return String 
	 * @throws
	 */
	public String getAcREmployeeGroupSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
		"SequenceSQL.getAcREmployeeGroupSeq");
	}
	
	/**
	 * 
	 * @Description: 生成排班计划-员工组主键
	 * @author zhuanqi@megaeyes.com
	 * @param @return 
	 * @return String 
	 * @throws
	 */
	public String getAcRScheduleGroupSeq() {
		return (String) getSqlMapClientTemplate().queryForObject(
		"SequenceSQL.getAcRScheduleGroupSeq");
	}
	
	/**
	 * 
	 * @Description: 生成员工请假记录主键 
	 * @author zhuanqi@megaeyes.com
	 * @param @return 
	 * @return String 
	 * @throws
	 */
	public String getAcEmployeeAbsentSeq(){
		return (String) getSqlMapClientTemplate().queryForObject(
		"SequenceSQL.getAcEmployeeAbsentSeq");
	}
	
	/**
	 * 
	 * @Description: 生成时间段规则主键 
	 * @author zhuanqi@megaeyes.com
	 * @param @return 
	 * @return String 
	 * @throws
	 */
	public String getAcWorkRuleSeq(){
		return (String) getSqlMapClientTemplate().queryForObject(
		"SequenceSQL.getAcWorkRuleSeq");
	}
	
	/**
	 * 
	 * @Description: 生成考情制度规则主键 
	 * @author zhuanqi@megaeyes.com
	 * @param @return 
	 * @return String 
	 * @throws
	 */
	public String getAcWorkAttendanceRuleSeq(){
		return (String) getSqlMapClientTemplate().queryForObject(
		"SequenceSQL.getAcWorkAttendanceRuleSeq");
	}
}
