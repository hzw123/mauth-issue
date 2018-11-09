package cn.mauth.issue.boss.controller.api;

import cn.mauth.issue.boss.service.CardInfoService;
import cn.mauth.issue.boss.utils.SessionUtils;
import cn.mauth.issue.common.entity.CardInfo;
import cn.mauth.issue.common.entity.SysMenu;
import cn.mauth.issue.util.*;
import cn.mauth.issue.util.annotation.Api;
import cn.mauth.issue.util.base.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    private CardInfoService cardInfoService;
    private static final SimpleDateFormat SDF=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @GetMapping("/uuid")
    @Api("查询uuid")
    public Result<String> uuid(String param){
        if(!StringUtils.isNotEmpty(param)){
            return Result.error("没有参数");
        }
        return Result.success(UUIDUtil.getUUID(param));
    }

    @GetMapping("/uid")
    @Api("/api/v1/uid")
    public Result<String> getUUID(){
        return Result.success(UUIDUtil.getUUIDForNow());
    }

    @RequestMapping("/bill")
    @Api("获得批量储值卡信息")
    public Result<CardInfo> bill(String sign, Long orderId){
        if(!StringUtils.isNotEmpty(sign))
            return Result.error("没有验证sign");
        if(!Signature.sign(sign)){
            return Result.error("sing验证错误");
        }
        List<CardInfo> cardInfos=cardInfoService.getOrderId(orderId);
        if(cardInfos!=null&&cardInfos.size()>0){
            return Result.success(cardInfos);
        }

        return Result.error("没有找到");
    }


    @GetMapping("/auth")
    public Result<SysMenu> getAuth(){
        String json=(String) SessionUtils.getAttribute(Constants.Session.MENU);
        if(!StringUtils.isNotEmpty(json)){
            return Result.error("没有登录");
        }
        return Result.success(JSONUtil.parseArray(json,SysMenu.class));
    }

}
