package com.megaeyes.web.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.megaeyes.persistence.ibatis.model.AcAccessCards;
import com.megaeyes.persistence.ibatis.vo.ListCardAndEmployeeVO;
import com.megaeyes.persistence.ibatis.vo.ListEmployeesAndCardVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AcAccessCardManager;
import com.megaeyes.web.aop.annotation.ControllerDescription;
import com.megaeyes.web.response.AcAccessCardsResponse;
import com.megaeyes.web.response.BaseResponse;
import com.megaeyes.web.response.ListAcAccessCardsResponse;
import com.megaeyes.web.response.ListCardAndEmployeeResponse;
import com.megaeyes.web.response.ListEmployeesAndCardResponse;

/**
 * AcAccessCardsController(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-5-16 上午01:39:31
 */
@Controller
public class AcAccessCardsController extends BaseController {
	@Autowired
	AcAccessCardManager acAccessCardManager;
	
	/**
	 * createAcAccessCards 创建卡
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 */
	@ControllerDescription(description="创建卡",isLog=true,isCheckSession=true)
	@RequestMapping("/createAcAccessCards.json")
	public void createAcAccessCards(HttpServletRequest request,
			HttpServletResponse response)throws UnsupportedEncodingException{
		BaseResponse resp = new BaseResponse();		
		request.setCharacterEncoding("UTF-8");
		String name = (String) request.getAttribute("name");
		String cardNumber = (String) request.getAttribute("cardNumber");
		String note = (String) request.getAttribute("note");
		String status = "2";
		String status1 = (String) request.getAttribute("status");
		if(StringUtils.isNotBlank(status1)){
			status = status1;
		}
		String password = (String) request.getAttribute("password");
		BigDecimal expireDate = null;
		String expireDate1 = (String) request.getAttribute("expireDate");
		if(StringUtils.isNotBlank(expireDate1)){
			try{
				expireDate = new BigDecimal(expireDate1);
			}catch(NumberFormatException be){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("expireDate");
			}
		}
		String organId = (String) request.getAttribute("organId");
		
		if(resp.getCode().equals(ErrorCode.SUCCESS)){
			try{
				String id = acAccessCardManager.createAcAccessCards(name,cardNumber,note,status,password,expireDate,organId);
				resp.setCode(ErrorCode.SUCCESS);
				resp.setMessage(id);
			}catch(BusinessException be){
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}
	
	/**
	 * deleteAcAccessCards 删除卡
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description="删除卡",isLog=true,isCheckSession=true)
	@RequestMapping("/deleteAcAccessCards.json")
	public void deleteAcAccessCards(HttpServletRequest request,
			HttpServletResponse response){
		BaseResponse resp = new BaseResponse();
		String id = (String) request.getAttribute("id");
		try{
			acAccessCardManager.deleteAcAccessCards(id);
			resp.setCode(ErrorCode.SUCCESS);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	/**
	 * updateAcAccessCards 更新卡
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 */
	@ControllerDescription(description="更新卡",isLog=false,isCheckSession=true)
	@RequestMapping("/updateAcAccessCards.json")
	public void updateAcAccessCards(HttpServletRequest request,
			HttpServletResponse response)throws UnsupportedEncodingException{
		BaseResponse resp = new BaseResponse();		
		request.setCharacterEncoding("UTF-8");
		String id = (String) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		String cardNumber = (String) request.getAttribute("cardNumber");
		String note = (String) request.getAttribute("note");
		String status = "2";
		String status1 = (String) request.getAttribute("status");
		if(StringUtils.isNotBlank(status1)){
			status = status1;
		}
		String password = (String) request.getAttribute("password");
		BigDecimal expireDate = null;
		String expireDate1 = (String) request.getAttribute("expireDate");
		if(StringUtils.isNotBlank(expireDate1)){
			try{
				expireDate = new BigDecimal(expireDate1);
			}catch(NumberFormatException be){
				resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
				resp.setMessage("expireDate");
			}
		}
		String organId = (String) request.getAttribute("organId");
		
		if(resp.getCode().equals(ErrorCode.SUCCESS)){
			try{
				acAccessCardManager.updateAcAccessCards(id,name,cardNumber,note,status,password,expireDate,organId);
				resp.setCode(ErrorCode.SUCCESS);
			}catch(BusinessException be){
				resp.setCode(be.getCode());
				resp.setMessage(be.getMessage());
			}
		}
		writePageNoZip(response, resp);
	}
	
	/**
	 * 
	 * listAcAccessCards 查询卡列表
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description="查询卡列表",isLog=false,isCheckSession=true)
	@RequestMapping("/listAcAccessCards.json")
	public void listAcAccessCards(HttpServletRequest request,
			HttpServletResponse response){
		ListAcAccessCardsResponse resp = new ListAcAccessCardsResponse();
		try{
			List<AcAccessCards> aac = acAccessCardManager.listAcAccessCards();
			resp.setCode(ErrorCode.SUCCESS);
			resp.setAcAccessCards(aac);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	
	/**
	 * 
	 * getCardByCardNumber 根据卡号查询卡
	 * @param request
	 * @param response
	 */


	public void getCardByCardNumber(HttpServletRequest request,
			HttpServletResponse response){
		AcAccessCardsResponse resp = new AcAccessCardsResponse();
		String cardNumber = (String) request.getAttribute("cardNumber");
		try{
			AcAccessCards aac = acAccessCardManager.getCardByCardNumber(cardNumber);
			if(null!= aac){
				resp.setCode(ErrorCode.SUCCESS);
				resp.setId(aac.getId());
				resp.setName(aac.getName());
				resp.setCardNumber(aac.getCardNumber());
				resp.setNote(aac.getNote());
				resp.setStatus(aac.getStatus());
				resp.setPassword(aac.getPassword());
				resp.setExpireDate(aac.getExpireDate());
				resp.setOrganId(aac.getOrganId());
			}
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	/**
	 *
	 * bindAcRDoorCard 绑定门和卡
	 * @param request
	 * @param response
	 * @throws JSONException
	 */
	@ControllerDescription(description="绑定门和卡",isLog=false,isCheckSession=true)
	@RequestMapping("/bindAcRDoorCard.json")
	public void bindAcRDoorCard(HttpServletRequest request,
			HttpServletResponse response)throws JSONException{
		BaseResponse resp = new BaseResponse();
		String jsonString = (String) request.getAttribute("jsonString");
		if(StringUtils.isBlank(jsonString)){
			throw new BusinessException("jsonString",ErrorCode.PARAMETER_NOT_FOUND);
		}
		Long authorizeTime1 = System.currentTimeMillis();
		BigDecimal authorizeTime = new BigDecimal(authorizeTime1);
		BigDecimal authorizeType = new BigDecimal(0);
		BigDecimal expiredTime = null;
		BigDecimal password = null;
		try{
			net.sf.json.JSONObject jsonObject =net.sf.json.JSONObject.fromObject(jsonString);
			String doorId = jsonObject.getString("doorId");
			if(StringUtils.isBlank(doorId)){
				throw new BusinessException("doorId",ErrorCode.PARAMETER_VALUE_INVALIDED);
			}
			acAccessCardManager.updateStatusByDoorId(doorId);
			acAccessCardManager.deleteAcRDoorCardByCardId(doorId);
			net.sf.json.JSONArray jsonArray = jsonObject.getJSONArray("cardIds");
			if(jsonArray.size()>0){
				for(int i=0;i<jsonArray.size();i++){
					JSONObject jsonObj = new JSONObject(jsonArray.getString(i));
					String cardId = jsonObj.getString("cardId");
					if(StringUtils.isBlank(cardId)){
						throw new BusinessException("cardId",ErrorCode.PARAMETER_VALUE_INVALIDED);
					}
					String authorizeType1 = jsonObj.getString("authorizeType");
					if(StringUtils.isNotBlank(authorizeType1)){
						try{
							authorizeType = new BigDecimal(authorizeType1);
						}catch(NumberFormatException be){
							resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
							resp.setMessage("authorizeType");
						}
					}
					String expiredTime1 = jsonObj.getString("expiredTime");
					if(StringUtils.isNotBlank(expiredTime1)){
						try{
							expiredTime = new BigDecimal(expiredTime1);
						}catch(NumberFormatException be){
							resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
							resp.setMessage("expiredTime");
						}
					}
					String password1 = jsonObj.getString("password");
					if(StringUtils.isNotBlank(password1)){
						try{
							password = new BigDecimal(password1);
						}catch(NumberFormatException be){
							resp.setCode(ErrorCode.PARAMETER_VALUE_INVALIDED);
							resp.setMessage("password");
						}
					}
					if(resp.getCode().equals(ErrorCode.SUCCESS)){
						try{
							acAccessCardManager.bindAcRDoorCard(doorId,cardId,authorizeTime,authorizeType,expiredTime,password);
							acAccessCardManager.updateStatusByCardId(cardId);
							resp.setCode(ErrorCode.SUCCESS);
						}catch(BusinessException be){
							resp.setCode(be.getCode());
							resp.setMessage(be.getMessage());
						}
					}
				}
			}else{
				acAccessCardManager.updateStatusByDoorId(doorId);
				acAccessCardManager.deleteAcRDoorCardByCardId(doorId);
			}
		}catch(JSONException e){
			e.printStackTrace();
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}

	/**
	 *
	 * bindEmployeesAndCard 绑定职工和卡
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "绑定职工和卡",isLog=false,isCheckSession=true)
	@RequestMapping("/bindEmployeesAndCard.json")
	public void bindEmployeesAndCard(HttpServletRequest request,
			HttpServletResponse response)throws JSONException{
		BaseResponse resp = new BaseResponse();
		String jsonString = (String) request.getAttribute("jsonString");
		try{
			acAccessCardManager.bindEmployeesAndCard(jsonString);
			resp.setCode(ErrorCode.SUCCESS);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	/**
	 * 
	 * listEmployeesAndCard 查询卡和员工绑定列表
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "查询卡和员工绑定列表",isLog=false,isCheckSession=true)
	@RequestMapping("/listEmployeesAndCard.json")
	public void listEmployeesAndCard(HttpServletRequest request,
			HttpServletResponse response){
		ListEmployeesAndCardResponse resp = new ListEmployeesAndCardResponse();
		String organId = (String)request.getAttribute("organId");
		try{
			List<ListEmployeesAndCardVO> card = acAccessCardManager.listEmployeesAndCard(organId);
			resp.setCard(card);
			resp.setCode(ErrorCode.SUCCESS);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
	/**
	 * 
	 * listCardAndEmployee 根据门ID查询卡和员工信息列表
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "根据门ID查询卡和员工信息列表",isLog=false,isCheckSession=true)
	@RequestMapping("/listCardAndEmployee.json")
	public void listCardAndEmployee(HttpServletRequest request,
			HttpServletResponse response){
		ListCardAndEmployeeResponse resp = new ListCardAndEmployeeResponse();
		String doorId = (String) request.getAttribute("doorId");
		try{
			List<ListCardAndEmployeeVO> cardAndEmployee = acAccessCardManager.listCardAndEmployee(doorId);
			resp.setCardAndEmployee(cardAndEmployee);
			resp.setCode(ErrorCode.SUCCESS);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
//	/**
//	 * 
//	 * updateStatusByCardId 根据卡ID更改状态下发授权
//	 * @param request
//	 * @param response
//	 */
//	@ControllerDescription(description = "根据卡ID更改状态员工授权状态",isLog=false,isCheckSession=true)
//	@RequestMapping("/updateStatusByCardId.json")
//	public void updateStatusByCardId(HttpServletRequest request,
//			HttpServletResponse response){
//		BaseResponse resp = new BaseResponse();
//		String id = (String) request.getAttribute("id");
//		String status = (String) request.getAttribute("status");
//		try{
//			acAccessCardManager.updateStatusByCardId(id,status);
//			resp.setCode(ErrorCode.SUCCESS);
//		}catch(BusinessException be){
//			resp.setCode(be.getCode());
//			resp.setMessage(be.getMessage());
//		}
//		writePageNoZip(response, resp);
//	}
	
	/**
	 * 
	 * updateTypeByDoorIdAndCardId 根据门ID和卡ID修改下发状态
	 * @param request
	 * @param response
	 */
	@ControllerDescription(description = "根据门ID和卡ID修改下发状态",isLog=false,isCheckSession=true)
	@RequestMapping("/updateTypeByDoorIdAndCardId.json")
	public void updateTypeByDoorIdAndCardId(HttpServletRequest request,
			HttpServletResponse response){
		BaseResponse resp = new BaseResponse();
		String doorId = (String) request.getAttribute("doorId");
		String cardId = (String) request.getAttribute("cardId");
		String authorizeType = (String) request.getAttribute("authorizeType");
		try{
			acAccessCardManager.updateTypeByDoorIdAndCardId(doorId,cardId,authorizeType);
			resp.setCode(ErrorCode.SUCCESS);
		}catch(BusinessException be){
			resp.setCode(be.getCode());
			resp.setMessage(be.getMessage());
		}
		writePageNoZip(response, resp);
	}
	
//	/**
//	 * 
//	 * removeBindCardAndEmployee 根据卡号解除绑定员工和卡关系
//	 * @param request
//	 * @param response
//	 */
//	@ControllerDescription(description = "根据卡号解除绑定员工和卡关系",isLog=false,isCheckSession=true)
//	@RequestMapping("/removeBindCardAndEmployee.json")
//	public void removeBindCardAndEmployee(HttpServletRequest request,
//			HttpServletResponse response){
//		BaseResponse resp = new BaseResponse();
//		String cardId = (String) request.getAttribute("cardId");
//		try{
//			acAccessCardManager.removeBindCardAndEmployee(cardId);
//			resp.setCode(cardId);
//		}catch(BusinessException be){
//			be.setCode(resp.getCode());
//			be.setMessage(resp.getMessage());
//		}
//		writePageNoZip(response, resp);
//	}
}
