package cn.mauth.issue.common.dao.impl;

import cn.mauth.issue.common.dao.CardBillsDao;
import cn.mauth.issue.common.entity.CardBills;
import cn.mauth.issue.common.mapper.CardBillsMapper;
import cn.mauth.issue.util.RequestPage;
import cn.mauth.issue.util.base.AbstractBaseJdbc;
import cn.mauth.issue.util.bjui.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardBillsDaoImpl extends AbstractBaseJdbc implements CardBillsDao{

    @Autowired
    private CardBillsMapper mapper;

    @Override
    public List<CardBills> findByOrderCardId(Long orderCardId) {
        return mapper.findByOrderCardId(orderCardId);
    }

    @Override
    public int deleteByOrderCardId(Long orderCardId) {
        return mapper.deleteByOrderCardId(orderCardId);
    }

    @Override
    public int save(CardBills cardBills) {
        return mapper.insert(cardBills);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteById(id);
    }

    @Override
    public int update(CardBills cardBills) {
        return mapper.updateAll(cardBills);
    }

    @Override
    public CardBills getById(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public Page<CardBills> page(RequestPage<CardBills> requestPage) {
        return page(requestPage,mapper);
    }

    @Override
    public int updateAll(CardBills cardBills) {
        return mapper.updateAll(cardBills);
    }
}
