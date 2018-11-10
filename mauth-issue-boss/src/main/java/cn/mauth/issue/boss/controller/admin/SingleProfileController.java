package cn.mauth.issue.boss.controller.admin;

import cn.mauth.issue.boss.saml.Saml2Pro;
import cn.mauth.issue.common.entity.SingleProfile;
import cn.mauth.issue.common.mapper.SingleProfileMapper;
import cn.mauth.issue.util.base.BaseController;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/admin/singleProfile")
public class SingleProfileController extends BaseController {

    private final static String TARGETID = "admin-singleProfile";
    private final static String ISSUE_NAME="mauth-issue";

    public static Saml2Pro saml2Pro=new Saml2Pro();

    @Autowired
    private SingleProfileMapper mapper;

    @PostConstruct
    public void setSaml2Pro(){
        BeanUtils.copyProperties(mapper.getSingleeProfileByName(ISSUE_NAME),saml2Pro);
    }

    @GetMapping("/profile")
    public void profile(ModelMap modelMap){
          modelMap.put("bean",saml2Pro);
    }

    @ResponseBody
    @PostMapping("/update")
    public String update(@ModelAttribute SingleProfile singleProfile){
        if (mapper.update(singleProfile) > 0) {
            setSaml2Pro();
            return success(TARGETID);
        }
        return error("修改失败");
    }

}
