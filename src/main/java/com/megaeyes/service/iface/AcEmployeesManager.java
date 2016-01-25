/**   
 * @Title: AcEmployeesManager.java 
 * @Package com.megaeyes.service.iface 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wangbinyu wangbinyu@megaeyes.com   
 * @date 2012-4-24 上午1:24:52 
 * @version V1.0   
 */
package com.megaeyes.service.iface;

import java.math.BigDecimal;
import java.util.List;

import com.megaeyes.persistence.ibatis.model.AcEmployees;
import com.megaeyes.persistence.ibatis.vo.AcEmployeesVO;
import com.megaeyes.service.exception.BusinessException;

/**
 * @ClassName: AcEmployeesManager
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangbinyu wangbinyu@megaeyes.com
 * @date 2012-4-24 上午1:24:52
 * 
 */
public interface AcEmployeesManager extends BaseManager {

	/**
	 * @Title: createAcEmployees
	 * @Description: 创建员工信息
	 * @param name
	 *            员工姓名
	 * @param isUser
	 *            是否是用户
	 * @param userId
	 *            用户ID
	 * @param note
	 *            备注
	 * @param mobile
	 *            移动电话
	 * @param phone
	 *            电话
	 * @param email
	 *            电子邮件
	 * @param age
	 *            年龄
	 * @param gender
	 *            性别
	 * @param address
	 *            地址
	 * @param empNo
	 *            员工编号
	 * @param nation
	 *            国家
	 * @param folk
	 *            民族
	 * @param idCard
	 *            卡片ID
	 * @param birthday
	 *            生日
	 * @param place
	 *            地方
	 * @param image
	 *            图片
	 * @return String 返回类型
	 * @throws BusinessException
	 */
	public String createAcEmployees(String name, Short isUser, String userId,
			String note, String mobile, String phone, String email, Short age,
			Short gender, String address, String empNo, String nation,
			String folk, String idCard, BigDecimal birthday, String place,
			byte[] image, String organId,String branchId,String position);

	/**
	 * @Title: deleteAcEmployees
	 * @Description: 删除职员信息
	 * @param id
	 *            设定文件
	 * @return void 返回类型
	 * @throws BusinessException
	 */
	public void deleteAcEmployees(String id) throws BusinessException;

	/**
	 * @Title: listAcEmployees
	 * @Description: 查询职员列表信息
	 * @return List<AcEmployees> 返回类型
	 * @throws
	 */
	public List<AcEmployeesVO> listAcEmployees();

	/**
	 * @Title: listAcEmployeesByGroupId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param groupId
	 * @param @return 设定文件
	 * @return List<AcEmployees> 返回类型
	 * @throws
	 */
	public List<AcEmployeesVO> listAcEmployeesByBranchId(String branchId);

	/**
	 * @Title: getAcEmployees
	 * @Description: 根据ID查询职员信息
	 * @param id
	 *            职员ID
	 * @return AcEmployees 返回类型
	 * @throws
	 */
	public AcEmployees getAcEmployees(String id) throws BusinessException;
	
	/**
	 * 
	* @Title: getAcEmployeeByCardNumber 
	* @Description: TODO(根据卡号查询职工) 
	* @param @param cardNumber
	* @param @return
	* @param @throws BusinessException    设定文件 
	* @return AcEmployees    返回类型 
	* @throws
	 */
	public AcEmployees getAcEmployeeByCardNumber(String cardNumber) throws BusinessException;
	/**
	 * @Title: updateACEmployee
	 * @Description: 根据ID修改员工信息
	 * @param id
	 *            职员ID
	 * @param name
	 *            职员姓名
	 * @param isUser
	 *            是否为用户
	 * @param userId
	 *            用户ID
	 * @param note
	 *            备注
	 * @param mobile
	 *            移动电话
	 * @param phone
	 *            电话
	 * @param email
	 *            电子邮件
	 * @param age
	 *            年龄
	 * @param gender
	 *            性别
	 * @param address
	 *            地址
	 * @param empNo
	 *            员工编号
	 * @param nation
	 *            国家
	 * @param folk
	 *            民族
	 * @param idCard
	 *            卡片ID
	 * @param birthday
	 *            生日
	 * @param place
	 *            地方
	 * @param image
	 *            员工图片
	 * @return void 返回类型
	 * @throws
	 */
	public void updateACEmployee(String id, String name, Short isUser,
			String userId, String note, String mobile, String phone,
			String email, Short age, Short gender, String address,
			String empNo, String nation, String folk, String idCard,
			BigDecimal birthday, String place, byte[] image);

	/**
	 * 
	 * @Description: 根据员工组ID查询组内员工列表
	 * @author zhuanqi@megaeyes.com
	 * @param @param groupId
	 * @param @return 
	 * @return List<AcEmployeesVO> 
	 * @throws
	 */
	public List<AcEmployeesVO> getAcEmployeeListByGroupId(String groupId);
}
