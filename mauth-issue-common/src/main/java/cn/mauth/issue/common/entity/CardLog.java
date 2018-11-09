package cn.mauth.issue.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 储值卡操作日志
 */
public class CardLog implements Serializable{
    private static final long serialVersionUID = 1L;
    private Long id;
    /** 支付时间*/
    private Date gmtCreate;
    /** 储值卡信息Id*/
    private Long orderCardWaterId;
    /** 操作状态*/
    private Integer status=0;
    /** 用户ID*/
    private Long userId;
    /** 操作信息*/
    private String msg;

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

    public Long getOrderCardWaterId() {
        return orderCardWaterId;
    }

    public void setOrderCardWaterId(Long orderCardWaterId) {
        this.orderCardWaterId = orderCardWaterId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
