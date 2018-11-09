package cn.mauth.issue.boss.service;

import cn.mauth.issue.boss.utils.SessionUtils;
import cn.mauth.issue.common.dao.CardLogDao;
import cn.mauth.issue.common.entity.CardLog;
import cn.mauth.issue.util.RequestPage;
import cn.mauth.issue.util.base.BaseService;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.enums.CardLogEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CardLogService implements BaseService<CardLog> {

    @Autowired
    private CardLogDao dao;
    @Override
    public int save(CardLog cardLog) {
        cardLog.setGmtCreate(new Date());
        cardLog.setStatus(CardLogEnum.CREATE.getCode());
        return dao.save(cardLog);
    }

    @Override
    public CardLog getById(Long id) {
        return dao.getById(id);
    }

    @Override
    public int deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public Page<CardLog> listForPage(int pageCurrent, int pageSize, CardLog cardLog) {
        /** 判断是否是管理员*/
        if(!SessionUtils.isAdmin()){
            cardLog.setUserId(SessionUtils.getUserInfoId());
        }
        return dao.page(new RequestPage<CardLog>(pageCurrent,pageSize,cardLog," id desc "));
    }

    @Override
    public int updateById(CardLog cardLog) {
        return dao.update(cardLog);
    }

    @Override
    public int updateAllById(CardLog cardLog) {
        return dao.updateAll(cardLog);
    }
}
