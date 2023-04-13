package com.Spring.service;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.Spring.entity.CitizenPlan;
import com.Spring.repo.CitizenPlanRepository;
import com.Spring.request.SearchRequest;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public List<String> getPlanNames() {

		return repo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {

		return repo.getPlanStatus();
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		
		 // Create a new Workbook
	    Workbook workbook = new XSSFWorkbook();

	    // Create a new Sheet
	    Sheet sheet = workbook.createSheet("Sheet-data");

	    // Create a new Row
	    Row headerRow =  sheet.createRow(0);
	    headerRow.createCell(0).setCellValue("Citizen Name");
	    headerRow.createCell(1).setCellValue("Plan Name");
	    headerRow.createCell(2).setCellValue("Plan Status");
	    headerRow.createCell(3).setCellValue("Start Date");
	    headerRow.createCell(4).setCellValue("End Date");
	    
	    List<CitizenPlan> records = repo.findAll();
	    
	    
	    int rowNum = 1;
	    for (CitizenPlan plan : records) {
	        Row row = sheet.createRow(rowNum++);
	        row.createCell(0).setCellValue(plan.getCitizenName());
	        row.createCell(1).setCellValue(plan.getPlanName());
	        row.createCell(2).setCellValue(plan.getPlanStatus());
	        row.createCell(3).setCellValue(plan.getPlanStartDate()+"");
	        row.createCell(4).setCellValue(plan.getPlanEndDate()+"");
	    
        
//	    FileOutputStream fos = new FileOutputStream("plan-data.xlsx");
//	    workbook.write(fos);
//	    fos.close();
//	    workbook.close();
	        
	    } 
	        ServletOutputStream outputStream = response.getOutputStream();
	        workbook.write(outputStream);
	        outputStream.close();
	        workbook.close();
	    

		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		 Document document = new Document();
	        PdfWriter.getInstance(document, response.getOutputStream());

	        document.open();

	        // Add table name
	        Paragraph tableName = new Paragraph("Citizen Plan Info");
	        tableName.setAlignment(Paragraph.ALIGN_CENTER);
	        document.add(tableName);

	        // Add table with 6 columns
	        PdfPTable table = new PdfPTable(6);
	        table.setWidthPercentage(100f);
	        table.setSpacingBefore(5);

	        table.addCell("citizenName");
	        table.addCell("Gender");
	        table.addCell("planname");
	        table.addCell("plan status");
	        table.addCell("start date");
	        table.addCell("end date");
	        List<CitizenPlan> plans = repo.findAll();
	        for (CitizenPlan plan :plans)
	        {
	        table.addCell(plan.getCitizenName());
	        table.addCell(plan.getGender());
	        table.addCell(plan.getPlanName());
	        table.addCell(plan.getPlanStatus());
	        table.addCell(plan.getPlanStartDate()+"");
	        table.addCell(plan.getPlanEndDate()+"");
	        }
	        document.add(table);

	        document.setPageSize(PageSize.A4);
	        document.close();
		return true;
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan entity = new CitizenPlan();
		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate = request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(startDate, formatter);
			entity.setPlanStartDate(localDate);
		}

		if (null != request.getEndDate() && !"".equals(request.getEndDate())) {
			String endDate = request.getEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(endDate, formatter);
			entity.setPlanEndDate(localDate);
		}
		return repo.findAll(Example.of(entity));

	}

}
