/**   
 * @Title: EpPresetManager.java 
 * @Package com.megaeyes.service.iface 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-4 下午3:42:19 
 * @version V1.0   
 */
package com.megaeyes.service.iface;

import java.math.BigDecimal;
import java.util.List;

import org.json.JSONException;

import com.megaeyes.persistence.ibatis.model.EpPreset;
import com.megaeyes.service.exception.BusinessException;

/**
 * @ClassName: EpPresetManager
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-4 下午3:42:19
 * 
 */
public interface EpPresetManager extends BaseManager {

	/**
	 * @Title: listEpPresetByVicId
	 * @Description: TODO(根据视频ID查询预置点)
	 * @param vicId
	 * @return 设定文件
	 * @return List<EpPreset> 返回类型
	 * @throws
	 */
	public List<EpPreset> listEpPresetByVicId(String vicId);

	/**
	 * @throws JSONException
	 * @Title: addOrUpdateEpPreset
	 * @Description: TODO(增加、删除、修改预置点)
	 * @param @param jsonString 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void addOrUpdateEpPreset(String jsonString) throws JSONException;

	/**
	 * 添加预置点
	 * 
	 * @param name
	 *            预置点名称
	 * @param presetNumber
	 *            预置点编号
	 * @param vicId
	 *            摄像头ID
	 * @param setFlag
	 *            是否默认预置点
	 * @return 创建成功的ID
	 * @throws BusinessException
	 */
	public String addEpPreset(String name, short presetNumber, String vicId,
			BigDecimal setFlag) throws BusinessException;

	/**
	 * 删除预置点
	 * 
	 * @param id
	 *            预置点ID
	 * @throws BusinessException
	 */
	public void deleteEpPreset(String id) throws BusinessException;
}
