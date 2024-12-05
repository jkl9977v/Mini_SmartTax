package SmartTax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SmartTax.command.ReportsCommand;
import SmartTax.service.AutoNumService;
import SmartTax.service.reports.ReportsDeleteService;
import SmartTax.service.reports.ReportsDetailService;
import SmartTax.service.reports.ReportsListService;
import SmartTax.service.reports.ReportsUpdateService;
import SmartTax.service.reports.ReportsWriteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("reports")
public class ReportsController {
	@Autowired
	ReportsWriteService reportsWriteService;
	@Autowired
	ReportsListService reportsListService;
	@Autowired
	ReportsDetailService reportsDetailService;
	@Autowired
	ReportsUpdateService reportsUpdateService;
	@Autowired
	ReportsDeleteService reportsDeleteService;
	@Autowired
	AutoNumService autoNumService;

	@GetMapping("reportsWrite")
	public String reportsWrite(ReportsCommand reportsCommand, Model model) {
		String autoNum = autoNumService.execute("report_", "report_num", 8, "financial_reports");
		reportsCommand.setReportNum(autoNum);
		model.addAttribute("reportsCommand", reportsCommand);
		return "thymeleaf/reports/reportsWrite";
	}
	


	@PostMapping("reportsWrite")
	public String reportsWrite(HttpSession sesion, ReportsCommand reportsCommand) {
		reportsWriteService.execute(sesion,reportsCommand);
		return "redirect:reportsList";
	}
	@GetMapping("reportsList")
	public String reportsList(HttpSession sesion, Model model
			, @RequestParam(value="page" , required = false , defaultValue = "1") Integer page
			,@RequestParam(value="searchWord", required = false ) String searchWord) {
		reportsListService.execute( searchWord,page, model, sesion);
		return "thymeleaf/reports/reportsList";
	}

	@GetMapping("reportsDetail")
	public String reportsDetail(HttpSession session, String reportNum, Model model) {
		reportsDetailService.execute(session, reportNum, model);
		return "thymeleaf/reports/reportsDetail";
	}

	@GetMapping("reportsUpdate")
	public String reportsUpdate(HttpSession session,String reportNum, Model model) {
		reportsDetailService.execute(session,reportNum, model);
		return "thymeleaf/reports/reportsUpdate";
	}

	@PostMapping("reportsUpdate")
	public String reportsUpdate(HttpSession session, ReportsCommand reportsCommand) {
		reportsUpdateService.execute(session, reportsCommand);
		return "redirect:reportsDetail?reportNum=" + reportsCommand.getReportNum();
	}

	@GetMapping("reportsDelete")
	public String reportsDelete(HttpSession session, String reportNum) {
		reportsDeleteService.execute(session,reportNum);
		return "redirect:reportsList";
	}
}
