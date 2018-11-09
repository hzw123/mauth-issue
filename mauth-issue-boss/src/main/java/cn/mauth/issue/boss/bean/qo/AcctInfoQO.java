package cn.mauth.issue.boss.bean.qo;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 账户信息
 * </p>
 *
 * @author mauth
 * @since 2017-12-27
 */
public class AcctInfoQO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date gmtCreate;
	private Date gmtModified;
	/**
	 * 1 正常 2 冻结 9注销
	 */
	private Integer statusId;
	/**
	 * 用户ID
	 */
	private Long userInfoId;
	/**
	 * 总余额
	 */
	private Long totalBalance;
	/**
	 * 最后交易余额
	 */
	private Long lastTradeBalance;
	/**
	 * 最后交易时间
	 */
	private Date lastTradeDate;
	/**
	 * 校验码
	 */
	private String verificationCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Long getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(Long userInfoId) {
		this.userInfoId = userInfoId;
	}

	public Long getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(Long totalBalance) {
		this.totalBalance = totalBalance;
	}

	public Long getLastTradeBalance() {
		return lastTradeBalance;
	}

	public void setLastTradeBalance(Long lastTradeBalance) {
		this.lastTradeBalance = lastTradeBalance;
	}

	public Date getLastTradeDate() {
		return lastTradeDate;
	}

	public void setLastTradeDate(Date lastTradeDate) {
		this.lastTradeDate = lastTradeDate;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
}
