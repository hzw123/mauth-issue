package cn.mauth.issue.util.base;

import cn.mauth.issue.util.RequestPage;
import cn.mauth.issue.util.bjui.Page;

import java.io.Serializable;

public interface BaseMauth<T extends Serializable,ID> {
    int save(T t);

    int deleteById(ID id);

    int update(T t);

    T getById(ID id);

    Page<T> page(RequestPage<T> requestPage);

    int updateAll(T t);
}
