package com.megaeyes.web.response;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.megaeyes.web.response.organdevicetree.BranchNode;
import com.megaeyes.web.response.organdevicetree.OrganBranchNode;

public class OrganBranchTreeResponse extends BaseResponse{

	private OrganBranchNode root;

	public OrganBranchNode getRoot() {
		return root;
	}

	public void setRoot(OrganBranchNode root) {
		this.root = root;
	}
	
	public static void main(String args[]){
		OrganBranchTreeResponse resp = new OrganBranchTreeResponse();
		OrganBranchNode root = new OrganBranchNode();
		root.setId("0000000000200090240000000001313");
		root.setName("测试机构");
		
	
		
		
		BranchNode rootBranch = new BranchNode();
		rootBranch.setId("0000000000200090240000000001315");
		rootBranch.setName("测试部门");
		

		BranchNode childBranch = new BranchNode();
		childBranch.setId("0000000000200090240000000001316");
		childBranch.setName("测试子部门");
		childBranch.setParentId("0000000000200090240000000001315");
		
		List<BranchNode> branchL = new ArrayList<BranchNode>();
		branchL.add(childBranch);
		rootBranch.setChildren(branchL);
		
		List<BranchNode> branchR = new ArrayList<BranchNode>();
		branchR.add(rootBranch);
		
		root.setBranchs(branchR);
		
		
		resp.setRoot(root);
		
		OrganBranchNode child = new OrganBranchNode();
		child.setId("0000000000200090240000000001314");
		child.setName("测试子机构");
		child.setParentId("0000000000200090240000000001313");
		child.setBranchs(branchR);
		
		List<OrganBranchNode> organL = new ArrayList<OrganBranchNode>();
		organL.add(child);
		root.setChildren(organL);
		String jsonRtn = JSONObject.fromObject(resp).toString();
		System.out.println(jsonRtn);
		
	}
}
