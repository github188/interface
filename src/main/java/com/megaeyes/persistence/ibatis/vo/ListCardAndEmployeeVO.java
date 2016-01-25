package com.megaeyes.persistence.ibatis.vo;

import java.math.BigDecimal;

/**
 * ListCardAndEmployeeVO(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-5-24 上午02:50:51
 */
public class ListCardAndEmployeeVO {
	private String cPassword;
	private String cardId;
	private BigDecimal authorizeType;
	private String employeeId;
	private String employeeName;
	private BigDecimal expireDate;
	private String empNo;
	private String cardNumber;
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getcPassword() {
		return cPassword;
	}
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	public BigDecimal getAuthorizeType() {
		return authorizeType;
	}
	public void setAuthorizeType(BigDecimal authorizeType) {
		this.authorizeType = authorizeType;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public BigDecimal getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(BigDecimal expireDate) {
		this.expireDate = expireDate;
	}
}
