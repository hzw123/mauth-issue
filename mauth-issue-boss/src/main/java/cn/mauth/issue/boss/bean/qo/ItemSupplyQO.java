package cn.mauth.issue.boss.bean.qo;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 供应商商品管理
 * </p>
 *
 * @author mauth
 * @since 2018-01-06
 */
public class ItemSupplyQO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date gmtCreate;
	private Date gmtModified;
	/**
	 * 状态：1 初始，2正常，3下架
	 */
	private Integer itemStatus;
	/**
	 * 商品iD
	 */
	private Long itemId;
	/**
	 * 商品编号
	 */
	private String itemNo;
	/**
	 * 商品名称
	 */
	private String itemName;
	/**
	 * 供应商编号
	 */
	private Long supplyInfoId;
	/**
	 * 上游编码
	 */
	private String supplyCode;
	/**
	 * 名称
	 */
	private String supplyName;
	/**
	 * 优先级
	 */
	private Integer priority;
	/**
	 * 是否折损
	 */
	private Integer lossType;
	/**
	 * 折损次数
	 */
	private Integer lossTime;
	/**
	 * 商品面值
	 */
	private String facePrice;
	/**
	 * 成本价
	 */
	private Integer costPrice;
	/**
	 * 上游商品ID
	 */
	private String supplyProductCode;

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

	public Integer getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(Integer itemStatus) {
		this.itemStatus = itemStatus;
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getLossType() {
		return lossType;
	}

	public void setLossType(Integer lossType) {
		this.lossType = lossType;
	}

	public Integer getLossTime() {
		return lossTime;
	}

	public void setLossTime(Integer lossTime) {
		this.lossTime = lossTime;
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

	public String getSupplyProductCode() {
		return supplyProductCode;
	}

	public void setSupplyProductCode(String supplyProductCode) {
		this.supplyProductCode = supplyProductCode;
	}
}
