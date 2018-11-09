package cn.mauth.issue.boss.saml.exception;

import org.apache.shiro.authc.AuthenticationException;

public class Saml2AuthenticationException extends AuthenticationException{

    private static final long serialVersionUID = 2696355552095446164L;

    public Saml2AuthenticationException() {
        super();
    }

    public Saml2AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public Saml2AuthenticationException(String message) {
        super(message);
    }

    public Saml2AuthenticationException(Throwable cause) {
        super(cause);
    }
}
