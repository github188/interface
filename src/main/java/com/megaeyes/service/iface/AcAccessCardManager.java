package com.megaeyes.service.iface;

import java.math.BigDecimal;
import java.util.List;

import org.json.JSONException;

import com.megaeyes.persistence.ibatis.model.AcAccessCards;
import com.megaeyes.persistence.ibatis.vo.ListCardAndEmployeeVO;
import com.megaeyes.persistence.ibatis.vo.ListEmployeesAndCardVO;
import com.megaeyes.service.exception.BusinessException;

/**
 * AcAccessCardManager(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-5-16 上午01:49:59
 */
public interface AcAccessCardManager extends BaseManager {

	/**
	 * createAcAccessCards 创建卡
	 * @param name 卡名称
	 * @param cardNumber 卡号
	 * @param note 备注
	 * @param status 状态
	 * @param password 卡密码
	 * @param expireDate 到期日期
	 * @param organId 机构ID
	 * @return String
	 * @throws BusinessException
	 */
	public String createAcAccessCards(String name, String cardNumber, String note,
			String status, String password, BigDecimal expireDate,String organId)throws BusinessException;

	/**
	 * deleteAcAccessCards 删除卡
	 * @param id 卡ID
	 * @throws BusinessException
	 */
	public void deleteAcAccessCards(String id)throws BusinessException;

	/**
	 * updateAcAccessCards 更新卡
	 * @param id 卡ID
	 * @param name 卡名称
	 * @param cardNumber 卡号
	 * @param note 备注
	 * @param status 状态
	 * @param password 密码
	 * @param expireDate 到期时间
	 * @param organId 机构ID
	 * @throws BusinessException
	 */
	public void updateAcAccessCards(String id, String name, String cardNumber,
			String note, String status, String password, BigDecimal expireDate,
			String organId)throws BusinessException;

	/**
	 * listAcAccessCards 查询卡列表
	 * @return  List<AcAccessCards>
	 */
	public List<AcAccessCards> listAcAccessCards();

	/**
	 *
	 * getCardByCardNumber 根据卡号查询卡
	 * @param cardNumber 卡号
	 * @return AcAccessCards
	 * @throws BusinessException
	 */
	public AcAccessCards getCardByCardNumber(String cardNumber)throws BusinessException;

	
	/**
	 *
	 * deleteAcRDoorCardByCardId 根据门ID删除关系表记录
	 * @param doorId
	 */
	public void deleteAcRDoorCardByCardId(String doorId);

	/**
	 *
	 * bindAcRDoorCard 绑定门和卡
	 * @param doorId 门ID
	 * @param cardId 卡ID
	 * @param authorizeTime 授权类型
	 * @param authorizeType 授权时间
	 * @param expiredTime 到期时间
	 * @param password 密码
	 */
	public void bindAcRDoorCard(String doorId, String cardId,
			BigDecimal authorizeTime, BigDecimal authorizeType, BigDecimal expiredTime, BigDecimal password);

	/**
	 * 
	 * bindEmployeesAndCard 绑定职工和卡
	 * @param object jsonString数据
	 * @throws JSONException
	 */
	public void bindEmployeesAndCard(String jsonString)throws JSONException;

	/**
	 * 
	 * listEmployeesAndCard 查询卡和员工绑定列表
	 * @param organId 机构ID
	 * @return List<ListEmployeesAndCardVO>
	 */
	public List<ListEmployeesAndCardVO> listEmployeesAndCard(String organId);

	/**
	 * 
	 * listCardAndEmployee 根据门ID查询卡和员工信息列表
	 * @param doorId 门ID
	 * @return List<ListCardAndEmployeeVO>
	 */
	public List<ListCardAndEmployeeVO> listCardAndEmployee(String doorId);

	
	/**
	 * 
	 * updateStatus 根据门ID更新卡状态
	 * @param doorId 门ID
	 */
	public void updateStatusByDoorId(String doorId);
//
//	/**
//	 * 
//	 * updateStatusByCardId 根据绑定了的卡ID修改卡状态
//	 * @param cardId 卡ID
//	 */
//	public void updateStatusByCardId(String cardId);

	/**
	 * 
	 * updateStatusByCardId 根据卡ID更改状态员工授权状态
	 * @param id 卡ID
	 * @param status 卡状态
	 * @throws BusinessException
	 */
	public void updateStatusByCardId(String id)throws BusinessException;

	/**
	 * 
	 * updateTypeByDoorIdAndCardId 根据门ID和卡ID修改下发状态
	 * @param doorId 门ID
	 * @param cardId 卡ID
	 * @param authorizeType 状态
	 * @throws BusinessException
	 */
	public void updateTypeByDoorIdAndCardId(String doorId, String cardId,String authorizeType);

//	/**
//	 * 
//	 * removeBindCardAndEmployee  根据卡号解除绑定员工和卡关系
//	 * @param cardId 卡ID
//	 */
//	public void removeBindCardAndEmployee(String cardId);

}
