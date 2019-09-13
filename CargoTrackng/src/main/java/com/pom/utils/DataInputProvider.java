package com.pom.utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataInputProvider {

	public static String[][] getAllSheetData(String sheetName) {

		String[][] data = null;

		try {
			FileInputStream fis = new FileInputStream(sheetName);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("TestData");

			int rowCount = sheet.getLastRowNum();
			int columnCount = sheet.getRow(0).getLastCellNum();

			data = new String[rowCount][columnCount];

			for (int i = 1; i < rowCount + 1; i++) {
				try {
					XSSFRow row = sheet.getRow(i);
					for (int j = 0; j < columnCount; j++) {
						try {
							String cellValue = "";
							try {
								 if(row.getCell(j).getCellType() == CellType.STRING) {
								cellValue = row.getCell(j).getStringCellValue();
								 }else if(row.getCell(j).getCellType()==CellType.NUMERIC) {
								 cellValue =""+ (int) row.getCell(j).getNumericCellValue();
								 }
							} catch (Exception e) {
								e.printStackTrace();
							}
							data[i - 1][j] = cellValue;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			workbook.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return data;

	}

}
