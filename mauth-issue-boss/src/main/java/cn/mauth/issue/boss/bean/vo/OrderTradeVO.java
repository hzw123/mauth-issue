package cn.mauth.issue.boss.bean.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 交易订单
 * </p>
 *
 * @author mauth
 * @since 2018-01-06
 */
public class OrderTradeVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 相当于流水号
	 */
	private Long id;
	private Date gmtCreate;
	private Date gmtModified;
	/**
	 * 1创建 处理中 2 成功 3 失败 9 未确认
	 */
	private Integer orderStatus;
	/**
	 * 下游用户ID
	 */
	private Long userInfoId;
	/**
	 * 支付单ID
	 */
	private Long acctInfoId;
	/**
	 * 供应商商品ID
	 */
	private Long itemSupplyId;
	/**
	 * 商品ID
	 */
	private Long itemId;
	/**
	 * 商品类别（1充值，2兑换）
	 */
	private Integer itemCategory;
	/**
	 * 商品类型：1流量，2话费
	 */
	private Integer itemType;
	/**
	 * 商品编号
	 */
	private String itemNo;
	/**
	 * 商品名称
	 */
	private String itemName;
	/**
	 * 销售价格
	 */
	private Integer salesPrice;
	/**
	 * 面值
	 */
	private String facePrice;
	/**
	 * 成本价
	 */
	private Integer costPrice;
	/**
	 * 实际扣费
	 */
	private Integer actualCost;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 接口方式：1外放 2 WEB 3 APP
	 */
	private Integer channel;
	/**
	 * 交易订单
	 */
	private Long tradeNo;
	/**
	 * 支付流水号
	 */
	private Long paySerialNo;
	/**
	 * 下游订单号
	 */
	private String orderNo;
	/**
	 * 下游订单时间
	 */
	private Date orderTime;
	/**
	 * 运营商类型：1移动，2 电信，3联通
	 */
	private Integer carrierType;
	/**
	 * 上游供货摘要
	 */
	private String supplyDesc;
	/**
	 * 供货次数
	 */
	private Integer supplyCount;
	/**
	 * 供货索引
	 */
	private Integer supplyIndex;
	/**
	 * 回调地址
	 */
	private String notifyUrl;
	/**
	 * 流量生效方式：1立即生效，2下月生效
	 */
	private Integer flowMode;
	/**
	 * 流量范围：1全国，2本地
	 */
	private Integer flowScope;
	/**
	 * 包体类型：1日包，2月包，3季度包，4年包
	 */
	private Integer flowPackageType;
	/**
	 * 通道类型：1全国，2分省
	 */
	private Integer flowStreamType;
	/**
	 * 卡号
	 */
	private String cardNo;
	/**
	 * 卡密
	 */
	private String cardPwd;
	/**
	 * 是否补充
	 */
	private Integer repeatType;
	/**
	 * 上游供货流水号
	 */
	private Long supplySerialNo;


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

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
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

	public Long getItemSupplyId() {
		return itemSupplyId;
	}

	public void setItemSupplyId(Long itemSupplyId) {
		this.itemSupplyId = itemSupplyId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Integer getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(Integer itemCategory) {
		this.itemCategory = itemCategory;
	}

	public Integer getItemType() {
		return itemType;
	}

	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(Integer salesPrice) {
		this.salesPrice = salesPrice;
	}

	public String getFacePrice() {
		return facePrice;
	}

	public void setFacePrice(String facePrice) {
		this.facePrice = facePrice;
	}

	public Integer getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Integer costPrice) {
		this.costPrice = costPrice;
	}

	public Integer getActualCost() {
		return actualCost;
	}

	public void setActualCost(Integer actualCost) {
		this.actualCost = actualCost;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getChannel() {
		return channel;
	}

	public void setChannel(Integer channel) {
		this.channel = channel;
	}

	public Long getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(Long tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Long getPaySerialNo() {
		return paySerialNo;
	}

	public void setPaySerialNo(Long paySerialNo) {
		this.paySerialNo = paySerialNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getCarrierType() {
		return carrierType;
	}

	public void setCarrierType(Integer carrierType) {
		this.carrierType = carrierType;
	}

	public String getSupplyDesc() {
		return supplyDesc;
	}

	public void setSupplyDesc(String supplyDesc) {
		this.supplyDesc = supplyDesc;
	}

	public Integer getSupplyCount() {
		return supplyCount;
	}

	public void setSupplyCount(Integer supplyCount) {
		this.supplyCount = supplyCount;
	}

	public Integer getSupplyIndex() {
		return supplyIndex;
	}

	public void setSupplyIndex(Integer supplyIndex) {
		this.supplyIndex = supplyIndex;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public Integer getFlowMode() {
		return flowMode;
	}

	public void setFlowMode(Integer flowMode) {
		this.flowMode = flowMode;
	}

	public Integer getFlowScope() {
		return flowScope;
	}

	public void setFlowScope(Integer flowScope) {
		this.flowScope = flowScope;
	}

	public Integer getFlowPackageType() {
		return flowPackageType;
	}

	public void setFlowPackageType(Integer flowPackageType) {
		this.flowPackageType = flowPackageType;
	}

	public Integer getFlowStreamType() {
		return flowStreamType;
	}

	public void setFlowStreamType(Integer flowStreamType) {
		this.flowStreamType = flowStreamType;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardPwd() {
		return cardPwd;
	}

	public void setCardPwd(String cardPwd) {
		this.cardPwd = cardPwd;
	}

	public Integer getRepeatType() {
		return repeatType;
	}

	public void setRepeatType(Integer repeatType) {
		this.repeatType = repeatType;
	}

	public Long getSupplySerialNo() {
		return supplySerialNo;
	}

	public void setSupplySerialNo(Long supplySerialNo) {
		this.supplySerialNo = supplySerialNo;
	}
}
