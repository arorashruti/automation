package com.assessment.commonUtils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;

public class ReadTestDataFromExcel {

    public static String fetchDataFromExcel(String sheetName, int rowIndex, int cellIndex) {
        String data = null;
        try {
            Logs.info("##### fetching data from excel sheet ######");
            File file = new File("./test-data/data.xlsx");
            FileInputStream fis = new FileInputStream(file);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheet(sheetName);
            Row row = sheet.getRow(rowIndex);
            Cell cell = row.getCell(cellIndex);
            data = cell.toString();
            return data;
        } catch (Exception e) {
            Logs.error("Data not found, please check file path, sheet name, row index, cell index");
        }
        Logs.info("###### found data is : " + data);
        return data;
    }
}
