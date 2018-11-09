package cn.mauth.issue.boss.controller.admin;

import cn.mauth.issue.boss.service.CardInfoService;
import cn.mauth.issue.common.entity.CardInfo;
//import cn.mauth.issue.common.manager.OrderCardManager;
import cn.mauth.issue.util.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/cardInfo")
public class CardInfoController extends BaseController {

    private final static String TARGETID = "admin-cardInfo";

    @Autowired
    private CardInfoService service;
//    public static final String[] ACTIVE_CARD_INFO={
//            "激活成功",
//            "没有找到",
//            "该储值卡已激活",
//            "该储值卡已失效",
//            "激活失败"
//    };

//    @Autowired
//    private OrderCardManager orderCardManager;

    @RequestMapping(value = "/list")
    public void list(@RequestParam(value = "pageCurrent", defaultValue = "1") int pageCurrent, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, @ModelAttribute CardInfo cardInfo, ModelMap modelMap){
        modelMap.put("page", service.listForPage(pageCurrent, pageSize, cardInfo));
        modelMap.put("pageCurrent", pageCurrent);
        modelMap.put("pageSize", pageSize);
        modelMap.put("bean", cardInfo);
    }

    @RequestMapping(value = "/add")
    public void add(){

    }

    @ResponseBody
    @RequestMapping(value = "/save")
    public String save(@ModelAttribute CardInfo cardInfo){
        if (service.save(cardInfo) > 0) {
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
    public String update(@ModelAttribute CardInfo cardInfo){
        if (service.updateById(cardInfo) > 0) {
            return success(TARGETID);
        }
        return error("修改失败");
    }

    @RequestMapping(value = "/view")
    public void view(@RequestParam(value = "id") Long id, ModelMap modelMap){
        modelMap.put("bean", service.getById(id));
    }


//    @ResponseBody
//    @RequestMapping("/active")
//    public String active(Long id){
//        int no=orderCardManager.activateCardInfo(id);
//        if(no==0){
//            return success(OrderCardManagerImpl.ACTIVE_CARD_INFO[0]);
//        }
//        return error(OrderCardManagerImpl.ACTIVE_CARD_INFO[no]);
//    }
}
