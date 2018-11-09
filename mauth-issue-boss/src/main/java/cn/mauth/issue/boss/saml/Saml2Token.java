package cn.mauth.issue.boss.saml;

import org.apache.shiro.authc.UsernamePasswordToken;

import java.util.Map;

public class Saml2Token extends UsernamePasswordToken{
    private static final long serialVersionUID = -5283169468296310309L;

    private Map<String,String> data;

    public Saml2Token() {
    }

    public Saml2Token(String username, char[] password) {
        super(username, password);
    }

    public Saml2Token(String username, String password) {
        super(username, password);
    }

    public Saml2Token(String username, char[] password, String host) {
        super(username, password, host);
    }

    public Saml2Token(String username, String password, String host) {
        super(username, password, host);
    }

    public Saml2Token(String username, char[] password, boolean rememberMe) {
        super(username, password, rememberMe);
    }

    public Saml2Token(String username, String password, boolean rememberMe) {
        super(username, password, rememberMe);
    }

    public Saml2Token(String username, char[] password, boolean rememberMe, String host) {
        super(username, password, rememberMe, host);
    }

    public Saml2Token(String username, String password, boolean rememberMe, String host) {
        super(username, password, rememberMe, host);
    }


    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
