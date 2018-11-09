package cn.mauth.issue.boss.bean.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 授权客户端表
 * </p>
 *
 * @author mauth
 * @since 2017-12-27
 */
public class SysPlatformVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 1 正常 2 冻结 9 注销
	 */
	private Integer statusId;
	/**
	 * 平台APPID
	 */
	private String platformAppId;
	/**
	 * 平台APPSECRET
	 */
	private String platformAppSecret;
	/**
	 * 平台名称
	 */
	private String platformName;
	/**
	 * 备注
	 */
	private String remark;

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

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getPlatformAppId() {
		return platformAppId;
	}

	public void setPlatformAppId(String platformAppId) {
		this.platformAppId = platformAppId;
	}

	public String getPlatformAppSecret() {
		return platformAppSecret;
	}

	public void setPlatformAppSecret(String platformAppSecret) {
		this.platformAppSecret = platformAppSecret;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
