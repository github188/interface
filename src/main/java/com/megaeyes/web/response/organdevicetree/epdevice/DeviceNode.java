/**   
* @Title: DeviceNode.java 
* @Package com.megaeyes.web.response.organdevicetree.epdevice 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liugaofeng liugaofeng@megaeyes.com   
* @date 2012-5-9 下午5:17:51 
* @version V1.0   
*/ 
package com.megaeyes.web.response.organdevicetree.epdevice;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.megaeyes.persistence.ibatis.model.EpDevice;
import com.megaeyes.service.exception.BusinessException;

/** 
 * @ClassName: DeviceNode 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author liugaofeng liugaofeng@megaeyes.com 
 * @date 2012-5-9 下午5:17:51 
 *  
 */
public class DeviceNode {
	private String id;
	
	private String name;
	
	private String type;
	
	private String parentId;
	
	private String operation;
	
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	private List<DeviceNode> children = new ArrayList();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<DeviceNode> getChildren() {
		return children;
	}

	public void setChildren(List<DeviceNode> children) {
		this.children = children;
	}
	
	public static DeviceNode generateTree(List<EpDevice> nodes, DeviceNode root) {
		for (EpDevice node : nodes) {
			if (root.getId().equals(node.getParentId())) {				
				DeviceNode newNode = new DeviceNode();
				newNode.setId(node.getId());
				newNode.setName(node.getName());				
				newNode.setType(node.getType().toString());
				newNode.setParentId(node.getParentId());
				newNode.setOperation(node.getOperation());
				root.getChildren().add(newNode);
				generateTree(nodes, newNode);
			}
		}
		return root;
		
	}
}
