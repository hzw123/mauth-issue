package cn.mauth.issue.boss.service;

import cn.mauth.issue.common.dao.CardInfoDao;
import cn.mauth.issue.common.entity.CardInfo;
import cn.mauth.issue.util.RequestPage;
import cn.mauth.issue.util.UUIDUtil;
import cn.mauth.issue.util.base.BaseService;
import cn.mauth.issue.util.bjui.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardInfoService implements BaseService<CardInfo>{

    @Autowired
    private CardInfoDao cardInfoDao;

    @Override
    public int save(CardInfo cardInfo) {
        cardInfo.setExpire(false);
        cardInfo.setUuid(UUIDUtil.getUUIDForNow());
        return cardInfoDao.save(cardInfo);
    }

    @Override
    public CardInfo getById(Long id) {
        return cardInfoDao.getById(id);
    }

    @Override
    public int deleteById(Long id) {
        return cardInfoDao.deleteById(id);
    }

    @Override
    public Page<CardInfo> listForPage(int pageCurrent, int pageSize, CardInfo cardInfo) {
        return cardInfoDao.page(new RequestPage<CardInfo>(pageCurrent,pageSize,cardInfo," id desc "));
    }

    @Override
    public int updateById(CardInfo cardInfo) {
        return cardInfoDao.update(cardInfo);
    }

    @Override
    public int updateAllById(CardInfo cardInfo) {
        return cardInfoDao.updateAll(cardInfo);
    }

    public CardInfo findByUUID(String uuid){
        return cardInfoDao.findByUUID(uuid);
    }

    public List<CardInfo> getOrderId(Long orderId){
        return cardInfoDao.getOrderId(orderId);
    }

    public List<CardInfo> getPayId(Long payId){
        return cardInfoDao.findByOrderCardPayId(payId);
    }

}
