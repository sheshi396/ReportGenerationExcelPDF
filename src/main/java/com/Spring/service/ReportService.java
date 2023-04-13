package com.Spring.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.Spring.entity.CitizenPlan;
import com.Spring.request.SearchRequest;

public interface ReportService {

	public List<String> getPlanNames();

	public List<String> getPlanStatus();

	public List<CitizenPlan> search(SearchRequest request);

	public boolean exportExcel(HttpServletResponse response) throws Exception;

	public boolean exportPdf(HttpServletResponse response) throws Exception;

}
