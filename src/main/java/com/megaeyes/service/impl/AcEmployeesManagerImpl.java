/**   
* @Title: AcEmployeesManagerImpl.java 
* @Package com.megaeyes.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangbinyu wangbinyu@megaeyes.com   
* @date 2012-4-24 上午1:26:33 
* @version V1.0   
*/ 
package com.megaeyes.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.persistence.ibatis.impl.AcAccessCardsDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.AcEmployeesDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.AcREmployeeCardDAOiBatis;
import com.megaeyes.persistence.ibatis.impl.SequenceDAOiBatis;
import com.megaeyes.persistence.ibatis.model.AcEmployees;
import com.megaeyes.persistence.ibatis.model.AcEmployeesExample;
import com.megaeyes.persistence.ibatis.model.AcREmployeeCardExample;
import com.megaeyes.persistence.ibatis.vo.AcEmployeesVO;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.exception.ErrorCode;
import com.megaeyes.service.iface.AcEmployeesManager;

/** 
 * @ClassName: AcEmployeesManagerImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-24 上午1:26:33 
 *  
 */
public class AcEmployeesManagerImpl extends BaseManagerImpl implements AcEmployeesManager {

	@Autowired
	SequenceDAOiBatis sequenceDAO;
	@Autowired
	AcEmployeesDAOiBatis acEmployeesDAO;
	@Autowired
	AcREmployeeCardDAOiBatis acREmployeeCardDAO;
	@Autowired
	AcAccessCardsDAOiBatis acAccessCardsDAO;
	
	public String createAcEmployees(String name,Short isUser,String userId,String note, String mobile,
			String phone, String email, Short age, Short gender,
			String address, String empNo, String nation, String folk,
			String idCard, BigDecimal birthday, String place, byte[] image,String organId,String branchId,String position) throws BusinessException {
		AcEmployeesExample example = new AcEmployeesExample();
		example.createCriteria().andEmpNoEqualTo(empNo);
		List<AcEmployees> employees = acEmployeesDAO
				.selectByExampleWithoutBLOBs(example);
		if (employees == null || employees.size() == 0) {

			AcEmployees ae = new AcEmployees();
			String id = sequenceDAO.getAcEmployeesSeq();
			ae.setId(id);
			ae.setName(name);
			ae.setUserId(userId);
			ae.setNote(note);
			ae.setMobile(mobile);
			ae.setPhone(phone);
			ae.setEmail(email);
			ae.setAge(age);
			ae.setGender(gender);
			ae.setAddress(address);
			ae.setEmpNo(empNo);
			ae.setNation(nation);
			ae.setFolk(folk);
			ae.setIdCard(idCard);
			ae.setBirthday(birthday);
			ae.setPlace(place);
			ae.setOrganId(organId);
			ae.setBranchId(branchId);
			ae.setPosition(position);
			System.out.println("image:"+image);
			ae.setImage(image);
			acEmployeesDAO.insert(ae);
			return id;
		} else {
			throw new BusinessException("empNo", ErrorCode.STD_ID_DUPLICATE);
		}
	}

	
	public void deleteAcEmployees(String id) throws BusinessException {
		if(StringUtils.isBlank(id)){
			throw new BusinessException("id",ErrorCode.PARAMETER_NOT_FOUND);
		}
		String[] str_array = id.split(",");
		for(int i=0;i<str_array.length;i++){
			try{	
				//做删除职工之前先做一次根据员工ID把绑定了卡ID的状态更新成为初始状态2
				acAccessCardsDAO.updateStatus(str_array[i]);
				//根据职工ID先把职工和卡的关系表记录删除
				AcREmployeeCardExample arecExmple = new AcREmployeeCardExample();
				AcREmployeeCardExample.Criteria criteria1 = arecExmple.createCriteria();
				criteria1.andEmployeeIdEqualTo(str_array[i]);
				acREmployeeCardDAO.deleteByExample(arecExmple);
		
				acEmployeesDAO.deleteByPrimaryKey(str_array[i]);
			}catch(Exception e){
				throw new BusinessException("resourceBeUsed",ErrorCode.RESOURCE_BE_USED);
			}
		}
	}

	
	public List<AcEmployeesVO> listAcEmployees() {
		return acEmployeesDAO.listAcEmployees();
	}

	public List<AcEmployeesVO> listAcEmployeesByBranchId(String branchId){
		return acEmployeesDAO.listAcEmployeesByBranchId(branchId);
	}
	
	public AcEmployees getAcEmployees(String id) throws BusinessException {
		if(StringUtils.isBlank(id)){
			throw new BusinessException("id", ErrorCode.PARAMETER_NOT_FOUND);
		}
		return acEmployeesDAO.selectByPrimaryKey(id);
	}
	public AcEmployees getAcEmployeeByCardNumber(String cardNumber) throws BusinessException {
		if(StringUtils.isBlank(cardNumber)){
			throw new BusinessException("cardNumber", ErrorCode.PARAMETER_NOT_FOUND);
		}
		System.out.println(cardNumber);
		return acEmployeesDAO.getAcEmployeeByCardNumber(cardNumber);
	}
	
	
	public void updateACEmployee(String id, String name, Short isUser,
			String userId, String note, String mobile, String phone,
			String email, Short age, Short gender, String address,
			String empNo, String nation, String folk, String idCard,
			BigDecimal birthday, String place, byte[] image) {
		AcEmployees employee = acEmployeesDAO.selectByPrimaryKey(id);
		if (!employee.getEmpNo().equals(empNo)) {

			AcEmployeesExample example = new AcEmployeesExample();
			example.createCriteria().andEmpNoEqualTo(empNo);
			List<AcEmployees> employees = acEmployeesDAO
					.selectByExampleWithoutBLOBs(example);
			if (employees != null) {
				throw new BusinessException("empNo", ErrorCode.STD_ID_DUPLICATE);
			}
		} else {
			AcEmployees ae = acEmployeesDAO.selectByPrimaryKey(id);
			ae.setId(id);
			ae.setName(name);
			ae.setIsUser(isUser);
			ae.setUserId(userId);
			ae.setNote(note);
			ae.setMobile(mobile);
			ae.setPhone(phone);
			ae.setEmail(email);
			ae.setAge(age);
			ae.setGender(gender);
			ae.setAddress(address);
			ae.setEmpNo(empNo);
			ae.setNation(nation);
			ae.setFolk(folk);
			ae.setIdCard(idCard);
			ae.setBirthday(birthday);
			ae.setPlace(place);
			if (image != null && image.length != 0)
				ae.setImage(image);
			acEmployeesDAO.updateByPrimaryKeySelective(ae);

		}
		
	}

	public List<AcEmployeesVO> getAcEmployeeListByGroupId(String groupId){
		return acEmployeesDAO.getAcEmployeeListByGroupId(groupId);
	}
	

}
