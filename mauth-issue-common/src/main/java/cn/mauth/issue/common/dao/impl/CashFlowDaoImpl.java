package cn.mauth.issue.common.dao.impl;

import cn.mauth.issue.common.dao.CashFlowDao;
import cn.mauth.issue.common.entity.CashFlow;
import cn.mauth.issue.common.mapper.CashFlowMapper;
import cn.mauth.issue.util.RequestPage;
import cn.mauth.issue.util.base.AbstractBaseJdbc;
import cn.mauth.issue.util.bjui.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CashFlowDaoImpl extends AbstractBaseJdbc implements CashFlowDao{

    @Autowired
    private CashFlowMapper mapper;

    @Override
    public CashFlow findActive(CashFlow cashFlow)  {
        return mapper.findActive(cashFlow);
    }

    @Override
    public int save(CashFlow cashFlow) {
        return mapper.insert(cashFlow);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteById(id);
    }

    @Override
    public int update(CashFlow cashFlow) {
        return mapper.update(cashFlow);
    }

    @Override
    public CashFlow getById(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public Page<CashFlow> page(RequestPage<CashFlow> requestPage) {
        return page(requestPage, mapper);
    }

    @Override
    public int updateAll(CashFlow cashFlow) {
        return mapper.updateAll(cashFlow);
    }
}
