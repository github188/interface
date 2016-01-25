package com.megaeyes.service.iface;

import java.util.List;

import com.megaeyes.persistence.ibatis.model.VideoDisplayDevice;
import com.megaeyes.persistence.ibatis.model.VideoOutputChannel;
import com.megaeyes.persistence.ibatis.model.VideoOutputChannelModel;
import com.megaeyes.service.exception.BusinessException;

/**
 * VOCManager(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-6-19 上午02:03:23
 */
public interface VOCManager extends BaseManager {


	/**
	 * @Title: createVoc
	 * @Description: 创建视频输出通道
	 * @param name
	 *            视频输出通道名称
	 * @param naming
	 *            视频输出通道naming信息
	 * @param installLocation
	 *            安装地址
	 * @param note
	 *            备注
	 * @param displayId
	 *            显示服务器ID
	 * @param modelId
	 *            视频输出通道模型ID
	 * @param dispatchServer
	 *            分发服务器ID
	 * @param organId
	 *            机构ID
	 * @param addressNumber
	 *            地址编号
	 * @param isShare
	 *            是否共享
	 * @param stdId
	 *            业务编码
	 * @return String 返回类型
	 * @throws BusinessException
	 */
	public String createVOC(String name, String naming, String installLocation,
			String note, String displayId, String modelId,
			String dispatchServer, String organId, String addressNumber,
			Integer isShare, String stdId) throws BusinessException;
	
	/**
	 * @Title: deleteVoc
	 * @Description: 删除视频输出通道
	 * @param id
	 *            设定文件
	 * @return void 返回类型
	 * @throws BusinessException
	 */
	public void deleteVOC(String id) throws BusinessException;

	/**
	 * @Title: listVoc
	 * @Description: 根据显示服务器ID查询视频输出通道列表
	 * @return List<VideoOutputChannel> 返回类型
	 * @throws BusinessException
	 */
	public List<VideoOutputChannel> listVocByDisplayId(String displayId)
			throws BusinessException;

	/**
	 * @Title: listVocByOrganId
	 * @Description: 根据机构ID查询视频输出通道列表
	 * @param organId
	 * @return List<VideoOutputChannel> 返回类型
	 * @throws BusinessException
	 */
	public List<VideoOutputChannel> listVocByOrganId(String organId)
			throws BusinessException;

	/**
	 * @Title: getVoc
	 * @Description: 根据视频输出通道ID查询
	 * @param id
	 * @return VideoOutputChannel 返回类型
	 * @throws BusinessException
	 */
	public VideoOutputChannel getVOC(String id) throws BusinessException;

	/**
	 * @Title: updateVoc
	 * @Description: 更新视频输出通道
	 * @param id
	 *            视频输出通道ID
	 * @param name
	 *            视频输出通道名称
	 * @param naming
	 *            视频输出通道naming信息
	 * @param installLocation
	 *            安装地址
	 * @param note
	 *            备注
	 * @param displayId
	 *            显示服务器ID
	 * @param modelId
	 *            视频输出通道模型ID
	 * @param dispatchServer
	 *            分发服务器ID
	 * @param organId
	 *            机构ID
	 * @param addressNumber
	 *            地址编号
	 * @param isShare
	 *            是否共享
	 * @param stdId
	 *            业务编码
	 * @return void 返回类型
	 * @throws BusinessException
	 */
	public void updateVOC(String id, String name, String naming,
			String installLocation, String note, String displayId,
			String modelId, String dispatchServer, String organId,
			String addressNumber, int isShare, String stdId)
			throws BusinessException;
	
	/**
	 * @Title: createVideoDisplayDevice
	 * @Description: 创建显示服务器
	 * @param name
	 *            显示服务器名称
	 * @param naming
	 *            显示服务器naming信息
	 * @param installLocation
	 *            安裝地址
	 * @param note
	 *            备注
	 * @param deviceNumber
	 *            物理编号
	 * @param ip
	 *            显示服务器IP
	 * @param linkType
	 *            连接方式
	 * @param heartCycle
	 *            心跳周期
	 * @param rebootTime
	 *            重启时间
	 * @param rebootCycle
	 *            重启周期
	 * @param videoIntputAmount
	 *            视频通道输入数量
	 * @param videoOutputAmount
	 *            视频通道输出数量
	 * @param companyId
	 *            机构ID
	 * @return String 返回类型
	 * @throws BusinessException
	 */
	public String createVideoDisplayDevice(String name, String naming,
			String installLocation, String note, String deviceNumber,
			String ip, String linkType, Long heartCycle, String rebootTime,
			Long rebootCycle, String organId) throws BusinessException;

	/**
	 * @Title: deleteVideoDisplayDevice
	 * @Description: 根据ID删除显示服务器
	 * @param id
	 *            显示服务器ID
	 * @throws BusinessException
	 *             设定文件
	 * @return void 返回类型
	 */
	public void deleteVideoDisplayDevice(String id) throws BusinessException;

	/**
	 * @Title: listVideoDisplayDevice
	 * @Description: 查询所有显示服务器列表
	 * @param organId
	 *            机构ID
	 * @throws BusinessException
	 *             设定文件
	 * @return List<VideoDisplayDevice> 返回类型
	 */
	public List<VideoDisplayDevice> listVideoDisplayDeviceByOrganId(
			String organId) throws BusinessException;

	/**
	 * @Title: getVideoDisplayDevice
	 * @Description: 根据ID查询显示服务器
	 * @param id
	 *            显示服务器ID
	 * @throws BusinessException
	 *             设定文件
	 * @return VideoDisplayDevice 返回类型
	 */
	public VideoDisplayDevice getVideoDisplayDevice(String id)
			throws BusinessException;

	/**
	 * @Title: updateVideoDisplayDevice
	 * @Description: 更新显示服务器
	 * @param id
	 *            显示服务器ID
	 * @param name
	 *            显示服务器名称
	 * @param naming
	 *            显示服务器naming信息
	 * @param installLocation
	 *            安装地址
	 * @param note
	 *            备注
	 * @param deviceNumber
	 *            物理编码
	 * @param ip
	 *            显示服务器IP
	 * @param linkType
	 *            连接方式
	 * @param heartCycle
	 *            心跳周期
	 * @param rebootTime
	 *            重启时间
	 * @param rebootCycle
	 *            重启周期
	 * @param videoIntputAmount
	 *            视频输入通道
	 * @param videoOutputAmount
	 *            视频输出通道
	 * @param companyId
	 *            机构ID
	 * @throws BusinessException
	 *             设定文件
	 * @return void 返回类型
	 */
	public void updateVideoDisplayDevice(String id, String name, String naming,
			String installLocation, String note, String deviceNumber,
			String ip, String linkType, Long heartCycle, String rebootTime,
			Long rebootCycle, String organId) throws BusinessException;
	/**
	 * @Title: listDDS
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return List<VideoDisplayDevice> 返回类型
	 * @throws
	 */
	public List<VideoDisplayDevice> listDDS();
	
	/**
	 * 
	 * listVOCModel 查询视频输出通道类型
	 * @return List<VideoOutputChannelModel>
	 */
	public List<VideoOutputChannelModel> listVOCModel();
	/**
	 * 
	* @Title: listVOCByOrganIdWithChild 
	* @Description: 查询本机构以及子机构下的所有视频输出通道
	* @param @param organId
	* @param @return    设定文件 
	* @return List<VideoOutputChannel>    返回类型 
	* @throws
	 */
	public List<VideoOutputChannel> listVOCByOrganIdWithChild(String organId);
	
	/**
	 * 
	 * @Description: 根据主键更新VOC信息
	 * @author zhuanqi@megaeyes.com
	 * @param  
	 * @return void 
	 * @throws
	 */
	public void updateByPrimaryKeySelective(VideoOutputChannel voc);
}
