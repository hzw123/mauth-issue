package cn.mauth.issue.common.dao.impl;

import cn.mauth.issue.common.dao.CardLogDao;
import cn.mauth.issue.common.entity.CardLog;
import cn.mauth.issue.common.mapper.CardLogMapper;
import cn.mauth.issue.util.RequestPage;
import cn.mauth.issue.util.base.AbstractBaseJdbc;
import cn.mauth.issue.util.bjui.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CardLogDaoImpl extends AbstractBaseJdbc implements CardLogDao {

    @Autowired
    private CardLogMapper mapper;

    @Override
    public int save(CardLog cardLog) {
        return this.mapper.insert(cardLog);
    }

    @Override
    public int deleteById(Long id) {
        return this.mapper.deleteById(id);
    }

    @Override
    public int update(CardLog cardLog) {
        return this.mapper.update(cardLog);
    }

    @Override
    public int updateAll(CardLog cardLog) {
        return this.mapper.update(cardLog);
    }

    @Override
    public CardLog getById(Long id) {
        return this.mapper.selectById(id);
    }

    @Override
    public Page<CardLog> page(RequestPage<CardLog> requestPage) {
        return page(requestPage, mapper);
    }
}