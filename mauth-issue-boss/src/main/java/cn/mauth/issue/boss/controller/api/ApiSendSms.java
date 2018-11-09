package cn.mauth.issue.boss.controller.api;


import cn.mauth.issue.boss.service.OrderCardService;
import cn.mauth.issue.common.entity.OrderCard;
import cn.mauth.issue.util.AliyunSendSms;
import cn.mauth.issue.util.base.BaseController;
import cn.mauth.issue.util.bjui.Phone;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/sendSms")
public class ApiSendSms extends BaseController {

    @Autowired
    private OrderCardService service;

    @RequestMapping("/rote")
    public String sendSms(@ModelAttribute Phone phone) {
        if(phone==null)
            return error("请输入数据！");
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        if(!StringUtils.isNotEmpty(phone.getPhone()))
            return error("请输入手机号");
        Matcher m=p.matcher(phone.getPhone());
        if(!m.matches()){
            logger.info("手机号："+phone+"格式错误!");
            return error("手机号格式错误");
        }
        OrderCard oc=service.getById(phone.getId());
        if(oc!=null){
            if(StringUtils.isNotEmpty(oc.getLoadPassword())){
                try {
                    logger.info("发送短信到手机号："+phone.getPhone()+"!");
                    SendSmsResponse response=AliyunSendSms.sendSmsOfDysmsapi(phone.getPhone(),oc.getLoadPassword());
                    if(response.getCode()!=null&&response.getCode().equals("OK")){
                        logger.info("发送短信到"+phone.getPhone()+"成功！");
                        return success("短信发送成功");
                    }else{
                        logger.info("发送短信到"+phone.getPhone()+"失败！");
                        return error("短信发送失败");
                    }
                }catch (ClientException c){
                    logger.info("发送短信异常："+c);
                    c.printStackTrace();
                }
            }
            return error("这个订单没有付款");

        }

        return error("这个订单不错在");
    }
}
