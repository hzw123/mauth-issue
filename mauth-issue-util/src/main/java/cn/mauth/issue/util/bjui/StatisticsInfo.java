package cn.mauth.issue.util.bjui;

import java.io.Serializable;
import java.util.Date;

public class StatisticsInfo implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 订单号*/
    private Long orderNo;
    /** 订单创建时间*/
    private Date createTime;
    /** 创建的订单包含的总面值*/
    private int totalFace;
    /** 已经兑换出去的卡总面值*/
    private int cashOutFace;
    /** 尚未兑换的总面值*/
    private int noChangeFace;
    /** 不同的面额数量*/
    private int amount;
    /** 订单类型*/
    private String orderType;
    /** 卡的总数量*/
    private int total;
    /** 已兑换卡的数量*/
    private int cashOutCount;


    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getTotalFace() {
        return totalFace;
    }

    public void setTotalFace(int totalFace) {
        this.totalFace = totalFace;
    }

    public int getCashOutFace() {
        return cashOutFace;
    }

    public void setCashOutFace(int cashOutFace) {
        this.cashOutFace = cashOutFace;
    }

    public int getNoChangeFace() {
        return noChangeFace;
    }

    public void setNoChangeFace(int noChangeFace) {
        this.noChangeFace = noChangeFace;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCashOutCount() {
        return cashOutCount;
    }

    public void setCashOutCount(int cashOutCount) {
        this.cashOutCount = cashOutCount;
    }
}
