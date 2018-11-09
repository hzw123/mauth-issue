package cn.mauth.issue.boss.bean.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 上游供货商
 * </p>
 *
 * @author mauth
 * @since 2018-01-06
 */
public class SupplyInfoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date gmtCreate;
	private Date gmtModified;
	/**
	 * 1 正常 2 冻结 9 注销
	 */
	private Integer statusId;
	/**
	 * 供货商类别（1充值，2兑换）
	 */
	private Integer supplyCategory;
	/**
	 * 上游编码
	 */
	private String supplyCode;
	/**
	 * 名称
	 */
	private String supplyName;
	/**
	 * 公司名
	 */
	private String compayName;
	/**
	 * 参数：请求URl
	 */
	private String paraRequestUrl;
	/**
	 * 参数：订单查询url
	 */
	private String paraOrderUrl;
	/**
	 * 参数：余额查询URL
	 */
	private String paraBalanceUrl;
	/**
	 * 参数：用户ID
	 */
	private String paraUserId;
	/**
	 * 参数：key
	 */
	private String paraKey;
	/**
	 * 参数：seceret
	 */
	private String paraSeceret;
	/**
	 * 扩展参数1
	 */
	private String paraExt1;
	/**
	 * 扩展参数2
	 */
	private String paraExt2;
	/**
	 * 扩展参数3
	 */
	private String paraExt3;
	/**
	 * 扩展参数4
	 */
	private String paraExt4;
	/**
	 * 扩展参数5
	 */
	private String paraExt5;


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

	public Integer getSupplyCategory() {
		return supplyCategory;
	}

	public void setSupplyCategory(Integer supplyCategory) {
		this.supplyCategory = supplyCategory;
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

	public String getCompayName() {
		return compayName;
	}

	public void setCompayName(String compayName) {
		this.compayName = compayName;
	}

	public String getParaRequestUrl() {
		return paraRequestUrl;
	}

	public void setParaRequestUrl(String paraRequestUrl) {
		this.paraRequestUrl = paraRequestUrl;
	}

	public String getParaOrderUrl() {
		return paraOrderUrl;
	}

	public void setParaOrderUrl(String paraOrderUrl) {
		this.paraOrderUrl = paraOrderUrl;
	}

	public String getParaBalanceUrl() {
		return paraBalanceUrl;
	}

	public void setParaBalanceUrl(String paraBalanceUrl) {
		this.paraBalanceUrl = paraBalanceUrl;
	}

	public String getParaUserId() {
		return paraUserId;
	}

	public void setParaUserId(String paraUserId) {
		this.paraUserId = paraUserId;
	}

	public String getParaKey() {
		return paraKey;
	}

	public void setParaKey(String paraKey) {
		this.paraKey = paraKey;
	}

	public String getParaSeceret() {
		return paraSeceret;
	}

	public void setParaSeceret(String paraSeceret) {
		this.paraSeceret = paraSeceret;
	}

	public String getParaExt1() {
		return paraExt1;
	}

	public void setParaExt1(String paraExt1) {
		this.paraExt1 = paraExt1;
	}

	public String getParaExt2() {
		return paraExt2;
	}

	public void setParaExt2(String paraExt2) {
		this.paraExt2 = paraExt2;
	}

	public String getParaExt3() {
		return paraExt3;
	}

	public void setParaExt3(String paraExt3) {
		this.paraExt3 = paraExt3;
	}

	public String getParaExt4() {
		return paraExt4;
	}

	public void setParaExt4(String paraExt4) {
		this.paraExt4 = paraExt4;
	}

	public String getParaExt5() {
		return paraExt5;
	}

	public void setParaExt5(String paraExt5) {
		this.paraExt5 = paraExt5;
	}
}
