package cn.mauth.issue.boss.controller.admin;

import cn.mauth.issue.boss.service.CashFlowService;
import cn.mauth.issue.common.entity.CashFlow;
import cn.mauth.issue.util.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/cashFlow")
public class CashFlowController extends BaseController {

    private final static String TARGETID = "admin-cashFlow";

    @Autowired
    private CashFlowService service;

    @RequestMapping(value = "/list")
    public void list(@RequestParam(value = "pageCurrent", defaultValue = "1") int pageCurrent, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, @ModelAttribute CashFlow cashFlow, ModelMap modelMap) {
        modelMap.put("page", service.listForPage(pageCurrent, pageSize, cashFlow));
        modelMap.put("pageCurrent", pageCurrent);
        modelMap.put("pageSize", pageSize);
        modelMap.put("bean", cashFlow);
    }

    @RequestMapping(value = "/add")
    public void add() {

    }

    @ResponseBody
    @RequestMapping(value = "/save")
    public String save(@ModelAttribute CashFlow cashFlow) {
        if (service.save(cashFlow) > 0) {
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
    public String update(@ModelAttribute CashFlow cashFlow) {
        if (service.updateById(cashFlow) > 0) {
            return success(TARGETID);
        }
        return error("修改失败");
    }

    @RequestMapping(value = "/view")
    public void view(@RequestParam(value = "id") Long id, ModelMap modelMap) {
        modelMap.put("bean", service.getById(id));
    }
}
