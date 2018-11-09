package cn.mauth.issue.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 储值卡订单详情
 */
public class CardBills implements Serializable{
    private static final long serialVersionUID = 1L;
    private Long id;
    /** 储值卡类型ID*/
    private Long cardId;
    /** 数量*/
    private int amount;
    /** 总价*/
    private Double total;
    /** 储值卡订单ID*/
    private Long orderCardId;
    /** 创建时间*/
    private Date gmtCreate;
    /** 卡面额*/
    private Integer cardFacePrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getOrderCardId() {
        return orderCardId;
    }

    public void setOrderCardId(Long orderCardId) {
        this.orderCardId = orderCardId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Integer getCardFacePrice() {
        return cardFacePrice;
    }

    public void setCardFacePrice(Integer cardFacePrice) {
        this.cardFacePrice = cardFacePrice;
    }
}
