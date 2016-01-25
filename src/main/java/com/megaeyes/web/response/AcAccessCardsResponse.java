package com.megaeyes.web.response;

import java.math.BigDecimal;

/**
 * AcAccessCardsResponse(类说明)
 * @author wangbinyu wangbinyu@megaeyes.com
 * <p />
 * 2012-5-16 上午05:53:45
 */
public class AcAccessCardsResponse extends BaseResponse {

	private String id;
	private String name;
	private String cardNumber;
	private String note;
	private String status;
	private String password;
	private BigDecimal expireDate;
	private String organId;
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
	public BigDecimal getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(BigDecimal expireDate) {
		this.expireDate = expireDate;
	}
	public String getOrganId() {
		return organId;
	}
	public void setOrganId(String organId) {
		this.organId = organId;
	}
}