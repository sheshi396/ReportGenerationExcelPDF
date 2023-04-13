package com.Spring.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Spring.request.SearchRequest;
import com.Spring.service.ReportService;

@Controller
public class ReportController {

	@Autowired
	private ReportService service;
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response)throws Exception {
		
		response.setContentType("application/octet-stream");
		response.addHeader("content-Disposition", "attachment;filename=plans.xlsx");
		service.exportExcel(response);
	}
	 @GetMapping("/pdf")
	    public void downloadPdf(HttpServletResponse response) throws Exception{

			response.setContentType("application/pdf");
			response.addHeader("content-Disposition", "attachment;filename=planData.pdf");
			service.exportPdf(response);
	    }

	@PostMapping("/search")
	public String handleSearch(SearchRequest search, Model model) {
//		System.out.println(request);
		model.addAttribute("plans", service.search(search));
		model.addAttribute("search",search);
		init(model);
		return "index";

	}

	@GetMapping(value = "/index")
	public String search(Model model) {
		model.addAttribute("search", new SearchRequest());
		init(model);

		return "index";
	}

	private void init(Model model) {
//		model.addAttribute("search", new SearchRequest());
		model.addAttribute("planNames", service.getPlanNames());

		model.addAttribute("planStatus", service.getPlanStatus());
	}

}
