package com.vassarlabs.genericlibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibrary {
	public String readExcelData(String excelPath, String sheetName, int row, int cell) throws Throwable {
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
	    String value= wb.getSheet(sheetName).getRow(row).getCell(cell).toString();
	    return value;
	}
	public void WriteDataIntoExcel(String excelPath, String sheetName, int row, int cell, String data) throws Throwable {
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(sheetName);
		Row r = sh.getRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(excelPath);
		wb.write(fos);
	}
	public String ReadDataFromPropertyFile(String propPath, String key) throws Throwable {
		FileInputStream fis = new FileInputStream(propPath);
		Properties prop = new Properties();
		prop.load(fis);
		
		String value = prop.getProperty(key, "Incorrect Key");
		return value;
	}
}
