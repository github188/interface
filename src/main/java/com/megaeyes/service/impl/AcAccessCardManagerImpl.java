package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.AcAccessCardsDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.AcRDoorCardDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.AcREmployeeCardDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.AcAccessCards;
import com.megaeyes.persistence.ibatis.model.AcAccessCardsExample;
import com.megaeyes.persistence.ibatis.model.AcRDoorCard;
import com.megaeyes.persistence.ibatis.model.AcRDoorCardExample;
import com.megaeyes.persistence.ibatis.model.AcREmployeeCard;
import com.megaeyes.persistence.ibatis.model.AcREmployeeCardExample;
import com.megaeyes.persistence.ibatis.model.AccessServer;
import com.megaeyes.persistence.ibatis.model.AccessServerExample;
import com.megaeyes.persistence.ibatis.vo.ListCardAndEmployeeVO;
import com.megaeyes.persistence.ibatis.vo.ListEmployeesAndCardVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AcAccessCardManager;

/**
 * AcAccessCardManagerImpl(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-5-16 上午01:51:06
 */
public class AcAccessCardManagerImpl extends BaseManagerImpl implements
		AcAccessCardManager {

	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	AcAccessCardsDAOiBatis acAccessCardsDAO;
	@Autowired
	AcRDoorCardDAOiBatis acRDoorCardDAO;
	@Autowired
	AcREmployeeCardDAOiBatis acREmployeeCardDAO;
	
	public String createAcAccessCards(String name, String cardNumber, String note,
			String status, String password, BigDecimal expireDate,String organId)throws BusinessException{
		if(StringUtils.isBlank(cardNumber)){
			throw new BusinessException("cardNmuber",ErrorCode.PARAMETER_NOT_FOUND);
		}else{
			AcAccessCardsExample aacExample = new AcAccessCardsExample();
			AcAccessCardsExample.Criteria criteria = aacExample.createCriteria();
			criteria.andCardNumberEqualTo(cardNumber);
			int count = acAccessCardsDAO.countByExample(aacExample);
			if (count > 0) {
				throw new BusinessException("cardNmuber",
						ErrorCode.STD_ID_DUPLICATE);
			}
		}
		String id = sequenceDAO.getAcAccessCardSeq();
		AcAccessCards aac = new AcAccessCards();
		aac.setId(id);
		aac.setName(name);
		aac.setCardNumber(cardNumber);
		aac.setNote(note);
		aac.setStatus(status);
		aac.setPassword(password);
		aac.setExpireDate(expireDate);
		aac.setOrganId(organId);
		acAccessCardsDAO.insert(aac);
		
		return id;
	}

	
	public void deleteAcAccessCards(String id) {
		if(StringUtils.isBlank(id)){
			throw new BusinessException("id",ErrorCode.PARAMETER_NOT_FOUND);
		}
		try{
			//删除卡时先删除门和卡关系表记录
			AcRDoorCardExample arcExample = new AcRDoorCardExample();
			AcRDoorCardExample.Criteria criteria = arcExample.createCriteria();
			criteria.andCardIdEqualTo(id);
			acRDoorCardDAO.deleteByExample(arcExample);
			//删除卡时先删除职工和卡关系表记录
			AcREmployeeCardExample arecExmple = new AcREmployeeCardExample();
			AcREmployeeCardExample.Criteria criteria1 = arecExmple.createCriteria();
			criteria1.andCardIdEqualTo(id);
			acREmployeeCardDAO.deleteByExample(arecExmple);
			//根据卡ID删除卡
			
			acAccessCardsDAO.deleteByPrimaryKey(id);
		}catch(Exception e){
			throw new BusinessException("resourceBeUsed", ErrorCode.RESOURCE_BE_USED);
		}
	}

	
	public void updateAcAccessCards(String id, String name, String cardNumber,
			String note, String status, String password, BigDecimal expireDate,
			String organId) throws BusinessException {
		if(StringUtils.isBlank(cardNumber)){
			throw new BusinessException("cardNumber",ErrorCode.PARAMETER_NOT_FOUND);
		}else{
			AcAccessCardsExample aacExample = new AcAccessCardsExample();
			AcAccessCardsExample.Criteria criteria = aacExample.createCriteria();
			criteria.andCardNumberEqualTo(cardNumber);
			List<AcAccessCards> list = acAccessCardsDAO
					.selectByExample(aacExample);
			if (list.size() > 0) {
				if (!id.equals(list.get(0).getId())) {
					if (cardNumber.equals(list.get(0).getCardNumber()))
					{
						throw new BusinessException("cardNumber",
								ErrorCode.STD_ID_DUPLICATE);
					}
				}
			}
		}
		AcAccessCards aac = new AcAccessCards();
		aac.setId(id);
		aac.setName(name);
		aac.setCardNumber(cardNumber);
		aac.setNote(note);
		aac.setStatus(status);
		aac.setPassword(password);
		aac.setExpireDate(expireDate);
		aac.setOrganId(organId);
		acAccessCardsDAO.updateByPrimaryKeySelective(aac);
		
	}

	
	public List<AcAccessCards> listAcAccessCards() {
		return acAccessCardsDAO.listAcAccessCards();
	}

	
	public AcAccessCards getCardByCardNumber(String cardNumber)
			throws BusinessException {
		if(StringUtils.isBlank(cardNumber)){
			throw new BusinessException("cardNumber",ErrorCode.SUCCESS);
		}
		return acAccessCardsDAO.getCardByCardNumber(cardNumber);
	}

	
	public void deleteAcRDoorCardByCardId(String doorId) {
		AcRDoorCardExample ardcExample = new AcRDoorCardExample();
		AcRDoorCardExample.Criteria criteria = ardcExample.createCriteria();
		criteria.andDoorIdEqualTo(doorId);
		acRDoorCardDAO.deleteByExample(ardcExample);
	}

	
	public void bindAcRDoorCard(String doorId, String cardId,
			BigDecimal authorizeTime, BigDecimal authorizeType,
			BigDecimal expiredTime, BigDecimal password) {
		
		String id = sequenceDAO.getAcRDoorCardSeq();
		AcRDoorCard ardc = new AcRDoorCard();
		ardc.setId(id);
		ardc.setDoorId(doorId);
		ardc.setCardId(cardId);
		ardc.setAuthorizeType(authorizeType);
		ardc.setAuthorizeTime(authorizeTime);
		ardc.setExpiredTime(expiredTime);
		ardc.setPassword(password);
		
		acRDoorCardDAO.insert(ardc);		
		
		
	}


	public void bindEmployeesAndCard(String jsonString) throws JSONException {
		if(StringUtils.isBlank(jsonString)){
			throw new BusinessException("jsonString",ErrorCode.PARAMETER_NOT_FOUND);
		}
		
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		if(jsonArray.size()>0){
			for(int i=0;i<jsonArray.size();i++){
				Object json = jsonArray.get(i);
				net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(json);
				String employeeId = jsonObject.getString("employeeId");
				if(StringUtils.isBlank(employeeId)){
					throw new BusinessException("employeeId",ErrorCode.PARAMETER_NOT_FOUND);
				}
				//绑定之前先做一次根据员工ID把绑定了卡ID的状态更新成为初始状态2
				acAccessCardsDAO.updateStatus(employeeId);
				AcREmployeeCardExample arecExample = new AcREmployeeCardExample(); 
				AcREmployeeCardExample.Criteria criteria = arecExample.createCriteria();
				criteria.andEmployeeIdEqualTo(employeeId);
				acREmployeeCardDAO.deleteByExample(arecExample);
				JSONArray cardsArray = jsonObject.getJSONArray("cardIds");
				if(cardsArray.size()>0){
					for(int n=0;n<cardsArray.size();n++){
						JSONObject jsonObj = new JSONObject(cardsArray.getString(n));
						String cardId = jsonObj.getString("cardId");
						if(StringUtils.isNotBlank(cardId)){
							String password = jsonObj.getString("password");
							BigDecimal expireDate = null;
							String expireDate1 = jsonObj.getString("expireDate");
							if(StringUtils.isNotBlank(expireDate1)){
								try{
									expireDate = new BigDecimal(expireDate1);
								}catch(NumberFormatException yy){
									throw new BusinessException("expireDate", ErrorCode.PARAMETER_VALUE_INVALIDED);
								}
							}
							String status = jsonObj.getString("status");
							
							//绑定时，根据卡ID更新卡的到期时间、密码、和状态0
							AcAccessCards aac = acAccessCardsDAO.selectByPrimaryKey(cardId);
							aac.setId(cardId);
							aac.setExpireDate(expireDate);
							aac.setPassword(password);
							aac.setStatus(status);
							acAccessCardsDAO.updateByPrimaryKeySelective(aac);
						}else{
							throw new BusinessException("cardId",ErrorCode.PARAMETER_NOT_FOUND);
						}
						String id = sequenceDAO.getAcREmployeeCardSeq();
						AcREmployeeCard arec = new AcREmployeeCard();
						arec.setId(id);
						arec.setEmployeeId(employeeId);
						arec.setCardId(cardId);
						acREmployeeCardDAO.insert(arec);
					}
				}else{
					//解除绑定时根据员工ID把所有绑定了的卡的状态更新成初始值2
					acAccessCardsDAO.updateStatus(employeeId);
					acREmployeeCardDAO.deleteByExample(arecExample);
				}
			}
		}else{
			throw new BusinessException("jsonArray",ErrorCode.PARAMETER_NOT_FOUND);
		}
	}

	public List<ListEmployeesAndCardVO> listEmployeesAndCard(String organId) {
		if(StringUtils.isBlank(organId)){
			throw new BusinessException("organId",ErrorCode.ORGAN_NOT_FOUND);
		}
		return acREmployeeCardDAO.listEmployeesAndCard(organId);
	}


	@Override
	public List<ListCardAndEmployeeVO> listCardAndEmployee(String doorId) {
		if(StringUtils.isBlank(doorId)){
			throw new BusinessException("doorId",ErrorCode.PARAMETER_NOT_FOUND);
		}
		return acREmployeeCardDAO.listCardAndEmployee(doorId);
	}


	@Override
	public void updateStatusByDoorId(String doorId) {
		AcRDoorCardExample ardcExample = new AcRDoorCardExample();
		AcRDoorCardExample.Criteria criteria = ardcExample.createCriteria();
		criteria.andDoorIdEqualTo(doorId);
		List<AcRDoorCard> list = acRDoorCardDAO.selectByExample(ardcExample);
		if(list.size()>0&&list!=null){
			for(int i=0;i<list.size();i++){
				AcRDoorCardExample ardcExample1 = new AcRDoorCardExample();
				AcRDoorCardExample.Criteria criteria1 = ardcExample1.createCriteria();
				criteria1.andCardIdEqualTo(list.get(i).getCardId());
				int count = acRDoorCardDAO.countByExample(ardcExample1);
				if(count<2){
					acAccessCardsDAO.updateStatusByCard(list.get(i).getCardId());
				}
			}
		}
	}


//	@Override
//	public void updateStatusByCardId(String cardId) {
//		AcAccessCards aac = acAccessCardsDAO.selectByPrimaryKey(cardId);
//		aac.setStatus("0");
//		acAccessCardsDAO.updateByPrimaryKey(aac);
//	}


	@Override
	public void updateStatusByCardId(String id)
			throws BusinessException {
		if(StringUtils.isBlank(id)){
			throw new BusinessException("id",ErrorCode.PARAMETER_NOT_FOUND);
		}
		AcAccessCards aac = acAccessCardsDAO.selectByPrimaryKey(id);
		if(!aac.getStatus().equals("3")){
			aac.setStatus("1");
			acAccessCardsDAO.updateByPrimaryKey(aac);
		}
	}


	@Override
	public void updateTypeByDoorIdAndCardId(String doorId, String cardId,String authorizeType) {
		if(StringUtils.isBlank(doorId)||StringUtils.isBlank(cardId)){
			throw new BusinessException("cardIdOrDoorId",ErrorCode.PARAMETER_NOT_FOUND);
		}
		//在授权前,如果authorizeType ==1，把卡状态改成3 . 取消下发时authorizeType=0如果此卡号没有授权其他门  把卡状态改回1 
		if(authorizeType.equals("1")){
			AcAccessCards aac = acAccessCardsDAO.selectByPrimaryKey(cardId);
			aac.setStatus("3");
			acAccessCardsDAO.updateByPrimaryKey(aac);
		}else if(authorizeType.equals("0")){
			AcRDoorCardExample arcExample = new AcRDoorCardExample();
			AcRDoorCardExample.Criteria criteria = arcExample.createCriteria();
			criteria.andCardIdEqualTo(cardId);
			criteria.andAuthorizeTypeEqualTo(new BigDecimal(1));
			int count = acRDoorCardDAO.countByExample(arcExample);
			if(count<2){
				AcAccessCards aac = acAccessCardsDAO.selectByPrimaryKey(cardId);
				aac.setStatus("1");
				acAccessCardsDAO.updateByPrimaryKey(aac);
			}
		}
		acRDoorCardDAO.updateTypeByDoorIdAndCardId(doorId,cardId,authorizeType);
	}


//	@Override
//	public void removeBindCardAndEmployee(String cardId) {
//		//根据卡号删除卡和员工关系表记录
//		if(StringUtils.isBlank(cardId)){
//			throw new BusinessException("cardId",ErrorCode.PARAMETER_NOT_FOUND);
//		}
//		AcREmployeeCardExample arecExample = new AcREmployeeCardExample(); 
//		AcREmployeeCardExample.Criteria criteria = arecExample.createCriteria();
//		criteria.andEmployeeIdEqualTo(cardId);
//		acREmployeeCardDAO.deleteByExample(arecExample);
//		
//	}
}
