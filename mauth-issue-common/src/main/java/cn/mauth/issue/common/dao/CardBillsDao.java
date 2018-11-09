package cn.mauth.issue.common.dao;

import cn.mauth.issue.common.entity.CardBills;
import cn.mauth.issue.util.base.BaseMauth;

import java.util.List;

public interface CardBillsDao extends BaseMauth<CardBills,Long> {
    List<CardBills> findByOrderCardId(Long orderCardId);

    int deleteByOrderCardId(Long orderCardId);
}
