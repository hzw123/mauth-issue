package cn.mauth.issue.util;

import java.util.List;

public class ZipData {

    private boolean flag=false;
    private String msg;
    private String pwd;
    private List<String> data;

    public ZipData() {
    }

    public ZipData(String msg) {
        this.msg = msg;
    }

    public ZipData(boolean flag,String msg, String pwd, List<String> data) {
        this.flag=flag;
        this.msg = msg;
        this.pwd = pwd;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public static ZipData success(String msg, String pwd, List<String> lb){
        return new ZipData(true,msg,pwd,lb);
    }

    public static ZipData error(String msg){
        return new ZipData(msg);
    }
}
