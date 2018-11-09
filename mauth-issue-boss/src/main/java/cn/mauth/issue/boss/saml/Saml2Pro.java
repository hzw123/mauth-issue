package cn.mauth.issue.boss.saml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Saml2Pro {

    @Value("${saml2.shiro.serverUrlPrefix}")
    private String serverUrlPrefix;
    @Value("${saml2.shiro.casService}")
    private String casService;
    @Value("${saml2.shiro.successUrl}")
    private String successUrl;
    @Value("${saml2.shiro.failureUrl}")
    private String failureUrl;
    @Value("${saml2.shiro.loginUrl}")
    private String loginUrl;
    @Value("${saml2.shiro.logoutUrl}")
    private String logoutUrl;

    public String getServerUrlPrefix() {
        return serverUrlPrefix;
    }

    public void setServerUrlPrefix(String serverUrlPrefix) {
        this.serverUrlPrefix = serverUrlPrefix;
    }

    public String getCasService() {
        return casService;
    }

    public void setCasService(String casService) {
        this.casService = casService;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getFailureUrl() {
        return failureUrl;
    }

    public void setFailureUrl(String failureUrl) {
        this.failureUrl = failureUrl;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

    public String getLonginAndParam(){
        StringBuffer sb=new StringBuffer(this.getLoginUrl());
        sb.append("?SAMLRequest=");
        sb.append(getLoginSAMLRequest());
        return sb.toString();
    }

    public String getLogoutAndParam(){
        StringBuffer sb=new StringBuffer(this.getLogoutUrl());
        sb.append("?SAMLRequest=");
        sb.append(getLogoutSAMLRequest());
        return sb.toString();
    }

    private String getLoginSAMLRequest(){
        return OpenSamlUtil.getSAMLRequest(loginUrl,successUrl,serverUrlPrefix);
    }

    private String getLogoutSAMLRequest(){
        return OpenSamlUtil.getLogoutRequest(logoutUrl,serverUrlPrefix+"/exit",serverUrlPrefix);
    }
}
