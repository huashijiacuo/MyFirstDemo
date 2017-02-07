package com.forFriend;

/**
 * Created by shihuashun on 2016/12/27.
 */

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class DealExcel {

    //默认单元格内容为数字时格式
    private static DecimalFormat df = new DecimalFormat("0");
    // 默认单元格格式化日期字符串
    private static SimpleDateFormat sdf = new SimpleDateFormat(  "yyyy-MM-dd HH:mm:ss");
    // 格式化数字
    private static DecimalFormat nf = new DecimalFormat("0.00");

    private String excelPath = "D:" + File.separator + "data.xlsx";

    public static void main(String[] args) throws Exception{
        DealExcel excel = new DealExcel();
        if(excel.createExcelFile()) {
            System.out.println("data.xlsx is created successfully.");
        }
        //String path = "D:" + File.separator + "forme.xlsx";
        //excel.setExcelPath(path);
        //readExcelFile(excel.getExcelPath());
    }

    /**
     * 创建Excel
     * @return
     */
    public boolean createExcelFile() {
        boolean isCreateSuccess = false;
        Workbook workbook = null;
        try {
            // XSSFWork used for .xslx (>= 2007), HSSWorkbook for 03 .xsl
            workbook = new XSSFWorkbook();//HSSFWorkbook();//WorkbookFactory.create(inputStream);
        }catch(Exception e) {
            System.out.println("It cause Error on CREATING excel workbook: ");
            e.printStackTrace();
        }
        if(workbook != null) {
            Sheet sheet = workbook.createSheet("testdata");
            Row row0 = sheet.createRow(0);
            for(int i = 0; i < 11; i++) {
                Cell cell_1 = row0.createCell(i, Cell.CELL_TYPE_STRING);
                CellStyle style = getStyle(workbook);
                cell_1.setCellStyle(style);
                cell_1.setCellValue("HELLO" + i + "Column");
                sheet.autoSizeColumn(i);
            }
            for (int rowNum = 1; rowNum < 20; rowNum++) {
                Row row = sheet.createRow(rowNum);
                for(int i = 0; i < 11; i++) {
                    Cell cell = row.createCell(i, Cell.CELL_TYPE_STRING);
                    cell.setCellValue("cell" + String.valueOf(rowNum+1) + String.valueOf(i+1));
                }
            }
            try {
                FileOutputStream outputStream = new FileOutputStream(excelPath);
                workbook.write(outputStream);
                outputStream.flush();
                outputStream.close();
                isCreateSuccess = true;
            } catch (Exception e) {
                System.out.println("It cause Error on WRITTING excel workbook: ");
                e.printStackTrace();
            }
        }
        File sss = new File(excelPath);
        System.out.println(sss.getAbsolutePath());
        return isCreateSuccess;
    }
    private CellStyle getStyle(Workbook workbook){
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        // 设置单元格字体
        Font headerFont = workbook.createFont(); // 字体
        headerFont.setFontHeightInPoints((short)14);
        headerFont.setColor(HSSFColor.RED.index);
        headerFont.setFontName("宋体");
        style.setFont(headerFont);
        style.setWrapText(true);

        // 设置单元格边框及颜色
        style.setBorderBottom((short)1);
        style.setBorderLeft((short)1);
        style.setBorderRight((short)1);
        style.setBorderTop((short)1);
        style.setWrapText(true);
        return style;
    }

    /**
     * 读取Excel，返回MyMap对象的list
     * @param filePath
     * @return
     * @throws IOException
     */
    public static List<MyMap>  readExcelFile(String filePath) throws IOException {
        String fileType = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());
        InputStream stream = new FileInputStream(filePath);
        Workbook wb = null;
        if (fileType.equals("xls")) {
            wb = new HSSFWorkbook(stream);
        } else if (fileType.equals("xlsx")) {
            wb = new XSSFWorkbook(stream);
        } else {
            System.out.println("您输入的excel格式不正确");
        }
        Sheet sheet1 = wb.getSheetAt(0);
        Object value;
        List<MyMap> myMapList = new ArrayList<MyMap>();
        int rowNum = 1;

        for (Row row : sheet1) {
            if(rowNum < 3){
                rowNum++;
                continue;
            }
            int cellNum = 1;
            MyMap myMap = new MyMap();
            for (Cell cell : row) {
                switch(cell.getCellType()){
                    case XSSFCell.CELL_TYPE_STRING:
                        // System.out.println(i + "行" + j + " 列 is String type");
                        value = cell.getStringCellValue();
                        break;
                    case XSSFCell.CELL_TYPE_NUMERIC:
                        //value = cell.getNumericCellValue();
                        value = df.format(cell.getNumericCellValue());
                        /*if ("@".equals(cell.getCellStyle().getDataFormatString())) {
                            value = cell.getNumericCellValue();
                        } else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                            value = cell.getNumericCellValue();
                        } else {
                            value = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                        }*/
                        break;
                    case XSSFCell.CELL_TYPE_BOOLEAN:
                        value = Boolean.valueOf(cell.getBooleanCellValue());
                        break;
                    case XSSFCell.CELL_TYPE_BLANK:
                        value = "";
                        break;
                    default:
                        value = cell.toString();
                }// end switch
                //System.out.print(value.toString() + "  ");
                myMap.setParam(value.toString(), cellNum++);
            }
            myMapList.add(myMap);
            //System.out.println();
        }
        return myMapList;
    }

    /**
     *往Excel中写入数据
     * @param outPath
     * @return
     * @throws Exception
     */
    public static boolean writeExcelFile(String outPath) throws Exception {
        String fileType = outPath.substring(outPath.lastIndexOf(".") + 1, outPath.length());
        System.out.println(fileType);
        // 创建工作文档对象
        Workbook wb = null;
        if (fileType.equals("xls")) {
            wb = new HSSFWorkbook();
        } else if (fileType.equals("xlsx")) {
            wb = new XSSFWorkbook();
        } else {
            System.out.println("您的文档格式不正确！");
            return false;
        }
        // 创建sheet对象
        Sheet sheet1 = (Sheet) wb.createSheet("sheet1");
        // 循环写入行数据
        for (int i = 3; i < 5; i++) {
            Row row = (Row) sheet1.createRow(i);
            // 循环写入列数据
            for (int j = 12; j < 15; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(123.0 + j * 2.3);
            }
        }
        // 创建文件流
        OutputStream stream = new FileOutputStream(outPath);
        // 写入数据
        wb.write(stream);
        // 关闭文件流
        stream.close();
        return true;
    }

    public String getExcelPath() {
        return this.excelPath;
    }

    public void setExcelPath(String excelPath) {
        this.excelPath = excelPath;
    }
}
