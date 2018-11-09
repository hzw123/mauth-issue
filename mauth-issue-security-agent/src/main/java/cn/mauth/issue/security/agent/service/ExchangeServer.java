package cn.mauth.issue.security.agent.service;

import cn.mauth.issue.common.dao.CardInfoDao;
import cn.mauth.issue.common.dao.CardLogDao;
import cn.mauth.issue.common.dao.CashFlowDao;
import cn.mauth.issue.common.entity.CardInfo;
import cn.mauth.issue.common.entity.CardLog;
import cn.mauth.issue.common.entity.CashFlow;
import cn.mauth.issue.common.manager.CardInfoExchange;
import cn.mauth.issue.common.manager.CardInfoManager;
import cn.mauth.issue.util.ConfigUtil;
import cn.mauth.issue.util.EncryptUtil;
import cn.mauth.issue.util.JSONUtil;
import cn.mauth.issue.util.enums.CardLogEnum;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class ExchangeServer implements CardInfoExchange,CardInfoManager {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String[][] EXCHANGE_VALUES={
            {"兑换成功","200"},
            {"该兑换码没有找到","400"},
            {"该兑换码已兑换","100"},
            {"该兑换码已过期","600"},
            {"兑换失败","300"}
    };

    @Autowired
    private CashFlowDao cashFlowDao;
    @Autowired
    private CardInfoDao cardInfoDao;
    @Autowired
    private CardLogDao cardLogDao;

    @Override
    public CardInfo query(String cardKey,String authSign) {
        return queryCardInfo(cardKey,authSign);
    }

    @Override
    @Transactional
    public Map<String, String> exchange(String cardKey,String authSign,String orderNo,String mac) {
        Map<String,String> data=new HashMap<>();

        String en_mac= EncryptUtil.getMac(new String[]{cardKey,authSign,orderNo, ConfigUtil.getProperty(authSign)});
        logger.info("\nmac:"+mac+",\nen_mac:"+en_mac);
        if(!mac.equals(en_mac)){
            data.put("code","0");
            data.put("message","mac校验错误");
            return data;
        }

        CardInfo cardInfo=queryCardInfo(cardKey,authSign);
        int index=exchange(cardInfo);
        cardInfo=queryCardInfo(cardKey,authSign);

        String code=EXCHANGE_VALUES[index][1];
        String msg=EXCHANGE_VALUES[index][0];

        data.put("code",code);
        data.put("message",msg);
        int facePrice=0;

        if(cardInfo!=null){
            facePrice=cardInfo.getCardFacePrice();
            CashFlow cashFlow=new CashFlow(orderNo,facePrice,cardKey,authSign,Integer.valueOf(code),msg);
            cashFlowDao.save(cashFlow);

            if("200".equals(code)){
                cashFlow=cashFlowDao.findActive(cashFlow);
                data.put("data", JSONUtil.toJSONString(cashFlow));
            }
        }
        return data;
    }

    public CashFlow find(CashFlow cashFlow){
        return cashFlowDao.findActive(cashFlow);
    }

    private int active(CardInfo cardInfo){
        if(cardInfo==null)
            return 1;
        if(cardInfo.getStatus()== CardLogEnum.ACTIVE.getCode())
            return 2;
        if(cardInfo.getExpire())
            return 3;
        if(!toOneAndTwo(cardInfo.getGmtCreate(),cardInfo.getDays())){
            cardInfo.setExpire(true);
            cardInfoDao.update(cardInfo);
            return 3;
        }
        if(cardInfoDao.activeStatus(cardInfo.getId())>0){
            CardLog cardLog=new CardLog();
            cardLog.setGmtCreate(new Date());
            cardLog.setMsg("激活储蓄卡");
            cardLog.setOrderCardWaterId(cardInfo.getId());
            cardLog.setUserId(0L);
            cardLog.setStatus(CardLogEnum.ACTIVE.getCode());
            cardLogDao.save(cardLog);
            return 0;
        }
        return 4;
    }

    private boolean toOneAndTwo(Date time, Integer days){
        return DateUtils.addDays(time,days).getTime()-System.currentTimeMillis()>0?true:false;
    }

    @Override
    public CardInfo queryCardInfo(String cardKey, String authSign) {
        return cardInfoDao.findByUUIDAndAuthSign(cardKey,authSign);
    }

    @Override
    public int exchange(CardInfo cardInfo) {
        return active(cardInfo);
    }
}
