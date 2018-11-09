package cn.mauth.issue.util;

import java.util.UUID;

public final class UUIDUtil {

    public static String getUUID(String str){
        String uuid;
        if(str.trim().equals("")){
            uuid=UUID.randomUUID().toString();
        }else{
           uuid =UUID.nameUUIDFromBytes(str.getBytes()).toString();
        }
        return uuid.toUpperCase();
    }

    public static String getUUIDForNow(){
        int num=(int)Math.random()*9+1;
        byte[] bytes=longBytes(System.currentTimeMillis()*num);
        return UUID.nameUUIDFromBytes(bytes).toString().toUpperCase();
    }

    public static byte[] longBytes(long num) {
        byte[] byteNum = new byte[8];
        for (int ix = 0; ix < 8; ++ix) {
            int offset = 64 - (ix + 1) * 8;
            byteNum[ix] = (byte) ((num >> offset) & 0xff);
        }
        return byteNum;
    }
}
