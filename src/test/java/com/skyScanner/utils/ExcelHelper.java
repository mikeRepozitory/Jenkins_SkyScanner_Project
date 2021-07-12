package com.skyScanner.utils;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelHelper {

    private  static Logger logger = Logger.getLogger(ExcelHelper.class);

    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static String[] datas;
    private static XSSFCell cell;

    public void setExcelFile(String excelFilePath) throws IOException {
        workbook = new XSSFWorkbook(excelFilePath);
        logger.info("Work Book initialized");
    }

    public void setExcelSheet(String sheetName){
       sheet = workbook.getSheet(sheetName);
       logger.info("ExcelSheet is set");
    }

    public String getCellData(String tcName, String columnName){
        int rowIndex = getRowIndex(tcName);
        int colIndex  = getColIndex(columnName);
        String data =  sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
        logger.info("Data is fetched: " + data);
       return data;
    }

    public String[] getRowDatas(String tcName){
        int tcRowIndex = getRowIndex(tcName);
        row = sheet.getRow(tcRowIndex);
        int cellCount = row.getPhysicalNumberOfCells();
        datas = new String[cellCount];
        for(int i = 0; i < cellCount; i++){
            datas[i] = row.getCell(i).getStringCellValue();
        }
        logger.info("Datas are fetched: " + datas);
        return datas;
    }

    private int getRowIndex(String tcName){
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        int rowIndex = 0;
        for(int i =1; i<=rowCount; i++){
            XSSFRow row = sheet.getRow(i);
            String testCaseName = row.getCell(0).getStringCellValue();
            if(testCaseName.equalsIgnoreCase(tcName)){
                rowIndex = i;
                break;
            }

        }
        return rowIndex;
    }

    private int getColIndex(String columnName){
        XSSFRow columnNameRow = sheet.getRow(0);
        int colIndex = 0;
        int cellCount = columnNameRow.getLastCellNum();
        for(int i=0; i <cellCount ; i++){
            String colName =  columnNameRow.getCell(i).getStringCellValue();
            if(colName.equalsIgnoreCase(columnName)){
                colIndex =i;
            }
        }

        return colIndex;
    }

}
