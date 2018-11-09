package cn.mauth.issue.common.dao.impl;

import cn.mauth.issue.common.dao.CardInfoDao;
import cn.mauth.issue.common.entity.CardInfo;
import cn.mauth.issue.common.mapper.CardInfoMapper;
import cn.mauth.issue.util.RequestPage;
import cn.mauth.issue.util.base.AbstractBaseJdbc;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.StatisticsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardInfoDaoImpl extends AbstractBaseJdbc implements CardInfoDao {


    @Autowired
    private CardInfoMapper mapper;

    @Override
    public int save(CardInfo cardInfo) {
        return mapper.insert(cardInfo);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteById(id);
    }

    @Override
    public int update(CardInfo cardInfo) {
        return mapper.update(cardInfo);
    }

    @Override
    public CardInfo getById(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public Page<CardInfo> page(RequestPage<CardInfo> requestPage) {
        return page(requestPage,mapper);
    }

    @Override
    public int updateAll(CardInfo cardInfo) {
        return mapper.updateAll(cardInfo);
    }

    @Override
    public CardInfo findByUUID(String uuid) {
        return mapper.findByUUID(uuid);
    }

    @Override
    public List<CardInfo> getOrderId(Long orderId) {
        return mapper.findByOrderCardId(orderId);
    }

    @Override
    public List<CardInfo> findByOrderIds(List<Long> ids) {
        return mapper.findByOrderCardIds(ids);
    }

    @Override
    public List<CardInfo> findByOrderCardPayId(Long payId) {
        return mapper.findByOrderCardPayId(payId);
    }

    @Override
    public int activeStatus(Long id) {
        return mapper.activeStatus(id);
    }

    @Override
    public List<StatisticsInfo> getCashFace(List<Long> nos) {
        return mapper.getCashOut(nos);
    }

    @Override
    public CardInfo findByUUIDAndAuthSign(String cardKey, String authSign) {
        return mapper.findByUUIDAndAuthSign(cardKey,authSign);
    }
}
