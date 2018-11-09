package cn.mauth.issue.common.entity;

import java.io.Serializable;
import java.util.Date;

public class SysLogLogin implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Date gmtCreate;

    private Long userInfoId;

    private String loginName;

    private String loginIp;

    private String lastLoginIp;

    private Date lastLoginTime;

    private String singleName;

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

    public Long getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Long userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getSingleName() {
        return singleName;
    }

    public void setSingleName(String singleName) {
        this.singleName = singleName;
    }

    @Override
    public String toString() {
        return "SysLogLogin{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", userInfoId=" + userInfoId +
                ", loginName='" + loginName + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", singleName='" + singleName + '\'' +
                '}';
    }
}
