package cn.mauth.issue.common.dao;

import cn.mauth.issue.common.entity.CashFlow;
import cn.mauth.issue.util.base.BaseMauth;

public interface CashFlowDao extends BaseMauth<CashFlow,Long> {

    CashFlow findActive(CashFlow cashFlow);
}
