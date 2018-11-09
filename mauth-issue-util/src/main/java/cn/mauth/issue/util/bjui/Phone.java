package cn.mauth.issue.util.bjui;

import java.io.Serializable;

public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
