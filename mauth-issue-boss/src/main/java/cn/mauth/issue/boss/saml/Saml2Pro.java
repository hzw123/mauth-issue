package cn.mauth.issue.boss.saml;


import java.io.Serializable;
import java.util.Date;

public class Saml2Pro implements Serializable{

    private static final long serialVersionUID = 1L;

    private String name;
    private Date upTime;
    private String spEntityId;
    private String assertionConsumerService;
    private String singleLogoutService;
    private String loginUrl;
    private String logoutUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public String getSpEntityId() {
        return spEntityId;
    }

    public void setSpEntityId(String spEntityId) {
        this.spEntityId = spEntityId;
    }

    public String getAssertionConsumerService() {
        return assertionConsumerService;
    }

    public void setAssertionConsumerService(String assertionConsumerService) {
        this.assertionConsumerService = assertionConsumerService;
    }

    public String getSingleLogoutService() {
        return singleLogoutService;
    }

    public void setSingleLogoutService(String singleLogoutService) {
        this.singleLogoutService = singleLogoutService;
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

    public String loginAndParam(){
        StringBuffer sb=new StringBuffer(loginUrl);
        sb.append("?SAMLRequest=");
        sb.append(getLoginSAMLRequest());
        return sb.toString();
    }

    public String logoutAndParam(){
        StringBuffer sb=new StringBuffer(logoutUrl);
        sb.append("?SAMLRequest=");
        sb.append(getLogoutSAMLRequest());
        return sb.toString();
    }

    private String getLoginSAMLRequest(){
        return OpenSamlUtil.getSAMLRequest(loginUrl,assertionConsumerService,spEntityId);
    }

    private String getLogoutSAMLRequest(){
        return OpenSamlUtil.getLogoutRequest(logoutUrl,singleLogoutService,spEntityId);
    }
}
