package cn.mauth.issue.util;


import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public final class ZipUtil {

    private static final ZipParameters PARAMETERS;
    private static final char[] PARAM={
            '0','1','2','3','4','5','6','7','8','9',
            'a','b','c','d','e','f','g','h','k','l',
            'A','B','C','D','E','F','G','H','K','L',
            'Q','W','E','R','T','Y','U','I','O','P',
            'q','w','e','r','t','y','u','i','o','P',
            'z','x','c','v','b','n','m','!','@','#',
            '$','^','&','*'
    };

    private static final Logger log= LoggerFactory.getLogger(ZipUtil.class);
    static {
        PARAMETERS=new ZipParameters();
        //设置压缩方法
        PARAMETERS.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        //设置压缩级别
        PARAMETERS.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
        //设置压缩文件加密
        PARAMETERS.setEncryptFiles(true);
        //设置aes加密强度
        PARAMETERS.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);

        PARAMETERS.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
        //设置密码
        PARAMETERS.setPassword(ConfigUtil.ZIP_PWD);
    }

    /**
     * 返回解压密码
     * @param list
     * @param out
     * @return
     */
    public static String makeZip(ArrayList<File> list,OutputStream out,String loadPassword){
        String filename=ZipUtil.getFileName("储值卡信息","zip");
        FileInputStream fis=null;
        loadPassword=loadPassword!=null?loadPassword:ZipUtil.getPwd(6);
        PARAMETERS.setPassword(loadPassword);
        ZipFile zipFile=ZipUtil.doZipFilesWithPassword(list,filename);
        try{
            fis=new FileInputStream(zipFile.getFile());
            byte[] b=new byte[1024];
            int n;
            while ((n=fis.read(b))!=-1){
                out.write(b,0,n);
            }
            out.flush();
            fis.close();
            out.close();
            log.info(filename+"---pwd:"+loadPassword);
            ZipUtil.deleteFile(zipFile.getFile());
        }catch (IOException e){
            log.error("压缩文件出错:"+e);
        }
        return loadPassword;
    }

    public static ZipData makeZipForData(ArrayList<File> list){
        String filename=ZipUtil.getFileName("储值卡信息","zip");
        FileInputStream fis=null;
        String pwd=ZipUtil.getPwd(6);
        PARAMETERS.setPassword(pwd);
        ZipData zipdata=null;
        ZipFile zipFile=ZipUtil.doZipFilesWithPassword(list,filename);
        try {
            fis=new FileInputStream(zipFile.getFile());
            byte[] b=new byte[1024];
            List<String> attrs=new ArrayList<>();
            int n;
            byte[] a;
            while ((n=fis.read(b))!=-1){
                a=new byte[n];
                System.arraycopy(b,0,a,0,n);
                attrs.add(Base64.encodeBase64String(a));
            }
            zipdata=ZipData.success("发送成功",pwd,attrs);
            fis.close();
            ZipUtil.deleteFile(zipFile.getFile());
        }catch (IOException e){
            log.error("压缩文件出错："+e);
        }
        return zipdata;
    }

    public static String getPwd(int length){
        int num;
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<length;i++) {
            num=(int)(Math.random()*63)&63;
            sb.append(PARAM[num]);
        }
        return sb.toString();
    }

    public static ZipFile doZipFilesWithPassword(ArrayList<File> list, String dest) {
        ZipFile zipFile=null;
        try {
            zipFile = new ZipFile(new File(dest));
            zipFile.addFiles(list, PARAMETERS);
        } catch (ZipException e) {
            log.error("压缩文件出错:"+e);
        }
        return zipFile;
    }

    public static String getFileName(String name,String type){
        StringBuffer sb=new StringBuffer();
        sb.append(System.currentTimeMillis());
        sb.append(Math.random()*100000L);
        sb.append("_");
        sb.append(name);
        if(StringUtils.isNotEmpty(type)){
            sb.append(".");
            sb.append(type);
        }
        return sb.toString();
    }

    public static void setResponseHeader(HttpServletResponse response, String filename) {
        try {
            response.reset();// 清空输出流
//            response.setContentType("application/vnd.ms-excel");
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename="
                    + URLEncoder.encode(filename + ".zip", "UTF-8"));
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static Object makeXls(HSSFWorkbook workbook,String filename,boolean flag){
        return makeXls(workbook,filename,flag,null);
    }

    public static Object makeXls(HSSFWorkbook workbook,String filename,boolean flag,String loadPassword){
        Object obj=null;
        try {
            ArrayList<File> list= new ArrayList<>();
            File file=new File(ZipUtil.getFileName(filename,"xls"));
            workbook.write(file);
            list.add(file);
            if(flag){
                HttpServletResponse response=HttpServletUtils.getResponse();
                ZipUtil.setResponseHeader(response,filename);
                obj=ZipUtil.makeZip(list,response.getOutputStream(),loadPassword);
            }else{
                obj=ZipUtil.makeZipForData(list);
            }
            for (File f:list) {
                ZipUtil.deleteFile(f);
            }
        } catch (IOException e) {
            log.error("压解文件出错:"+e);
        }
        return obj;
    }

    public static boolean deleteFile(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    deleteFile(f);
                }
                file.delete();
            } else {
                file.delete();
            }
            return true;
        }
        return false;
    }
}
