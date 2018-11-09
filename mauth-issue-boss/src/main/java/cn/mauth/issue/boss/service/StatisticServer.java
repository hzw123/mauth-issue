package cn.mauth.issue.boss.service;

import cn.mauth.issue.common.dao.CardInfoDao;
import cn.mauth.issue.common.dao.OrderCardDao;
import cn.mauth.issue.util.RequestPage;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.StatisticalQuery;
import cn.mauth.issue.util.bjui.StatisticsInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StatisticServer {

    @Autowired
    private OrderCardDao orderCardDao;
    @Autowired
    private CardInfoDao cardInfoDao;

    public Page<StatisticsInfo> selectStatist(int pageCurrent, int pageSize, StatisticalQuery query){

        if(StringUtils.isEmpty(query.getType()))
            query.setType(null);
        if(StringUtils.isEmpty(query.getUser()))
            query.setUser(null);
        Page<StatisticsInfo> page=orderCardDao.selectStatist(new RequestPage<>(pageCurrent,pageSize,query,null));

        List<StatisticsInfo> list=page.getList();
        if(list!=null&&list.size()>0){
            List<Long> nos=new ArrayList<>();
            Map<Long,StatisticsInfo> map=new HashMap<>();
            for (StatisticsInfo info: list) {
                nos.add(info.getOrderNo());
            }
            List<StatisticsInfo> arry=cardInfoDao.getCashFace(nos);
            if(query!=null&& arry.size()>0){
                for (StatisticsInfo obj:arry) {
                    map.put(obj.getOrderNo(),obj);
                }
            }
            int total=0;
            StatisticsInfo info=null;
            for (int i=0;i<list.size();i++) {
                info=map.get(list.get(i).getOrderNo());
                total=list.get(i).getTotalFace();
                if(info==null){
                    list.get(i).setNoChangeFace(total);
                }else{
                    list.get(i).setCashOutFace(info.getCashOutFace());
                    list.get(i).setNoChangeFace(total-info.getCashOutFace());
                    list.get(i).setCashOutCount(info.getCashOutCount());
                }
            }
            info=null;
            page.setList(list);
        }

        return page;
    }

    public StatisticsInfo getStaticsInfoTotal(StatisticalQuery query){
        if(!StringUtils.isNotEmpty(query.getType()))
            query.setType(null);
        StatisticsInfo totalInfo=orderCardDao.findTotalStatistion(query);
        StatisticsInfo cashInfo=orderCardDao.findCashStatistion(query);
        totalInfo.setCashOutCount(cashInfo.getCashOutCount());
        totalInfo.setCashOutFace(cashInfo.getCashOutFace());
        totalInfo.setNoChangeFace(totalInfo.getTotalFace()-totalInfo.getCashOutFace());
        return totalInfo;
    }
}
