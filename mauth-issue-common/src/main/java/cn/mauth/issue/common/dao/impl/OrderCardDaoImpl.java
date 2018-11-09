package cn.mauth.issue.common.dao.impl;

import cn.mauth.issue.common.dao.OrderCardDao;
import cn.mauth.issue.common.entity.OrderCard;
import cn.mauth.issue.common.mapper.OrderCardMapper;
import cn.mauth.issue.util.RequestPage;
import cn.mauth.issue.util.base.AbstractBaseJdbc;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;
import cn.mauth.issue.util.bjui.StatisticalQuery;
import cn.mauth.issue.util.bjui.StatisticsInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderCardDaoImpl extends AbstractBaseJdbc implements OrderCardDao {

    @Autowired
    private OrderCardMapper mapper;

    @Override
    public int save(OrderCard orderCard) {
        return this.mapper.insert(orderCard);
    }

    @Override
    public int deleteById(Long id) {
        return this.mapper.deleteById(id);
    }

    @Override
    public int update(OrderCard orderCard) {
        return this.mapper.update(orderCard);
    }

    @Override
    public int updateAll(OrderCard orderCard) {
        return this.mapper.update(orderCard);
    }

    @Override
    public OrderCard getById(Long id) {
        return this.mapper.selectById(id);
    }

    @Override
    public Page<OrderCard> page(RequestPage<OrderCard> requestPage) {
        return page(requestPage,mapper);
    }

    @Override
    public OrderCard findByOrderNo(Long orderNo) {
        return mapper.findByOrderNo(orderNo);
    }

    @Override
    public int updateLoadPassword(Long id,String loadPassword) {
        return mapper.updateLoadPassword(id,loadPassword);
    }

    @Override
    public String findLoadPassword(Long id) {
        return mapper.findLoadPassword(id);
    }

    @Override
    public Page<StatisticsInfo> selectStatist(RequestPage<StatisticalQuery> requestPage) {
        int pageSize=requestPage.getPageSize();
        int pageCurrent=requestPage.getPageCurrent();
        int count = mapper.statistCount(requestPage.getT());
        pageSize = PageUtil.checkPageSize(pageSize);
        pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
        requestPage.setPageCurrent(pageCurrent);
        requestPage.setPageSize(pageSize);
        requestPage.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
        if(StringUtils.isNotBlank(requestPage.getOrderByClause())){
            requestPage.setOrderByClause(" createTime desc ");
        }
        int totalPage = PageUtil.countTotalPage(count, pageSize);
        return new Page<>(count, totalPage, pageCurrent, pageSize, mapper.selectStatist(requestPage));
    }

    @Override
    public StatisticsInfo findTotalStatistion(StatisticalQuery query) {
        return mapper.findTotalStatistion(query);
    }

    @Override
    public StatisticsInfo findCashStatistion(StatisticalQuery query) {
        return mapper.findCashStatistion(query);
    }
}
