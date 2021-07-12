package com.skyScanner.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelperTest {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static XSSFCell cell;
    private static String[] datas;
/*
    public void ExcelHelper(String sheetName) {
        workbook.getSheet(sheetName);
    }


    public void setExcelFile(String exelFilePath) throws IOException {
        workbook = new XSSFWorkbook(exelFilePath);
    }

    public void setExcelSheet(String sheetName) {
        workbook.getSheet(sheetName);
    }


    public String getCellData(String tcName, String ColumnName) {

        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        int rowIndex = 0;
        for (int i = 1; i <= rowCount; i++) {
            XSSFRow row = sheet.getRow(i);
            String testCaseName = row.getCell(0).getStringCellValue();
            if (testCaseName.equalsIgnoreCase(tcName)) {
                rowIndex = i;
                break;
            }
        }

        XSSFRow columnRow = sheet.getRow(0);
        int colIndex = 0;
        int cellCount = columnRow.getLastCellNum();
        for (int i = 0; i < cellCount; i++) {
            String colName = columnRow.getCell(i).getStringCellValue();
            if (colName.equalsIgnoreCase(colName)) {
                colIndex = i;
            }
        }
        String data = sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();

        return data;

    }*/
}