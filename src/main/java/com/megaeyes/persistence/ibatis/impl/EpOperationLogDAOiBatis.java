/**   
 * @Title: EpOperationLogDAOiBatis.java 
 * @Package com.megaeyes.persistence.ibatis.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-3-7 上午7:04:52 
 * @version V1.0   
 */
package com.megaeyes.persistence.ibatis.impl;

import java.util.List;

import com.megaeyes.persistence.ibatis.iface.EpOperationLogDAOImpl;
import com.megaeyes.persistence.ibatis.model.EpOperationLog;
import com.megaeyes.persistence.ibatis.vo.EpOperationLogVO;

/**
 * @ClassName: EpOperationLogDAOiBatis
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-3-7 上午7:04:52
 * 
 */
public class EpOperationLogDAOiBatis extends EpOperationLogDAOImpl {

	public List<EpOperationLog> listEpOperationLog(EpOperationLogVO vo) {
		return getSqlMapClientTemplate().queryForList(
				"EP_OPERATION_LOG_VIEW.listEpOperationLog",vo);
	}
}
