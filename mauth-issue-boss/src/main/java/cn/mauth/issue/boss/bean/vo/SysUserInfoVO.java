package cn.mauth.issue.boss.bean.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 后台用户信息
 * </p>
 *
 * @author mauth
 * @since 2017-12-27
 */
public class SysUserInfoVO implements Serializable {

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
	 * 1 内部 2 下游
	 */
	private Integer userType;
	/**
	 * 登录名
	 */
	private String loginName;
	/**
	 * 用户名
	 */
	private String nickName;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 地址
	 */
	private String addr;
	/**
	 * 密码盐
	 */
	private String salt;
	/**
	 * 登录密码
	 */
	private String pwd;


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

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
