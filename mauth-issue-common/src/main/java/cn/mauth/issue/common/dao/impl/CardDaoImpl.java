package cn.mauth.issue.common.dao.impl;

import cn.mauth.issue.common.dao.CardDao;
import cn.mauth.issue.common.entity.Card;
import cn.mauth.issue.common.mapper.CardMapper;
import cn.mauth.issue.util.RequestPage;
import cn.mauth.issue.util.base.AbstractBaseJdbc;
import cn.mauth.issue.util.bjui.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CardDaoImpl extends AbstractBaseJdbc implements CardDao {

    @Autowired
    private CardMapper cardMapper;

    @Override
    @Transactional
    public int save(Card card) {
        return this.cardMapper.insert(card);
    }

    @Override
    public int deleteById(Long id) {
        return this.cardMapper.deleteById(id);
    }

    @Override
    public int update(Card card) {
        return this.cardMapper.update(card);
    }

    @Override
    public Card getById(Long id) {
        return this.cardMapper.selectById(id);
    }

    @Override
    public Page<Card> page(RequestPage<Card> requestPage) {
        return page(requestPage,cardMapper);
    }

    @Override
    public int updateAll(Card card) {
        return this.cardMapper.updateAll(card);
    }

    @Override
    public List<Card> putAway() {
        return cardMapper.putAway();
    }
}
