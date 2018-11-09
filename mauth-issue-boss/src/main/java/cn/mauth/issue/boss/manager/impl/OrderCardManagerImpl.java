package cn.mauth.issue.boss.manager.impl;

import cn.mauth.issue.boss.utils.SessionUtils;
import cn.mauth.issue.common.dao.*;
import cn.mauth.issue.common.entity.*;
import cn.mauth.issue.common.manager.CardInfoManager;
import cn.mauth.issue.common.manager.OrderCardManager;
import cn.mauth.issue.util.*;
import cn.mauth.issue.util.enums.CardLogEnum;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class OrderCardManagerImpl implements OrderCardManager,CardInfoManager{

    private static final SimpleDateFormat SDF=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String FILENAME="储值卡信息表";

    public static final String[] ARRAYS={
            "订单已支付完成,并且生成流水以及储值卡",
            "已完成",
            "订单已完成",
            "储值卡订单流水生成失败",
            "没有找到订单流水",
            "储值卡生成失败",
            "订单不存在"
            };

    @Autowired
    private CardDao cardDao;

    @Autowired
    private OrderCardDao orderCardDao;

    @Autowired
    private OrderCardPayDao orderCardPayDao;

    @Autowired
    private CardInfoDao cardInfoDao;

    @Autowired
    private CardLogDao cardLogDao;

    @Autowired
    private CardBillsDao cardBillsDao;

    @Override
    @Transactional
    public String pay(Long orderId) {
        OrderCard orderCard=view(orderId);
        int i=6;
        if(orderCard!=null){
            i=isExit(orderCard);
        }
        return ARRAYS[i];
    }

    private int isExit(OrderCard orderCard){
        if(orderCard.getStatus().equals(ARRAYS[1]))
            return 2;
        int in=createPay(orderCard);
        if(in==3)
            return 3;
        in=createCardInfo(orderCard);
        if(in!=1){
            orderCardDao.updateLoadPassword(orderCard.getId(),ZipUtil.getPwd(6));
            return in;
        }
        return 0;
    }

    private int createPay(OrderCard orderCard){
        Long orderId=orderCard.getId();
        OrderCardPay orderCardPay=new OrderCardPay();
        orderCardPay.setGmtCreate(new Date());
        orderCardPay.setOrderCardId(orderId);
        orderCardPay.setSerialAmount(orderCard.getTotalPrice());
        orderCardPay.setSerialNo(SerialNoUtil.getSerialNo());
        orderCardPay.setSerialType(orderCard.getPayType());
        if(orderCardPayDao.save(orderCardPay)>0){
            return 1;
        }
        return 3;
    }

    private int createCardInfo(OrderCard orderCard){
        OrderCardPay orderCardPay=orderCardPayDao.findByOrderCardId(orderCard.getId());
        if(orderCardPay==null)
            return 4;

        if(orderCard.getList()!=null && orderCard.getList().size()>0){
            Card card=null;
            CardInfo cardInfo=null;
            CardLog cardLog=null;
            Long userId= getUserId();
            Long orderNo=orderCard.getOrderNo();
            String serialNo=orderCardPay.getSerialNo();
            String authSign=orderCard.getAuthSign();
            for (CardBills cb: orderCard.getList()) {
                card=cardDao.getById(cb.getCardId());
                for(int i=0;i<cb.getAmount();i++){
                    cardInfo=new CardInfo();
                    cardInfo.setStatus(1);
                    cardInfo.setGmtModified(new Date());
                    cardInfo.setGmtModified(new Date());
                    cardInfo.setUuid(UUIDUtil.getUUID(""));
                    cardInfo.setOrderCardPayId(orderCardPay.getId());
                    cardInfo.setOrderCardId(orderCard.getId());
                    cardInfo.setDays(card.getValidityTime());
                    cardInfo.setCardType(card.getCardType());
                    cardInfo.setCardFacePrice(card.getCardFacePrice());
                    cardInfo.setSerialNo(serialNo);
                    cardInfo.setOrderNo(orderNo);
                    cardInfo.setExpire(false);
                    cardInfo.setAuthSign(authSign);
                    if(cardInfoDao.save(cardInfo)>0){
                        cardInfo=cardInfoDao.findByUUID(cardInfo.getUuid());
                        createCardLog(cardInfo.getId(),cardLog,userId,
                                "新建储值卡",CardLogEnum.CREATE.getCode());
                    }else{
                        return 5;
                    }
                }
            }
            cardInfo=null;
            cardLog=null;
        }
        setStatus(orderCard.getId());
        orderCard=null;
        return 0;
    }

    /**
     * 创建储值卡信息日志
     * @param cardInfoId
     * @param cardLog
     * @param userId
     * @param msg
     * @param status
     */
    private void createCardLog(Long cardInfoId,CardLog cardLog,Long userId,String msg,Integer status){
        cardLog=new CardLog();
        cardLog.setGmtCreate(new Date());
        cardLog.setMsg(msg);
        cardLog.setOrderCardWaterId(cardInfoId);
        cardLog.setUserId(userId);
        cardLog.setStatus(status);
        cardLogDao.save(cardLog);
    }

    private void setStatus(Long id){
        OrderCard orderCard=new OrderCard();
        orderCard.setId(id);
        orderCard.setStatus(ARRAYS[1]);
        orderCardDao.update(orderCard);
    }

    @Override
    public String createExcel(Long orderId,String loadPassword) {
        return getPwd(cardInfoDao.getOrderId(orderId),loadPassword);
    }

    @Override
    public String createExcel(List<Long> ids) {
        return getPwd(cardInfoDao.findByOrderIds(ids));
    }

    @Override
    public ZipData createExcelData(Long orderId) {
        return getZipData(cardInfoDao.getOrderId(orderId));
    }
    private List<String[]> toArrays(List<CardInfo> list){
        List<String[]> data=new ArrayList<>();
        String[] attrs={"KEY","面额(元)","储值卡类型","平台","有效期到"};
        data.add(attrs);
        for (CardInfo cardInfo:list) {
            data.add(new String[]{
                    cardInfo.getUuid(),
                    String.valueOf(cardInfo.getCardFacePrice()),
                    cardInfo.getCardType(),
                    cardInfo.getAuthSign(),
                    SDF.format(DateUtils.addDays(cardInfo.getGmtCreate(),cardInfo.getDays()))});
        }

        return data;
    }

    /**
     * 激活储值卡
     * @param id
     * @return
     * 返回 0:没有找到;1:该储值卡已激活;2:该储值卡已失效;3:激活成功;4:激活失败;
     */
    @Override
    @Transactional
    public int activateCardInfo(Long id) {
        return active(cardInfoDao.getById(id));
    }


    private int active(CardInfo cardInfo){
        if(cardInfo==null)
            return 1;
        if(cardInfo.getStatus()==CardLogEnum.ACTIVE.getCode())
            return 2;
        if(cardInfo.getExpire())
            return 3;
        if(!toOneAndTwo(cardInfo.getGmtCreate(),cardInfo.getDays())){
            cardInfo.setExpire(true);
            cardInfoDao.update(cardInfo);
            return 3;
        }
        if(cardInfoDao.activeStatus(cardInfo.getId())>0){
            CardLog cardLog=null;
            Long userId=getUserId();
            userId=userId==null?0:userId;
            createCardLog(cardInfo.getId(),cardLog,userId,
                    "激活储蓄卡",CardLogEnum.ACTIVE.getCode());
            return 0;
        }
        return 4;
    }

    private boolean toOneAndTwo(Date time, Integer days){
        return DateUtils.addDays(time,days).getTime()-System.currentTimeMillis()>0?true:false;
    }

    private Long getUserId(){
        return (Long) SessionUtils.getAttribute(Constants.Session.USER_ID);
    }

    private String getPwd(List<CardInfo> list,String loadPassword){
        String pwd=null;
        if(list!=null && list.size()>0){
            List<String[]> data=toArrays(list);
            pwd=ExcelUtil.exportExcel(data,FILENAME,loadPassword);
        }
        return pwd;
    }

    private String getPwd(List<CardInfo> list){
        String pwd=null;
        if(list!=null && list.size()>0){
            List<String[]> data=toArrays(list);
            pwd=ExcelUtil.exportExcel(data,FILENAME);
        }
        return pwd;
    }

    private ZipData getZipData(List<CardInfo> list){
        ZipData zipData=null;
        if(list!=null && list.size()>0){
            List<String[]> data=toArrays(list);
            zipData=ExcelUtil.exportExcelForData(data,FILENAME);
        }
        return zipData;
    }


    @Override
    @Transactional
    public int save(OrderCard orderCard) {
        orderCard.setOrderNo(IdWorker.getId());
        if(sumTotal(orderCard)){
            List<CardBills> list=orderCard.getList();
            orderCard=orderCardDao.findByOrderNo(orderCard.getOrderNo());
            orderCard.setList(list);
            addCardBills(orderCard);
            return 1;
        }
        return 0;
    }

    private boolean sumTotal(OrderCard orderCard){
        List<CardBills> list=orderCard.getList();
        if(list!=null && list.size()>0){
            double total=0;
            Card card=null;
            for (CardBills cardBills:list) {
                card=cardDao.getById(cardBills.getCardId());
                cardBills.setCardFacePrice(card.getCardFacePrice());
                cardBills.setTotal(cardBills.getCardFacePrice()*cardBills.getAmount()*1.0);
                total+=cardBills.getTotal();
            }
            orderCard.setTotalPrice(total);
            return orderCardDao.save(orderCard)>0?true:false;
        }
        return false;
    }

    private boolean addCardBills(OrderCard orderCard){
        if(orderCard.getList()!=null && orderCard.getList().size()>0){
            for (CardBills cardBills:orderCard.getList()) {
                cardBills.setOrderCardId(orderCard.getId());
                cardBillsDao.save(cardBills);
            }
            return true;
        }
        return false;
    }

    @Override
    public OrderCard view(Long id) {
        OrderCard orderCard=orderCardDao.getById(id);
        orderCard.setList(cardBillsDao.findByOrderCardId(orderCard.getId()));
        return orderCard;
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

