package cn.mauth.issue.boss.bean.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 账户日志
 * </p>
 *
 * @author mauth
 * @since 2017-12-27
 */
public class AcctLogVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date gmtCreate;
	private Date gmtModified;
	/**
	 * 用户ID
	 */
	private Long userInfoId;
	/**
	 * 账户ID
	 */
	private Long acctInfoId;
	/**
	 * 交易单类型 1支付单 2充值单 3退款单 4提现单
	 */
	private Integer billType;
	/**
	 * 账单状态：1 成功 2 异常
	 */
	private Integer billStatus;
	/**
	 * 交易类型：1 入账 2 出账
	 */
	private Integer tradeType;
	/**
	 * 支付交易订单号
	 */
	private Long paySerialNo;
	/**
	 * 金额
	 */
	private Integer amount;
	/**
	 * 余额
	 */
	private Long totalBalance;

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

	public Long getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(Long userInfoId) {
		this.userInfoId = userInfoId;
	}

	public Long getAcctInfoId() {
		return acctInfoId;
	}

	public void setAcctInfoId(Long acctInfoId) {
		this.acctInfoId = acctInfoId;
	}

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public Integer getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(Integer billStatus) {
		this.billStatus = billStatus;
	}

	public Integer getTradeType() {
		return tradeType;
	}

	public void setTradeType(Integer tradeType) {
		this.tradeType = tradeType;
	}

	public Long getPaySerialNo() {
		return paySerialNo;
	}

	public void setPaySerialNo(Long paySerialNo) {
		this.paySerialNo = paySerialNo;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Long getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(Long totalBalance) {
		this.totalBalance = totalBalance;
	}
}
