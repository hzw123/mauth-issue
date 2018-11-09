package cn.mauth.issue.util.base;

import cn.mauth.issue.util.bjui.Page;

import java.io.Serializable;

public interface BaseService<T extends Serializable> {

    int save(T t);

    T getById(Long id);

    int deleteById(Long id);

    Page<T> listForPage(int pageCurrent, int pageSize, T t);

    int updateById(T t);

    int updateAllById(T t);
}
