package cn.mauth.issue.common.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 储值卡订单表
 */
public class OrderCard implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    /** 订单名称*/
    private String orderCardName;
    /** 订单号*/
    private Long orderNo;
    /** 订单类型*/
    private String orderType;
    /** 下单时间*/
    private Date gmtCreate;
    /** 修改时间*/
    private Date gmtModified;
    /** 订单总价*/
    private Double totalPrice;
    /** 用户支付账户*/
    private String userPayAccount;
    /** 支付方式*/
    private String payType;
    /**
     * 状态
     * 1 待处理：表示付款成功等待管理员处理
     * 2 已处理：表示订单正在处理中
     * 3 已完成：表示订单已经完成
     * 4 订单异常
     */
    private String status;
    /** 有效天数*/
    private Integer days;
    /** 下载密码*/
    private String loadPassword;
    /** 身份标识*/
    private String authSign;

    private List<CardBills> list;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderCardName() {
        return orderCardName;
    }

    public void setOrderCardName(String orderCardName) {
        this.orderCardName = orderCardName;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
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

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUserPayAccount() {
        return userPayAccount;
    }

    public void setUserPayAccount(String userPayAccount) {
        this.userPayAccount = userPayAccount;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getLoadPassword() {
        return loadPassword;
    }

    public void setLoadPassword(String loadPassword) {
        this.loadPassword = loadPassword;
    }

    public String getAuthSign() {
        return authSign;
    }

    public void setAuthSign(String authSign) {
        this.authSign = authSign;
    }

    public List<CardBills> getList() {
        return list;
    }

    public void setList(List<CardBills> list) {
        this.list = list;
    }
}
