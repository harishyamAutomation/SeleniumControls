package com.ui.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private Workbook workbook;
	private Sheet sheet;
	private Row row;
	String filePath = "resources/testData/testData.xlsx";
	
	public ExcelUtils(String sheetName) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fileInputStream);
			sheet = workbook.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getCellData(int rowNumber, int colNumber) {
		Row row = sheet.getRow(rowNumber);
		Cell cell = row.getCell(colNumber);
		
		return cell==null?"":cell.toString();
	}
	
	public int getRowCount() {
		return sheet.getLastRowNum()+1;
	}
	
	public int getColCount() {
		return sheet.getRow(0).getLastCellNum();
	}
	
	public void closeWorkbook() {
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
