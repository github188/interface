/**   
 * @Title: EpPresetManagerImpl.java 
 * @Package com.megaeyes.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-4 下午3:45:38 
 * @version V1.0   
 */
package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.EpPresetDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.EpPreset;
import com.megaeyes.persistence.ibatis.model.EpPresetExample;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.EpPresetManager;

/**
 * @ClassName: EpPresetManagerImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-4 下午3:45:38
 * 
 */
public class EpPresetManagerImpl extends BaseManagerImpl implements
		EpPresetManager {
	@Autowired
	EpPresetDAOiBatis epPresetDAO;
	@Autowired
	SequenceDAOiBatis sequenceDAO;

	public List<EpPreset> listEpPresetByVicId(String vicId) {
		if (StringUtils.isBlank(vicId)) {
			throw new BusinessException("vicId", ErrorCode.PARAMETER_NOT_FOUND);
		}
		List<EpPreset> list = epPresetDAO.listEpPresetByVicId(vicId);
		return list;
	}

	public void addOrUpdateEpPreset(String jsonString) throws JSONException {
		if (StringUtils.isBlank(jsonString)) {
			throw new BusinessException("jsonString",
					ErrorCode.PARAMETER_NOT_FOUND);
		}
		JSONObject jsonObject = new JSONObject(jsonString);
		String vicId = jsonObject.getString("vicId");
		epPresetDAO.deleteByvicId(vicId);
		JSONArray jsonArray = jsonObject.getJSONArray("presets");
		if (jsonArray.length() > 0) {
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObj = new JSONObject(jsonArray.getString(i));
				String name = jsonObj.getString("name");
				String note = jsonObj.getString("note");
				String presetNumberstr = jsonObj.getString("presetNumber");
				Short presetNumber;
				try {
					presetNumber = Short.valueOf(presetNumberstr);
				} catch (Exception e) {
					throw new BusinessException("presetNumber",
							ErrorCode.AC_PARAMETER_INVALID);
				}
				String setFlagstr = jsonObj.getString("setFlag");
				BigDecimal setFlag;
				try {
					setFlag = new BigDecimal(setFlagstr);
				} catch (Exception e) {
					throw new BusinessException("setFlag",
							ErrorCode.AC_PARAMETER_INVALID);
				}
				EpPreset epPreset = new EpPreset();
				String id = sequenceDAO.getEpPresetSeq();
				epPreset.setId(id);
				epPreset.setVicId(vicId);
				epPreset.setName(name);
				epPreset.setNote(note);
				epPreset.setPresetNumber(Short.valueOf(presetNumber));
				epPreset.setSetFlag(setFlag);
				epPresetDAO.insert(epPreset);
			}
		}
	}

	public String addEpPreset(String name, short presetNumber, String vicId,
			BigDecimal setFlag) throws BusinessException {
		// 同一个摄像头的预置点名称不能重复
		EpPresetExample example = new EpPresetExample();
		EpPresetExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		criteria.andVicIdEqualTo(vicId);
		List<EpPreset> list = epPresetDAO.selectByExample(example);
		if (list.size() > 0) {
			throw new BusinessException(name, ErrorCode.NAME_EXIST);
		}
		
		EpPreset epPreset = new EpPreset();
		String id = sequenceDAO.getEpPresetSeq();
		epPreset.setId(id);
		epPreset.setVicId(vicId);
		epPreset.setName(name);
		epPreset.setPresetNumber(presetNumber);
		epPreset.setSetFlag(setFlag);
		epPresetDAO.insert(epPreset);
		return id;
	}

	public void deleteEpPreset(String id) throws BusinessException {
		epPresetDAO.deleteByPrimaryKey(id);
	}

}
