package cn.mauth.issue.boss.controller.admin;

import cn.mauth.issue.boss.service.CardService;
import cn.mauth.issue.common.entity.Card;
import cn.mauth.issue.util.UUIDUtil;
import cn.mauth.issue.util.base.BaseController;
import cn.mauth.issue.util.enums.ItemStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin/card")
public class CardController extends BaseController{

    private final static String TARGETID = "admin-card";

    @Autowired
    private CardService service;

    @RequestMapping(value = "/list")
    public void list(@RequestParam(value = "pageCurrent", defaultValue = "1") int pageCurrent, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, @ModelAttribute Card card, ModelMap modelMap){
        modelMap.put("page", service.listForPage(pageCurrent, pageSize, card));
        modelMap.put("pageCurrent", pageCurrent);
        modelMap.put("pageSize", pageSize);
        modelMap.put("bean", card);
    }

    @RequestMapping(value = "/add")
    public void add(){

    }

    @GetMapping("/uuid")
    @ResponseBody
    public String uuid(){
        return UUIDUtil.getUUIDForNow();
    }
    @ResponseBody
    @RequestMapping(value = "/save")
    public String save(@ModelAttribute Card card){
        if (service.save(card) > 0) {
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
    public String update(@ModelAttribute Card card){
        if (service.updateById(card) > 0) {
            return success(TARGETID);
        }
        return error("修改失败");
    }

    @RequestMapping(value = "/view")
    public void view(@RequestParam(value = "id") Long id, ModelMap modelMap){
        modelMap.put("bean", service.getById(id));
    }

    @ModelAttribute
    public void enums(ModelMap modelMap) {
        modelMap.put("itemStatusEnums", ItemStatusEnum.values());
    }

}
