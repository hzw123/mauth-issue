package cn.mauth.issue.boss.service;

import cn.mauth.issue.common.dao.CardBillsDao;
import cn.mauth.issue.common.entity.CardBills;
import cn.mauth.issue.util.RequestPage;
import cn.mauth.issue.util.base.BaseService;
import cn.mauth.issue.util.bjui.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardBillsService implements BaseService<CardBills>{

    @Autowired
    private CardBillsDao dao;

    @Override
    public int save(CardBills cardBills) {
        return dao.save(cardBills);
    }

    @Override
    public CardBills getById(Long id) {
        return dao.getById(id);
    }

    @Override
    public int deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public Page<CardBills> listForPage(int pageCurrent, int pageSize, CardBills cardBills) {
        return dao.page(new RequestPage<CardBills>(pageCurrent,pageSize,cardBills," id desc "));
    }

    @Override
    public int updateById(CardBills cardBills) {
        return dao.updateAll(cardBills);
    }

    @Override
    public int updateAllById(CardBills cardBills) {
        return dao.updateAll(cardBills);
    }
}
