package cn.mauth.issue.boss.bean.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 商品管理
 * </p>
 *
 * @author mauth
 * @since 2018-01-06
 */
public class ItemVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date gmtCreate;
	private Date gmtModified;
	/**
	 * 销售地区（省编号）
	 */
	private String salesArea;
	/**
	 * 面值
	 */
	private String facePrice;
	/**
	 * 成本价格
	 */
	private Integer costPrice;
	/**
	 * 销售价格
	 */
	private Integer salesPrice1;
	/**
	 * 销售价格
	 */
	private Integer salesPrice2;
	/**
	 * 销售价格
	 */
	private Integer salesPrice3;
	/**
	 * 运营商类型：1移动，2 电信，3联通
	 */
	private Integer carrierType;
	/**
	 * 商品类别（1充值，2兑换）
	 */
	private Integer itemCategory;
	/**
	 * 商品类型：1流量，2话费，3兑换卡
	 */
	private Integer itemType;
	/**
	 * 状态：1 初始，2正常，3下架
	 */
	private Integer itemStatus;
	/**
	 * 商品编号
	 */
	private String itemNo;
	/**
	 * 商品名称
	 */
	private String itemName;
	/**
	 * 商品描述
	 */
	private String itemDesc;
	/**
	 * 使用范围：1本地，2全国
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

	public String getSalesArea() {
		return salesArea;
	}

	public void setSalesArea(String salesArea) {
		this.salesArea = salesArea;
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

	public Integer getSalesPrice1() {
		return salesPrice1;
	}

	public void setSalesPrice1(Integer salesPrice1) {
		this.salesPrice1 = salesPrice1;
	}

	public Integer getSalesPrice2() {
		return salesPrice2;
	}

	public void setSalesPrice2(Integer salesPrice2) {
		this.salesPrice2 = salesPrice2;
	}

	public Integer getSalesPrice3() {
		return salesPrice3;
	}

	public void setSalesPrice3(Integer salesPrice3) {
		this.salesPrice3 = salesPrice3;
	}

	public Integer getCarrierType() {
		return carrierType;
	}

	public void setCarrierType(Integer carrierType) {
		this.carrierType = carrierType;
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

	public Integer getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(Integer itemStatus) {
		this.itemStatus = itemStatus;
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

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
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
}
