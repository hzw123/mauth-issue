package cn.mauth.issue.common.mapper;

import cn.mauth.issue.common.entity.CashFlow;
import cn.mauth.issue.util.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CashFlowMapper extends BaseMapper<CashFlow,Long> {

    CashFlow findActive(CashFlow cashFlow);
}
