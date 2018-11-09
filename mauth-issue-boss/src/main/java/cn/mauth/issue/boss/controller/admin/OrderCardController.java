package cn.mauth.issue.boss.controller.admin;

import cn.mauth.issue.boss.manager.impl.OrderCardManagerImpl;
import cn.mauth.issue.boss.service.CardService;
import cn.mauth.issue.boss.service.OrderCardService;
import cn.mauth.issue.common.entity.OrderCard;
import cn.mauth.issue.common.manager.OrderCardManager;
import cn.mauth.issue.util.base.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/orderCard")
public class OrderCardController extends BaseController{

    private final static String TARGETID = "admin-orderCard";

    @Autowired
    private OrderCardService service;

    @Autowired
    private CardService cardService;

    @Autowired
    private OrderCardManager manager;

    @RequestMapping(value = "/list")
    public void list(@RequestParam(value = "pageCurrent", defaultValue = "1") int pageCurrent, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, @ModelAttribute OrderCard orderCard, ModelMap modelMap){
        modelMap.put("page", service.listForPage(pageCurrent, pageSize, orderCard));
        modelMap.put("pageCurrent", pageCurrent);
        modelMap.put("pageSize", pageSize);
        modelMap.put("bean", orderCard);
    }

    @RequestMapping(value = "/add")
    public void add(){

    }

    @ResponseBody
    @RequestMapping(value = "/save")
    public String save(@ModelAttribute OrderCard orderCard){
        if (manager.save(orderCard) > 0) {
            return success(TARGETID);
        }
        return error("添加失败");
    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public String delete(@RequestParam(value = "id") Long id){
        if (service.deleteById(id) > 0) {
            return delete(TARGETID);
        }
        return error("删除失败");
    }

    @RequestMapping(value = "/edit")
    public void edit(@RequestParam(value = "id") Long id, ModelMap modelMap){
        modelMap.put("bean", service.getById(id));
    }

    @ResponseBody
    @RequestMapping(value = "/update")
    public String update(@ModelAttribute OrderCard orderCard){
        if (service.updateById(orderCard) > 0) {
            return success(TARGETID);
        }
        return error("修改失败");
    }

    @RequestMapping(value = "/view")
    public void view(@RequestParam(value = "id") Long id, ModelMap modelMap){
        modelMap.put("bean", manager.view(id));
    }


    /**
     * 支付订单
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/pay")
    public String pay(@RequestParam(value = "id") Long id){
        String msg=manager.pay(id);
        if(msg.equals(OrderCardManagerImpl.ARRAYS[0])){
            return success(msg);
        }
        return error(msg);
    }

    @RequestMapping(value = "/pwd")
    public void pwd(@RequestParam(value = "id") Long id,ModelMap modelMap){
        modelMap.put("loadPassword",service.getPwd(id));
    }

    @RequestMapping(value = "sendSms")
    public void send(@RequestParam(value = "id") Long id,ModelMap modelMap){
        modelMap.put("id",id);
    }

    /**
     * 下载支付一行的储值卡信息--打包加密zip
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/download")
    public String download(@RequestParam(value = "id") Long id){
        OrderCard orderCard=service.getById(id);
        if(orderCard!=null&&orderCard.getStatus().equals(OrderCardManagerImpl.ARRAYS[1])){
            String pwd=manager.createExcel(id,orderCard.getLoadPassword());
            if(StringUtils.isNotEmpty(pwd))
                return success("正在下载-pwd:"+pwd);
            else
                return error("没有找到储值卡");
        }else{
            return error("该订单未支付完成");
        }
    }

    @ResponseBody
    @RequestMapping("/ids")
    public String getIds(){
        List<Long> ids=new ArrayList<>();
        ids.add(7L);
        ids.add(8L);
        ids.add(9L);
        return manager.createExcel(ids);
    }

    @ModelAttribute
    public void attr(ModelMap modelMap){
        modelMap.put("cardUps",cardService.putAway());
    }

    @ResponseBody
    @RequestMapping("cardUp")
    public Object cardUp(){
        return cardService.putAway();
    }
}
