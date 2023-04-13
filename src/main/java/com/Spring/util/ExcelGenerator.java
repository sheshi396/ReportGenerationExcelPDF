package com.Spring.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.Spring.entity.CitizenPlan;

@Component
public class ExcelGenerator {

	public void generate(HttpServletResponse response, List<CitizenPlan> records,File file) throws Exception {
		// Create a new Workbook
		Workbook workbook = new XSSFWorkbook();

		// Create a new Sheet
		Sheet sheet = workbook.createSheet("Sheet-data");

		// Create a new Row
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Citizen Name");
		headerRow.createCell(1).setCellValue("Plan Name");
		headerRow.createCell(2).setCellValue("Plan Status");
		headerRow.createCell(3).setCellValue("Start Date");
		headerRow.createCell(4).setCellValue("End Date");

		int rowNum = 1;
		for (CitizenPlan plan : records) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(plan.getCitizenName());
			row.createCell(1).setCellValue(plan.getPlanName());
			row.createCell(2).setCellValue(plan.getPlanStatus());
			row.createCell(3).setCellValue(plan.getPlanStartDate() + "");
			row.createCell(4).setCellValue(plan.getPlanEndDate() + "");
		}
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			fos.close();
			

		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		
		workbook.close();
	}

}
