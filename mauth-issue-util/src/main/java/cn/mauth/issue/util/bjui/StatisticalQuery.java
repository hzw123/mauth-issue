package cn.mauth.issue.util.bjui;

import java.io.Serializable;
import java.util.Date;

public class StatisticalQuery implements Serializable {

    private static final long serialVersionUID =1L;
    private Long orderNo;
    private Date start;
    private Date stopTime;
    private String type;
    private String user;

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
