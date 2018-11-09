package cn.mauth.issue.boss.bean.qo;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 支付订单
 * </p>
 *
 * @author mauth
 * @since 2018-01-06
 */
public class OrderTradePayQO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date gmtCreate;
	private Date gmtModified;
	/**
	 * 1创建 2支付成功 3支付失败 9异常
	 */
	private Integer payStatus;
	/**
	 * 交易订单ID
	 */
	private Long paySerialNo;
	/**
	 * 平台交易号
	 */
	private Long orderTradeNo;
	/**
	 * 用户ID
	 */
	private Long userInfoId;
	/**
	 * 账户ID
	 */
	private Long acctInfoId;
	/**
	 * 账户日志ID
	 */
	private Long acctLogId;
	/**
	 * 商品ID
	 */
	private Long itemId;
	/**
	 * 商品编号
	 */
	private String itemNo;
	/**
	 * 销售价
	 */
	private Integer salesPrice;
	/**
	 * 支付类型：1余额
	 */
	private Integer payType;
	/**
	 * 交易类型：1 入账 2 出账
	 */
	private Integer tradeType;
	/**
	 * 错误信息
	 */
	private String errorMsg;

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

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Long getPaySerialNo() {
		return paySerialNo;
	}

	public void setPaySerialNo(Long paySerialNo) {
		this.paySerialNo = paySerialNo;
	}

	public Long getOrderTradeNo() {
		return orderTradeNo;
	}

	public void setOrderTradeNo(Long orderTradeNo) {
		this.orderTradeNo = orderTradeNo;
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

	public Long getAcctLogId() {
		return acctLogId;
	}

	public void setAcctLogId(Long acctLogId) {
		this.acctLogId = acctLogId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public Integer getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(Integer salesPrice) {
		this.salesPrice = salesPrice;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Integer getTradeType() {
		return tradeType;
	}

	public void setTradeType(Integer tradeType) {
		this.tradeType = tradeType;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
