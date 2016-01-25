package com.megaeyes.persistence.ibatis.vo;

/**
 * ListEmployeesAndCardVO(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-5-22 上午07:08:48
 */
public class ListEmployeesAndCardVO {
	private String accessEmployeeId;
	private String accessEmployeeName;
	private String accessEmployeeNum;
	private String id;
	private String name;
	private String cardNumber;
	private String note;
	private String status;
	private String password;
	
	public String getAccessEmployeeNum() {
		return accessEmployeeNum;
	}
	public void setAccessEmployeeNum(String accessEmployeeNum) {
		this.accessEmployeeNum = accessEmployeeNum;
	}
	public String getAccessEmployeeId() {
		return accessEmployeeId;
	}
	public void setAccessEmployeeId(String accessEmployeeId) {
		this.accessEmployeeId = accessEmployeeId;
	}
	public String getAccessEmployeeName() {
		return accessEmployeeName;
	}
	public void setAccessEmployeeName(String accessEmployeeName) {
		this.accessEmployeeName = accessEmployeeName;
	}
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
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getOrganId() {
		return organId;
	}
	public void setOrganId(String organId) {
		this.organId = organId;
	}
	private String expireDate;
	private String organId;
}
