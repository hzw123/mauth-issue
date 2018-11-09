package cn.mauth.issue.boss.bean.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 供应商订单
 * </p>
 *
 * @author mauth
 * @since 2018-01-06
 */
public class OrderSupplyVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date gmtCreate;
	private Date gmtModified;
	/**
	 * 0创建 1处理中 2 成功 3 失败 9 未确认
	 */
	private Integer orderStatus;
	/**
	 * 平台交易号
	 */
	private Long orderTradeNo;
	/**
	 * 供应商商品ID
	 */
	private Long itemSupplyId;
	/**
	 * 用户ID
	 */
	private Long userInfoId;
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
	 * 客户手机号码
	 */
	private String mobile;
	/**
	 * 上游商户编号
	 */
	private Long supplyInfoId;
	/**
	 * 上游编码
	 */
	private String supplyCode;
	/**
	 * 上游商户名称
	 */
	private String supplyName;
	/**
	 * 上游供货流水号
	 */
	private Long supplySerialNo;
	/**
	 * 商品面值
	 */
	private String supplyFacePrice;
	/**
	 * 平台录入成本价
	 */
	private Integer supplyCostPrice;
	/**
	 * 上游实际扣款价
	 */
	private Integer supplyActualCost;
	/**
	 * 上游充值信息
	 */
	private String supplyDesc;
	/**
	 * 是否补充
	 */
	private Integer repeatType;

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

	public Long getOrderTradeNo() {
		return orderTradeNo;
	}

	public void setOrderTradeNo(Long orderTradeNo) {
		this.orderTradeNo = orderTradeNo;
	}

	public Long getItemSupplyId() {
		return itemSupplyId;
	}

	public void setItemSupplyId(Long itemSupplyId) {
		this.itemSupplyId = itemSupplyId;
	}

	public Long getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(Long userInfoId) {
		this.userInfoId = userInfoId;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getSupplyInfoId() {
		return supplyInfoId;
	}

	public void setSupplyInfoId(Long supplyInfoId) {
		this.supplyInfoId = supplyInfoId;
	}

	public String getSupplyCode() {
		return supplyCode;
	}

	public void setSupplyCode(String supplyCode) {
		this.supplyCode = supplyCode;
	}

	public String getSupplyName() {
		return supplyName;
	}

	public void setSupplyName(String supplyName) {
		this.supplyName = supplyName;
	}

	public Long getSupplySerialNo() {
		return supplySerialNo;
	}

	public void setSupplySerialNo(Long supplySerialNo) {
		this.supplySerialNo = supplySerialNo;
	}

	public String getSupplyFacePrice() {
		return supplyFacePrice;
	}

	public void setSupplyFacePrice(String supplyFacePrice) {
		this.supplyFacePrice = supplyFacePrice;
	}

	public Integer getSupplyCostPrice() {
		return supplyCostPrice;
	}

	public void setSupplyCostPrice(Integer supplyCostPrice) {
		this.supplyCostPrice = supplyCostPrice;
	}

	public Integer getSupplyActualCost() {
		return supplyActualCost;
	}

	public void setSupplyActualCost(Integer supplyActualCost) {
		this.supplyActualCost = supplyActualCost;
	}

	public String getSupplyDesc() {
		return supplyDesc;
	}

	public void setSupplyDesc(String supplyDesc) {
		this.supplyDesc = supplyDesc;
	}

	public Integer getRepeatType() {
		return repeatType;
	}

	public void setRepeatType(Integer repeatType) {
		this.repeatType = repeatType;
	}
}
