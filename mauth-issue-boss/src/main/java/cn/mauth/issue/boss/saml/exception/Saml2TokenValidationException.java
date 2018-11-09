package cn.mauth.issue.boss.saml.exception;

import org.apache.shiro.authc.AuthenticationException;

public class Saml2TokenValidationException extends AuthenticationException {
    private static final long serialVersionUID = 2546850717853364959L;

    public Saml2TokenValidationException() {
        super();
    }

    public Saml2TokenValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public Saml2TokenValidationException(String message) {
        super(message);
    }

    public Saml2TokenValidationException(Throwable cause) {
        super(cause);
    }
}
