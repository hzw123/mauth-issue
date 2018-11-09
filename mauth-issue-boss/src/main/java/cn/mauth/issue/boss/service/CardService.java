package cn.mauth.issue.boss.service;

import cn.mauth.issue.common.dao.CardDao;
import cn.mauth.issue.common.entity.Card;
import cn.mauth.issue.util.RequestPage;
import cn.mauth.issue.util.base.BaseService;
import cn.mauth.issue.util.bjui.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CardService implements BaseService<Card>{

    @Autowired
    private CardDao cardDao;

    @Override
    public Page<Card> listForPage(int pageCurrent, int pageSize, Card card) {
        return this.cardDao.page(new RequestPage<>(pageCurrent,pageSize,card," id desc "));
    }

    @Override
    public int save(Card card) {
        card.setGmtCreate(new Date());
        return this.cardDao.save(card);
    }

    @Override
    public int deleteById(Long id) {
        return this.cardDao.deleteById(id);
    }

    @Override
    public Card getById(Long id) {
        return this.cardDao.getById(id);
    }

    @Override
    public int updateById(Card card) {
        return this.cardDao.update(card);
    }

    @Override
    public int updateAllById(Card card) {
        return this.cardDao.updateAll(card);
    }

    public List<Card> putAway(){
        return this.cardDao.putAway();
    }
}
