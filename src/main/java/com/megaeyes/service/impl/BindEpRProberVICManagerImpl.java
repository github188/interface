/**   
* @Title: BindEpRProberVICManagerImpl.java 
* @Package com.megaeyes.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-5-14 上午2:14:32 
* @version V1.0   
*/ 
package com.megaeyes.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.EpRProberVicDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.EpRProberVic;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.BindEpRProberVICManager;

/** 
 * @ClassName: BindEpRProberVICManagerImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-5-14 上午2:14:32 
 *  
 */
public class BindEpRProberVICManagerImpl extends BaseManagerImpl implements
		BindEpRProberVICManager {
	@Autowired
	EpRProberVicDAOiBatis epRProberVicDAO;
	@Autowired
	SequenceDAOiBatis sequenceDAO;
	
	@Override
	public void deleteByProberId(String proberId) {
		if(StringUtils.isBlank(proberId)){
			throw new BusinessException("id",ErrorCode.PARAMETER_NOT_FOUND);
		}
		epRProberVicDAO.deleteByProberId(proberId);
	}

	@Override
	public void bindEpRProberVIC(String proberId, String vicId) {
		if(StringUtils.isBlank(proberId)){
			throw new BusinessException("proberId",ErrorCode.PARAMETER_NOT_FOUND);
		}
		String id = sequenceDAO.getEpRProberVicSeq();
		EpRProberVic erpv = new EpRProberVic();
		erpv.setId(id);
		erpv.setProberId(proberId);
		erpv.setVicId(vicId);
		epRProberVicDAO.insert(erpv);
	}

}
