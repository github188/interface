/**   
 * @Title: MapManager.java 
 * @Package com.megaeyes.service.iface 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-4-25 上午9:31:06 
 * @version V1.0   
 */
package com.megaeyes.service.iface;

import java.sql.SQLException;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.EpMap;
import com.megaeyes.persistence.ibatis.model.EpRMapDevice;
import com.megaeyes.service.exception.BusinessException;

/**
 * @ClassName: MapManager
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-4-25 上午9:31:06
 * 
 */
public interface MapManager extends BaseManager {

	/**
	 * @Title: createEpMap
	 * @Description: TODO(创建电力地图)
	 * @param organId
	 *            地图所属的机构，对应于全球眼的ORGAN表
	 * @param name
	 *            地图名称
	 * @param type
	 *            地图类型
	 * @param note
	 *            备注
	 * @param image
	 *            图片二进制
	 * @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String createEpMap(String organId, String name, String type,
			String note, byte[] image);

	/**
	 * @Title: deleteEpMap
	 * @Description: TODO(删除地图)
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void deleteEpMap(String id);

	/**
	 * @Title: listEpMap
	 * @Description: TODO(查询地图列表)
	 * @param @param organId
	 * @param @return 设定文件
	 * @return List 返回类型
	 * @throws
	 */
	public List listEpMap(String organId);

	/**
	 * @Title: getEpMapImage
	 * @Description: TODO(查询地图图片)
	 * @param @param id
	 * @param @return 设定文件
	 * @return EpMap 返回类型
	 * @throws
	 */
	public EpMap getEpMap(String id);

	/**
	 * @Title: updateEpMap
	 * @Description: TODO(更新地图信息)
	 * @param @param id
	 * @param @param organId
	 * @param @param name
	 * @param @param type
	 * @param @param note
	 * @param @param image 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateEpMap(String id, String organId, String name,
			String type, String note, byte[] image);

	/**
	 * @Title: editEpEpRMapDevice
	 * @Description: TODO(编辑地图与设备的呈现关系，如果不存在则增加一条记录，如果已经存在则修改)
	 * @param mapId
	 *            地图ID
	 * @param deviceId
	 *            设备ID,或子地图ID
	 * @param deviceType
	 *            设备类型
	 * @param x
	 *            设备或子地图在地图上的横坐标
	 * @param y
	 *            设备或子地图在地图上纵坐标
	 * @param left
	 *            设备或子地图在地图上的左
	 * @param right
	 *            设备或子地图在地图上的右
	 * @param top
	 *            设备或子地图在地图上的上
	 * @param bottom
	 *            设备或子地图在地图上的下
	 * @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String createEpEpRMapDevice(String epMapId, String deviceId,
			Short deviceType, String coordinateX, String coordinateY,
			String left, String right, String top, String bottom);

	/**
	 * @Title: deleteEpEpRMapDevice
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void deleteEpRMapDevice(String id);
	/**
	* @Title: getEpRMapDevice 
	* @Description: TODO(根据id查询设备) 
	* @param @param id
	* @param @return    设定文件 
	* @return EpRMapDevice    返回类型 
	* @throws
	 */
	public List<EpRMapDevice> ListEpRMapDeviceByMapId(String id);
	
	/**
	 * @Title: editEpEpRMapDevice
	 * @Description: TODO(更新地图与设备的呈现关系)
	 * @param mapId
	 *            地图ID
	 * @param deviceId
	 *            设备ID,或子地图ID
	 * @param deviceType
	 *            设备类型
	 * @param x
	 *            设备或子地图在地图上的横坐标
	 * @param y
	 *            设备或子地图在地图上纵坐标
	 * @param left
	 *            设备或子地图在地图上的左
	 * @param right
	 *            设备或子地图在地图上的右
	 * @param top
	 *            设备或子地图在地图上的上
	 * @param bottom
	 *            设备或子地图在地图上的下
	 * @param deleteFlag
	 *            表示是否是删除这对绑定关系
	 * @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public void updateEpRMapDevice(String id,String epMapId, String deviceId,
			Short deviceType, String coordinateX, String coordinateY,
			String left, String right, String top, String bottom);
}
