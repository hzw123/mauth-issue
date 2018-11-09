package cn.mauth.issue.boss.service;

import cn.mauth.issue.common.dao.CashFlowDao;
import cn.mauth.issue.common.entity.CashFlow;
import cn.mauth.issue.util.RequestPage;
import cn.mauth.issue.util.base.BaseService;
import cn.mauth.issue.util.bjui.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CashFlowService implements BaseService<CashFlow> {

    @Autowired
    private CashFlowDao dao;

    @Override
    public int save(CashFlow cashFlow) {
        return dao.save(cashFlow);
    }

    @Override
    public CashFlow getById(Long id) {
        return dao.getById(id);
    }

    @Override
    public int deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public Page<CashFlow> listForPage(int pageCurrent, int pageSize, CashFlow cashFlow) {
        return dao.page(new RequestPage<>(pageCurrent,pageSize,cashFlow," id desc "));
    }

    @Override
    public int updateById(CashFlow cashFlow) {
        return dao.update(cashFlow);
    }

    @Override
    public int updateAllById(CashFlow cashFlow) {
        return dao.updateAll(cashFlow);
    }

    public CashFlow findActive(CashFlow cashFlow){
        if(cashFlow==null)
            return null;
        return dao.findActive(cashFlow);
    }
}
