package cn.mauth.issue.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 储值卡信息表
 */
public class CardInfo implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;
    /** 创建时间*/
    private Date gmtCreate;
    /** 修改时间*/
    private Date gmtModified;
    /** 卡面额*/
    private Integer cardFacePrice;
    /** 卡密*/
    private String uuid;
    /** 卡类型*/
    private String cardType;
    /** 订单id*/
    private Long orderCardId;
    /** 订单支付流水id*/
    private Long orderCardPayId;
    /** 状态*/
    private Integer status=0;
    /** 激活有效期 天数*/
    private Integer days;
    /** 是否过期*/
    private Boolean expire;
    /** 备注*/
    private String remark;
    /** 流水号*/
    private String serialNo;
    /** 订单号*/
    private Long orderNo;
    /** 省份标识*/
    private String authSign;

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

    public Integer getCardFacePrice() {
        return cardFacePrice;
    }

    public void setCardFacePrice(Integer cardFacePrice) {
        this.cardFacePrice = cardFacePrice;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Long getOrderCardId() {
        return orderCardId;
    }

    public void setOrderCardId(Long orderCardId) {
        this.orderCardId = orderCardId;
    }

    public Long getOrderCardPayId() {
        return orderCardPayId;
    }

    public void setOrderCardPayId(Long orderCardPayId) {
        this.orderCardPayId = orderCardPayId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Boolean getExpire() {
        return expire;
    }

    public void setExpire(Boolean expire) {
        this.expire = expire;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public String getAuthSign() {
        return authSign;
    }

    public void setAuthSign(String authSign) {
        this.authSign = authSign;
    }
}
