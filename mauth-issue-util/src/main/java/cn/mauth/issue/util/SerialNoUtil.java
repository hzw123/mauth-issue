package cn.mauth.issue.util;

public final class SerialNoUtil {

    private static int NO=0;

    private static final int MAX=0xfff;

    private static final int LENGTH=5;

    public synchronized static String getSerialNo(){
        setNo();
        StringBuffer sb=new StringBuffer(String.valueOf(NOUtil.getTradeNo()));
        int id_length=String.valueOf(SerialNoUtil.NO).length();
        for (int i=0;i<LENGTH-id_length;i++) {
            sb.append("0");
        }
        sb.append(SerialNoUtil.NO);
        return sb.toString();
    }

    public static void setNo(){
        NO++;
        if(NO>MAX)
            NO=0;
    }
}
