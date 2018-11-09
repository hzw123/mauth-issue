package cn.mauth.issue.util.base;

import cn.mauth.issue.util.RequestPage;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T extends Serializable,ID> {
    int insert(T t);

    T selectById(ID id);

    int update(T t);

    int deleteById(ID id);

    List<T> page(RequestPage<T> requestPage);

    int count(T t);

    int updateAll(T t);
}
