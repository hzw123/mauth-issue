package cn.mauth.issue.security.agent.controller;

import cn.mauth.issue.common.entity.CardInfo;
import cn.mauth.issue.common.entity.CashFlow;
import cn.mauth.issue.common.manager.CardInfoExchange;
import cn.mauth.issue.util.ConfigUtil;
import cn.mauth.issue.util.EncryptUtil;
import cn.mauth.issue.util.Signature;
import cn.mauth.issue.util.annotation.Api;
import cn.mauth.issue.util.base.Result;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/cardInfo")
public class ExChangeController {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CardInfoExchange server;

    @Api
    @RequestMapping(value = "/exchange",method = RequestMethod.POST)
    public Map<String,String> exchange(@RequestParam Map<String,String> data)throws Exception{
        if(data==null)
            throw new Exception("没有数据");
        for (Map.Entry<String,String> entry: data.entrySet()) {
            logger.warn("======="+entry.getKey()+":"+entry.getValue());
        }
        String cardKey=data.get("key");
        String orderNo=data.get("orderNo");
        String token=data.get("token");
        String mac=data.get("mac");

        return server.exchange(cardKey,token,orderNo,mac);
    }

    @RequestMapping("/query")
    @Api("获得储值卡信息")
    public Result<CardInfo> query(String sign, String cardKey,String authSign){

        if(!StringUtils.isNotEmpty(sign)||!StringUtils.isNotEmpty(cardKey)||!StringUtils.isNotEmpty(authSign))
            return Result.error("请求参数缺失！");
        if(!Signature.sign(sign)){
            return Result.error("sing验证错误！");
        }

        if(!StringUtils.isNotBlank(cardKey))
            return Result.error("uuid为空");
        CardInfo orderCardWater=server.query(cardKey,authSign);
        if(orderCardWater!=null){
            return Result.success(orderCardWater);
        }
        return Result.error("查询失败");
    }

    @Api("查询激活日志")
    @RequestMapping(value = "/queryCashFlow",method = RequestMethod.POST)
    public CashFlow findByApi(@RequestParam Map<String,String> data)throws Exception{
        String cardKey=data.get("key");
        String orderNo=data.get("orderNo");
        String token=data.get("token");
        String mac=data.get("mac");
        String en_mac=EncryptUtil.getMac(new String[]{cardKey,token,orderNo,ConfigUtil.getProperty(token)});
        if(!mac.equals(en_mac)){
            throw new Exception("mac检验失败");
        }
        logger.info("\nmac:"+mac+",\nen_mac:"+en_mac);
        CashFlow cashFlow=new CashFlow();
        cashFlow.setCardKey(cardKey);
        cashFlow.setOrderNo(orderNo);
        cashFlow.setAuthSign(token);
        return server.find(cashFlow);
    }

}
