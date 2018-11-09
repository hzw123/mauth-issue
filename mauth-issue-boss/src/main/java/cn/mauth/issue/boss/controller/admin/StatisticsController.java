package cn.mauth.issue.boss.controller.admin;

import cn.mauth.issue.boss.service.StatisticServer;
import cn.mauth.issue.util.base.BaseController;
import cn.mauth.issue.util.bjui.StatisticalQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/admin/statistics")
public class StatisticsController extends BaseController {

    private final static String TARGETID = "admin-statistics";

    @Autowired
    private StatisticServer service;

    @RequestMapping(value = "/list")
    public void list(@RequestParam(value = "pageCurrent", defaultValue = "1") int pageCurrent, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, @ModelAttribute StatisticalQuery query, ModelMap modelMap) {
        modelMap.put("page", service.selectStatist(pageCurrent, pageSize, query));
        modelMap.put("pageCurrent", pageCurrent);
        modelMap.put("pageSize", pageSize);
        modelMap.put("bean", query);
    }
}
