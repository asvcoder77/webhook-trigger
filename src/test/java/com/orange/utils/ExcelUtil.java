package com.orange.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static Object[][] getTestData(String path,String sheetname) throws IOException{
		InputStream input = ExcelUtil.class.getClassLoader().getResourceAsStream(path);
		if (input == null) {
			throw new FileNotFoundException(path + " not found in test resources");
		}

		try (XSSFWorkbook wb = new XSSFWorkbook(input)) {
			XSSFSheet sheet = wb.getSheet(sheetname);

			int rows = sheet.getPhysicalNumberOfRows();
			int cols = sheet.getRow(0).getPhysicalNumberOfCells();

			Object[][] data = new Object[rows - 1][cols];

			for (int i = 1; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
				}
			}
			return data;
		}
	}
}
