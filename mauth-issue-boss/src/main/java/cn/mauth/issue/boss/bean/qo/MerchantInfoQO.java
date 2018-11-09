package cn.mauth.issue.boss.bean.qo;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 下游代理商
 * </p>
 *
 * @author mauth
 * @since 2018-01-06
 */
public class MerchantInfoQO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date gmtCreate;
	private Date gmtModified;
	/**
	 * 1 正常 2 冻结 9 注销
	 */
	private Integer statusId;
	/**
	 * 用户ID
	 */
	private Long userInfoId;
	/**
	 * 账户ID
	 */
	private Long acctInfoId;
	/**
	 * APPID
	 */
	private String appId;
	/**
	 * 价格级别(对应商品的销售价位)
	 */
	private Integer priceLevel;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 公司全称
	 */
	private String compayName;
	/**
	 * 充值限制
	 */
	private Integer chargingLimit;
	/**
	 * 余额阈值
	 */
	private Integer warningBalance;
	/**
	 * 保证金
	 */
	private Integer depositBalance;
	/**
	 * 接口校验类型：1秘钥，2秘钥+白名单
	 */
	private Integer apiVerifyType;
	/**
	 * AppSeceret
	 */
	private String appSeceret;
	/**
	 * 白名单
	 */
	private String whiteList;
	/**
	 * 提现校验类型：1支付密码，2支付密码+动态码
	 */
	private Integer txVerifyType;
	/**
	 * 支付密码
	 */
	private String payPwd;
	/**
	 * 动态秘钥
	 */
	private String verifyCodeKey;

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

	public Long getAcctInfoId() {
		return acctInfoId;
	}

	public void setAcctInfoId(Long acctInfoId) {
		this.acctInfoId = acctInfoId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public Integer getPriceLevel() {
		return priceLevel;
	}

	public void setPriceLevel(Integer priceLevel) {
		this.priceLevel = priceLevel;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getCompayName() {
		return compayName;
	}

	public void setCompayName(String compayName) {
		this.compayName = compayName;
	}

	public Integer getChargingLimit() {
		return chargingLimit;
	}

	public void setChargingLimit(Integer chargingLimit) {
		this.chargingLimit = chargingLimit;
	}

	public Integer getWarningBalance() {
		return warningBalance;
	}

	public void setWarningBalance(Integer warningBalance) {
		this.warningBalance = warningBalance;
	}

	public Integer getDepositBalance() {
		return depositBalance;
	}

	public void setDepositBalance(Integer depositBalance) {
		this.depositBalance = depositBalance;
	}

	public Integer getApiVerifyType() {
		return apiVerifyType;
	}

	public void setApiVerifyType(Integer apiVerifyType) {
		this.apiVerifyType = apiVerifyType;
	}

	public String getAppSeceret() {
		return appSeceret;
	}

	public void setAppSeceret(String appSeceret) {
		this.appSeceret = appSeceret;
	}

	public String getWhiteList() {
		return whiteList;
	}

	public void setWhiteList(String whiteList) {
		this.whiteList = whiteList;
	}

	public Integer getTxVerifyType() {
		return txVerifyType;
	}

	public void setTxVerifyType(Integer txVerifyType) {
		this.txVerifyType = txVerifyType;
	}

	public String getPayPwd() {
		return payPwd;
	}

	public void setPayPwd(String payPwd) {
		this.payPwd = payPwd;
	}

	public String getVerifyCodeKey() {
		return verifyCodeKey;
	}

	public void setVerifyCodeKey(String verifyCodeKey) {
		this.verifyCodeKey = verifyCodeKey;
	}
}
