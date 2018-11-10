package cn.mauth.issue.boss.controller;

import cn.mauth.issue.boss.controller.admin.SingleProfileController;
import cn.mauth.issue.boss.saml.OpenSamlUtil;
import cn.mauth.issue.boss.saml.Saml2Token;
import cn.mauth.issue.boss.utils.HttpUtils;
import cn.mauth.issue.util.base.BaseController;
import org.apache.shiro.SecurityUtils;
import org.opensaml.core.xml.schema.XSString;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.saml.saml2.core.Attribute;
import org.opensaml.saml.saml2.core.Response;
import org.opensaml.saml.saml2.core.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SSOController extends BaseController {

    @PostMapping("/sso")
    public String loginSSO(HttpServletRequest request, ModelMap modelMap)throws Exception{
        try {

            Response response=OpenSamlUtil.convertToken(request);

            String status=response.getStatus().getStatusCode().getValue();
            if(!status.equals(StatusCode.SUCCESS)){
                logger.error("status", "没有通过验证");

                modelMap.put("msg", "没有通过验证");

                return "login";
            }
            Assertion assertion=response.getAssertions().get(0);

            String sessionIndex=assertion.getAuthnStatements().get(0).getSessionIndex();

            String nameId = assertion.getSubject().getNameID().getValue();

            Map<String,String> data= new HashMap<>();

            for (Attribute attribute: assertion.getAttributeStatements().get(0).getAttributes()) {
                XSString xsString=(XSString) attribute.getAttributeValues().get(0);
                data.put(attribute.getName(),xsString.getValue());
            }
            Saml2Token token=new Saml2Token(nameId,sessionIndex);
            token.setData(data);
            SecurityUtils.getSubject().login(token);

            HttpUtils.setSessionIndex(sessionIndex);

            return redirect("/index");
        } catch (Exception e) {
            logger.error("登录异常:"+e.getMessage());

            modelMap.put("msg", e.getMessage());

            return "login";
        }
    }

    @GetMapping("/sso")
    public String loginSSO(HttpServletResponse response)throws Exception{
        if(HttpUtils.isUser()){

            return redirect("/index");

        }else{
            String login= SingleProfileController.saml2Pro.loginAndParam();

            logger.info("send:"+login);

            response.sendRedirect(login);

            return null;
        }
    }

    @GetMapping("/logout")
    public void logout(HttpServletResponse response) throws Exception{
        if(HttpUtils.isUser()){
            String logout=SingleProfileController.saml2Pro.logoutAndParam();
            response.sendRedirect(logout);
        }else{
            response.sendRedirect("/exit");
        }
    }
}
