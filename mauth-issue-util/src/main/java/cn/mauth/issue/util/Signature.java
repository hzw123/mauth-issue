package cn.mauth.issue.util;

public final class Signature {


    public static boolean sign(String sign){
        boolean flag=false;
        if(sign.trim().equals(ConfigUtil.SIGN)){
            flag=true;
        }
        return flag;
    }
}
