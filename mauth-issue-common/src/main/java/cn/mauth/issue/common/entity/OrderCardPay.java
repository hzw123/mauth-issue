package cn.mauth.issue.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 储值卡订单支付
 */
public class OrderCardPay implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    /** 支付时间*/
    private Date gmtCreate;
    /** 流水号*/
    private String serialNo;
    /** 流水类型*/
    private String serialType;
    /** 订单id*/
    private Long orderCardId;
    /** 流水金额*/
    private Double serialAmount;
    /**
     * 流水状态
     * 0 交易失败
     * 1 交易成功
     * 5 待处理(初始值)
     * 9 已取消交易
     */
    private Integer status=1;
    /** 备注*/
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

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getSerialType() {
        return serialType;
    }

    public void setSerialType(String serialType) {
        this.serialType = serialType;
    }

    public Long getOrderCardId() {
        return orderCardId;
    }

    public void setOrderCardId(Long orderCardId) {
        this.orderCardId = orderCardId;
    }

    public Double getSerialAmount() {
        return serialAmount;
    }

    public void setSerialAmount(Double serialAmount) {
        this.serialAmount = serialAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
