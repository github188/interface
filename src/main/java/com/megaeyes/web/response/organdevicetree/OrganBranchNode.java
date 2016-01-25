package com.megaeyes.web.response.organdevicetree;

import java.util.ArrayList;
import java.util.List;

public class OrganBranchNode {
	private String id;//机构ID
	private String type = "1";//节点类型:1 机构,2部门
	private String name;//机构名称
	private String parentId;//父机构ID
	
	private List<OrganBranchNode> children = new ArrayList<OrganBranchNode>();
	private List<BranchNode> branchs = new ArrayList<BranchNode>();
	
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
	public List<OrganBranchNode> getChildren() {
		return children;
	}
	public void setChildren(List<OrganBranchNode> children) {
		this.children = children;
	}
	public List<BranchNode> getBranchs() {
		return branchs;
	}
	public void setBranchs(List<BranchNode> branchs) {
		this.branchs = branchs;
	}
	
	public static OrganBranchNode generateTree(List<OrganBranchNode> nodes, OrganBranchNode root) {
		for (OrganBranchNode node : nodes) {
			if (root.getId().equals(node.getParentId())) {
				OrganBranchNode newNode = new OrganBranchNode();
				newNode.setId(node.getId());
				newNode.setName(node.getName());
				newNode.setParentId(node.getParentId());
				newNode.setBranchs(node.getBranchs());
				root.getChildren().add(newNode);
				
				generateTree(nodes, newNode);
			}
		}
		return root;
	}
}
