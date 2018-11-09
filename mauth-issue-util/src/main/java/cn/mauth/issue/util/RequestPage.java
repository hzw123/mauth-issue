package cn.mauth.issue.util;

import java.io.Serializable;

public final class RequestPage<T extends Serializable> {

    /**当前页*/
    private int pageCurrent;

    /**每页记录数*/
    private int pageSize=10;

    private T t;

    /** 排序*/
    private String orderByClause;

    private int limitStart=-1;

    public RequestPage() {
    }

    public RequestPage(int pageCurrent, int pageSize, T t, String orderByClause) {
        this.pageCurrent = pageCurrent;
        this.pageSize = pageSize;
        this.t = t;
        this.orderByClause = orderByClause;
    }

    public int getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(int pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitStart(int limitStart) {
        this.limitStart = limitStart;
    }
}
