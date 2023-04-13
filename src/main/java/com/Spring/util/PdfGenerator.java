package com.Spring.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.Spring.entity.CitizenPlan;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class PdfGenerator {
	
	public void generate(HttpServletResponse response,List<CitizenPlan> plans,File f) throws Exception{
	
		 Document document = new Document();
	        PdfWriter.getInstance(document, response.getOutputStream());
	        PdfWriter.getInstance(document, new FileOutputStream(f));
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
	}

}
