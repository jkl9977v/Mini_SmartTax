package SmartTax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import SmartTax.command.TaxDeductionsCommand;
import SmartTax.service.AutoNumService;
import SmartTax.service.taxDeductions.TaxDeductionsDeleteService;
import SmartTax.service.taxDeductions.TaxDeductionsDetailService;
import SmartTax.service.taxDeductions.TaxDeductionsListService;
import SmartTax.service.taxDeductions.TaxDeductionsUpdateService;
import SmartTax.service.taxDeductions.TaxDeductionsWriteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("taxDeductions")
public class TaxDeductionsController {
	@Autowired
	TaxDeductionsWriteService taxDeductionsWriteService;
	@Autowired
	TaxDeductionsListService taxDeductionsListService;
	@Autowired
	TaxDeductionsDetailService taxDeductionsDetailService;
	@Autowired
	TaxDeductionsUpdateService taxDeductionsUpdateService;
	@Autowired
	TaxDeductionsDeleteService taxDeductionsDeleteService;
	@Autowired
	AutoNumService autoNumService;

	@GetMapping("taxDeductionsWrite")
	public String taxDeductionsWrite(TaxDeductionsCommand taxDeductionsCommand, Model model) {
		String autoNum = autoNumService.execute("incTax_", "income_Tax_Report_Num",8,"income_Tax_report");
		taxDeductionsCommand.setDeductionNum(autoNum);
		//String autoNum = autoNumService.execute1("inc", "income_Tax_Report_Num","income_Tax_report");
		//taxDeductionsCommand.setdeductionNum(autoNum);
		model.addAttribute("taxDeductionsCommand", taxDeductionsCommand);
		return "thymeleaf/taxDeductions/taxDeductionsWrite";
	}
	


	@PostMapping("taxDeductionsWrite")
	public String taxDeductionsWrite(HttpSession sesion, TaxDeductionsCommand taxDeductionsCommand) {
		taxDeductionsWriteService.execute(sesion,taxDeductionsCommand);
		return "redirect:taxDeductionsList";
	}
	@GetMapping("taxDeductionsList")
	public String taxDeductionsList(HttpSession sesion, Model model) {
		taxDeductionsListService.execute( model, sesion);
		return "thymeleaf/taxDeductions/taxDeductionsList";
	}

	@GetMapping("taxDeductionsDetail")
	public String taxDeductionsDetail(HttpSession session, String deductionNum, Model model) {
		taxDeductionsDetailService.execute(session, deductionNum, model);
		return "thymeleaf/taxDeductions/taxDeductionsDetail";
	}

	@GetMapping("taxDeductionsUpdate")
	public String taxDeductionsUpdate(HttpSession session,String deductionNum, Model model) {
		taxDeductionsDetailService.execute(session,deductionNum, model);
		return "thymeleaf/taxDeductions/taxDeductionsUpdate";
	}

	@PostMapping("taxDeductionsUpdate")
	public String taxDeductionsUpdate(HttpSession session, TaxDeductionsCommand taxDeductionsCommand) {
		taxDeductionsUpdateService.execute(session, taxDeductionsCommand);
		return "redirect:taxDeductionsDetail?deductionNum=" + taxDeductionsCommand.getDeductionNum();
	}

	@GetMapping("taxDeductionsDelete")
	public String taxDeductionsDelete(HttpSession session, String deductionNum) {
		taxDeductionsDeleteService.execute(session,deductionNum);
		return "redirect:taxDeductionsList";
	}
}
