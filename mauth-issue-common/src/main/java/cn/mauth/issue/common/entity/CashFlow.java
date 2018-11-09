package cn.mauth.issue.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 兑换流水
 */
public class CashFlow implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    /** 卡信息激活时间*/
    private Date createTime;
    /** 兑换订单号*/
    private String orderNo;
    /** 卡面额*/
    private Integer cardFacePrice;
    /** 卡密*/
    private String cardKey;
    /** 身份标识*/
    private String authSign;
    /** 激活状态标识*/
    private int code;
    /** 激活信息*/
    private String msg;

    public CashFlow() {
    }

    public CashFlow(String orderNo, Integer cardFacePrice, String cardKey, String authSign, int code, String msg) {
        this.orderNo = orderNo;
        this.cardFacePrice = cardFacePrice;
        this.cardKey = cardKey;
        this.authSign = authSign;
        this.code = code;
        this.msg = msg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getCardFacePrice() {
        return cardFacePrice;
    }

    public void setCardFacePrice(Integer cardFacePrice) {
        this.cardFacePrice = cardFacePrice;
    }

    public String getCardKey() {
        return cardKey;
    }

    public void setCardKey(String cardKey) {
        this.cardKey = cardKey;
    }

    public String getAuthSign() {
        return authSign;
    }

    public void setAuthSign(String authSign) {
        this.authSign = authSign;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
