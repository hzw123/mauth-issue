package cn.mauth.issue.boss.controller.admin;

import cn.mauth.issue.boss.service.CardLogService;
import cn.mauth.issue.common.entity.CardLog;
import cn.mauth.issue.util.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/cardLog")
public class CardLogController extends BaseController{
    private final static String TARGETID = "admin-cardLog";

    @Autowired
    private CardLogService service;

    @RequestMapping(value = "/list")
    public void list(@RequestParam(value = "pageCurrent", defaultValue = "1") int pageCurrent, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, @ModelAttribute CardLog cardLog, ModelMap modelMap) {
        modelMap.put("page", service.listForPage(pageCurrent, pageSize, cardLog));
        modelMap.put("pageCurrent", pageCurrent);
        modelMap.put("pageSize", pageSize);
        modelMap.put("bean", cardLog);
    }

    @RequestMapping(value = "/add")
    public void add() {

    }

    @ResponseBody
    @RequestMapping(value = "/save")
    public String save(@ModelAttribute CardLog cardLog) {
        if (service.save(cardLog) > 0) {
            return success(TARGETID);
        }
        return error("添加失败");
    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public String delete(@RequestParam(value = "id") Long id) {
        if (service.deleteById(id) > 0) {
            return delete(TARGETID);
        }
        return error("删除失败");
    }

    @RequestMapping(value = "/edit")
    public void edit(@RequestParam(value = "id") Long id, ModelMap modelMap) {
        modelMap.put("bean", service.getById(id));
    }

    @ResponseBody
    @RequestMapping(value = "/update")
    public String update(@ModelAttribute CardLog cardLog) {
        if (service.updateById(cardLog) > 0) {
            return success(TARGETID);
        }
        return error("修改失败");
    }

    @RequestMapping(value = "/view")
    public void view(@RequestParam(value = "id") Long id, ModelMap modelMap) {
        modelMap.put("bean", service.getById(id));
    }
}
