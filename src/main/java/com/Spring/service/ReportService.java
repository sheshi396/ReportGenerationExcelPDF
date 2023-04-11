package com.Spring.service;

import java.util.List;

import com.Spring.entity.CitizenPlan;
import com.Spring.request.SearchRequest;

public interface ReportService {

	public List<String> getPlanNames();

	public List<String> getPlanStatus();

	public List<CitizenPlan> search(SearchRequest request);

	public boolean exportExcel();

	public boolean exportPdf();

}
