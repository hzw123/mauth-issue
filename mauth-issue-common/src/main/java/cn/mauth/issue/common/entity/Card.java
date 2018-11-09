package cn.mauth.issue.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 储值卡
 */
public class Card implements Serializable{
    private static final long serialVersionUID = 1L;
    private Long id;
    private Date gmtCreate;
    /** 卡名称*/
    private String cardName;
    /** 卡面额*/
    private Integer cardFacePrice;
    /** 商品类型*/
    private String cardType;
    /**
     * 状态：1 初始，2正常，3下架
     */
    private Integer cardStatus=0;
    /** 有效期 天数*/
    private Integer validityTime;

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

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Integer getCardFacePrice() {
        return cardFacePrice;
    }

    public void setCardFacePrice(Integer cardFacePrice) {
        this.cardFacePrice = cardFacePrice;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Integer getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(Integer cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Integer getValidityTime() {
        return validityTime;
    }

    public void setValidityTime(Integer validityTime) {
        this.validityTime = validityTime;
    }
}
