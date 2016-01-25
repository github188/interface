package com.megaeyes.web.response.organdevicetree;

import java.util.ArrayList;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.Branch;

public class BranchNode {
	private String id;
	private String name;
	private String type = "2";
	private String parentId;
	private String organId;
	
	public String getOrganId() {
		return organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	private List<BranchNode> children = new ArrayList<BranchNode>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<BranchNode> getChildren() {
		return children;
	}

	public void setChildren(List<BranchNode> children) {
		this.children = children;
	}

	public static BranchNode generateTree(List<Branch> nodes, BranchNode root) {
		for (Branch node : nodes) {
			if (root.getId().equals(node.getParentId())) {
				BranchNode newNode = new BranchNode();
				newNode.setId(node.getId());
				newNode.setName(node.getName());
				newNode.setParentId(node.getParentId());
				newNode.setOrganId(node.getOrganId());
				root.getChildren().add(newNode);
				generateTree(nodes, newNode);
			}
		}
		return root;

	}
}
