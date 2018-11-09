package cn.mauth.issue.util;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;

import java.util.List;

public final class ExcelUtil {

    public static HSSFWorkbook getHSSFWorkbook(List<String[]> data, String filename){
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(filename);
        // 设置表格默认列宽度为15个字节
//        sheet.setDefaultColumnWidth(15);

        sheet.setColumnWidth(0,9000);
        sheet.setColumnWidth(1,2000);
        sheet.setColumnWidth(2,3000);
        sheet.setColumnWidth(3,4500);

        for (int i = 0; i < data.size(); i++) {
            String[] dataArray = data.get(i);
            // 产生表格标题行
            HSSFRow row = sheet.createRow(i);
            for (int j = 0; j < dataArray.length; j++) {
                //列
                HSSFCell cell = row.createCell(j);
                if (!StringUtils.isNotBlank(dataArray[j])) {
                    dataArray[j] = "";
                }
                //设置列的值 string
                HSSFRichTextString text = new HSSFRichTextString(dataArray[j]);
                cell.setCellValue(text);
            }
        }
        return workbook;
    }

    public static String exportExcel(List<String[]> data, String filename,String loadPassword) {
        return ZipUtil.makeXls(ExcelUtil.getHSSFWorkbook(data,filename),filename,true,loadPassword).toString();
    }

    public static String exportExcel(List<String[]> data, String filename) {
        return ZipUtil.makeXls(ExcelUtil.getHSSFWorkbook(data,filename),filename,true).toString();
    }

    public static ZipData exportExcelForData(List<String[]> data, String filename){
        return (ZipData) ZipUtil.makeXls(ExcelUtil.getHSSFWorkbook(data,filename),filename,false);
    }
}