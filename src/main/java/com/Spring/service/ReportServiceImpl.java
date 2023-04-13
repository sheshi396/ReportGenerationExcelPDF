package com.Spring.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.Spring.entity.CitizenPlan;
import com.Spring.repo.CitizenPlanRepository;
import com.Spring.request.SearchRequest;
import com.Spring.util.EmailUtils;
import com.Spring.util.ExcelGenerator;
import com.Spring.util.PdfGenerator;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private CitizenPlanRepository repo;
	@Autowired
	private ExcelGenerator excelGenerator;
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailUtils emailUtils;

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
		
		List<CitizenPlan> plans = repo.findAll();
		File f= new File("plans.xlsx");
		excelGenerator.generate(response, plans,f);
		String subject ="Test mail";
		String body ="<h1>Email Sent</h1>";
		String to = "rajinikanthr396@gmail.com";
		
		
		emailUtils.sendEmail(to, subject, body,f);
		f.delete();

		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		List<CitizenPlan> plans = repo.findAll();
		File f= new File("planData.pdf");
		pdfGenerator.generate(response, plans,f);
		String subject ="Test mail";
		String body ="<h1>Email Sent</h1>";
		String to = "rajinikanthr396@gmail.com";
		emailUtils.sendEmail(to, subject, body,f);
		f.delete();

		
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
