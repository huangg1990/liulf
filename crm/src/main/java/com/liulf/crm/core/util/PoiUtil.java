package com.liulf.crm.core.util;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PoiUtil {

    public static Map<Integer, List<String[]>> readExcel(File xlsFile) throws Exception {
        // 获得工作簿
        Workbook workbook = WorkbookFactory.create(xlsFile);
        // 获得工作表个数
        int sheetCount = workbook.getNumberOfSheets();
        // 遍历工作表
        Map<Integer, List<String[]>> resMap = new HashMap<>();
        for (int i = 0; i < sheetCount; i++) {
            Sheet sheet = workbook.getSheetAt(i);

            // 获得行数
            int rows = sheet.getLastRowNum() + 1;
            // 获得列数，先获得一行，在得到改行列数
            Row tmp = sheet.getRow(0);
            if (tmp == null) {
                continue;
            }
            int cols = tmp.getPhysicalNumberOfCells();
            List<String[]> sheetTemp = new ArrayList<>();
            // 读取数据
            for (int row = 0; row < rows; row++) {
                String[] tempLine = new String[cols];
                Row r = sheet.getRow(row);
                for (int col = 0; col < cols; col++) {
                    tempLine[col] = r.getCell(col).getStringCellValue();
                    //System.out.printf("%10s", r.getCell(col).getStringCellValue());
                }
                sheetTemp.add(tempLine);
            }
            resMap.put(i, sheetTemp);
        }

        return resMap;

    }

    public static void writeLocalExcel(List<String[]> rows, String filePath) throws Exception {
        HSSFWorkbook workbook = null;
        FileOutputStream fos = null;

        try {
            //创建新工作簿
            workbook = new HSSFWorkbook();
            //新建工作表
            HSSFSheet sheet = workbook.createSheet("result");
            //创建行,行号作为参数传递给createRow()方法,第一行从0开始计算
            for (int i = 0; i < rows.size(); i++) {
                HSSFRow row = sheet.createRow(i);

                for(int c=0;c< rows.get(i).length;c++){
                    //创建单元格,row已经确定了行号,列号作为参数传递给createCell(),第一列从0开始计算
                    HSSFCell cell = row.createCell(c);
                    cell.setCellValue(rows.get(i)[c]);
                }
            }
            fos = new FileOutputStream(new File(filePath));
            workbook.write(fos);
        } finally {
            if (workbook != null) {
                workbook.close();
            }
            if (fos != null) {
                fos.close();
            }
        }

    }
}
