/**   
 * @Title: Node.java 
 * @Package com.megaeyes.web.response.organdevicetree 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author liugaofeng liugaofeng@megaeyes.com   
 * @date 2012-3-21 下午4:04:58 
 * @version V1.0   
 */
package com.megaeyes.web.response.organdevicetree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Node
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liugaofeng liugaofeng@megaeyes.com
 * @date 2012-3-21 下午4:04:58
 * 
 */
public class OrganNode {
	private String name;

	private String id;

	private String parentId;

	private List<OrganNode> children = new ArrayList();

	private List<VicNode> vics = new ArrayList();

	private List<AicNode> aics = new ArrayList();

	private List<AocNode> aocs = new ArrayList();

	private List<ProberNode> probers = new ArrayList();

	private List<VocNode> vocs = new ArrayList();

	private List<DoorNode> doors = new ArrayList<DoorNode>();

	// private List<>

	public List<VocNode> getVocs() {
		return vocs;
	}

	public void setVocs(List<VocNode> vocs) {
		this.vocs = vocs;
	}

	public List<ProberNode> getProbers() {
		return probers;
	}

	public void setProbers(List<ProberNode> probers) {
		this.probers = probers;
	}

	public List<AicNode> getAics() {
		return aics;
	}

	public void setAics(List<AicNode> aics) {
		this.aics = aics;
	}

	public List<AocNode> getAocs() {
		return aocs;
	}

	public void setAocs(List<AocNode> aocs) {
		this.aocs = aocs;
	}

	public List<VicNode> getVics() {
		return vics;
	}

	public void setVics(List<VicNode> vics) {
		this.vics = vics;
	}

	public List<OrganNode> getChildren() {
		return children;
	}

	public void setChildren(List<OrganNode> children) {
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<DoorNode> getDoors() {
		return doors;
	}

	public void setDoors(List<DoorNode> doors) {
		this.doors = doors;
	}

	public static OrganNode generateTree(List<OrganNode> nodes, OrganNode root) {
		for (OrganNode node : nodes) {
			if (root.getId().equals(node.getParentId())) {
				OrganNode newNode = new OrganNode();
				newNode.setId(node.getId());
				newNode.setName(node.getName());
				newNode.setVics(node.getVics());
				newNode.setAics(node.getAics());
				newNode.setAocs(node.getAocs());
				newNode.setProbers(node.getProbers());
				newNode.setVocs(node.getVocs());
				newNode.setDoors(node.getDoors());
				root.getChildren().add(newNode);
				generateTree(nodes, newNode);
			}
		}
		return root;

	}
}
