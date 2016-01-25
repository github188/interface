/**   
 * @Title: BranchController.java 
 * @Package com.megaeyes.web.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangjianyang tangjianyang@megaeyes.com   
 * @date 2012-5-3 下午1:49:58 
 * @version V1.0   
 */
package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test.StringUtil;

import com.megaeyes.persistence.ibatis.model.Branch;
import com.megaeyes.persistence.ibatis.model.Organ;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.BranchManager;
import com.megaeyes.service.iface.OrganManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListBranchResponse;
import com.megaeyes.web.response.OrganBranchTreeResponse;
import com.megaeyes.web.response.organdevicetree.BranchNode;
import com.megaeyes.web.response.organdevicetree.OrganBranchNode;

/**
 * @ClassName: BranchController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tangjianyang tangjianyang@megaeyes.com
 * @date 2012-5-3 下午1:49:58
 * 
 */
@Controller
public class BranchController extends BaseController {
	@Autowired
	OrganManager organManager;
	@Autowired
	BranchManager branchManager;

	@ControllerDescription(description = "创建部门", isLog = true, isCheckSession = true)
	@RequestMapping("/createBranch.json")
	public void createBranch(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		String name = (String) request.getAttribute("name");
		String organId = (String) request.getAttribute("organId");
		String parentId = (String)request.getAttribute("parentId");
		String person = (String) request.getAttribute("person");
		String contact = (String) request.getAttribute("contact");
		try {
			String id = branchManager.careateBranch(name, organId, person, contact,parentId);
			resp.setCode(ErrorCode.SUCCESS);
			resp.setMessage(id);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "删除部门", isLog = true, isCheckSession = true)
	@RequestMapping("/deleteBranch.json")
	public void deleteEmployees(HttpServletRequest request,
			HttpServletResponse response) {
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try {
			branchManager.deleteBranch(id);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "根据机构查询部门", isLog = false, isCheckSession = true)
	@RequestMapping("/listBranchByOrganId.json")
	public void listBranchByOrganId(HttpServletRequest request,
			HttpServletResponse response) {
		ListBranchResponse resp = new ListBranchResponse();
		String organId = (String) request.getAttribute("organId");
		try {
			List<Branch> list = branchManager.listBranchByOrganId(organId);
			resp.setList(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	@ControllerDescription(description = "更新部门", isLog = false, isCheckSession = true)
	@RequestMapping("/updateBranch.json")
	public void updateBranch(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String organId = (String) request.getAttribute("organId");
		String person = (String) request.getAttribute("person");
		String contact = (String) request.getAttribute("contact");
		try {
			branchManager.updateBranch(id, name, organId, person, contact);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	@ControllerDescription(description = "根据机构ID查询机构设备树", isLog = false, isCheckSession = true)
	@RequestMapping("/getOrganBranchTreeByOrganId.json")
	public void getOrganBranchTreeByOrganId(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		OrganBranchTreeResponse resp = new OrganBranchTreeResponse();
		String organId = (String) request.getAttribute("organId");
		try {
			List<Organ> organs = organManager.listAllChildren(organId, true);// 获取所有的子机构
			
			OrganBranchNode root = new OrganBranchNode();// 根机构
			List<OrganBranchNode> nodes = new ArrayList<OrganBranchNode>();
			for (Organ organ : organs) {
				if (organId.equals(organ.getId())) {
					//生成根机构
					root.setId(organ.getId());
					root.setName(organ.getName());
					root.setParentId(organ.getParentOrganId());
					
					//查询本机构下所有子部门
					List<Branch> branchs = branchManager.listBranchByOrganId(organId);
					List<BranchNode> branchNodes = new ArrayList<BranchNode>();
					for(Branch branch:branchs){
						if(StringUtil.isBlank(branch.getParentId())){
							BranchNode rootBranch = new BranchNode();
							rootBranch.setId(branch.getId());
							rootBranch.setName(branch.getName());
							rootBranch.setOrganId(branch.getOrganId());
							//组装部门树
							BranchNode branchTree = BranchNode.generateTree(branchs, rootBranch);
							branchNodes.add(branchTree);
						}
					}
					root.setBranchs(branchNodes);
				}else{
					OrganBranchNode node = new OrganBranchNode();
					node.setId(organ.getId());
					node.setName(organ.getName());
					node.setParentId(organ.getParentOrganId());
					
					//查询本机构下所有子部门
					List<Branch> branchs = branchManager.listBranchByOrganId(node.getId());
					List<BranchNode> branchNodes = new ArrayList<BranchNode>();
					for(Branch branch:branchs){
						if(StringUtil.isBlank(branch.getParentId())){
							BranchNode rootBranch = new BranchNode();
							rootBranch.setId(branch.getId());
							rootBranch.setName(branch.getName());
							rootBranch.setOrganId(branch.getOrganId());
							//组装部门树
							BranchNode branchTree = BranchNode.generateTree(branchs, rootBranch);
							branchNodes.add(branchTree);
						}
					}
					node.setBranchs(branchNodes);
					nodes.add(node);
				}
			}
			OrganBranchNode tree = new OrganBranchNode();
			tree = OrganBranchNode.generateTree(nodes, root);
			resp.setRoot(tree);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	

	@ControllerDescription(description = "根据部门ID查询部门列表", isLog = false, isCheckSession = true)
	@RequestMapping("/getBranchListByBranchId.json")
	public void getBranchListByBranchId (HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String branchId = (String) request.getAttribute("branchId");
		ListBranchResponse resp = new ListBranchResponse();
		try {
			List<Branch> list = branchManager.getBranchListByBranchId(branchId);
			resp.setList(list);
			resp.setCode(ErrorCode.SUCCESS);
		} catch (BusinessException be) {
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
}
