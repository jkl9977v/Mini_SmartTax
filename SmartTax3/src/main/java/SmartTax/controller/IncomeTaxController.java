package SmartTax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import SmartTax.command.IncomeTaxCommand;
import SmartTax.service.AutoNumService;
import SmartTax.service.incomeTax.IncomeTaxDeleteService;
import SmartTax.service.incomeTax.IncomeTaxDetailService;
import SmartTax.service.incomeTax.IncomeTaxListService;
import SmartTax.service.incomeTax.IncomeTaxUpdateService;
import SmartTax.service.incomeTax.IncomeTaxWriteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("incomeTax")
public class IncomeTaxController {
	@Autowired
	IncomeTaxWriteService incomeTaxWriteService;
	@Autowired
	IncomeTaxListService incomeTaxListService;
	@Autowired
	IncomeTaxDetailService incomeTaxDetailService;
	@Autowired
	IncomeTaxUpdateService incomeTaxUpdateService;
	@Autowired
	IncomeTaxDeleteService incomeTaxDeleteService;
	@Autowired
	AutoNumService autoNumService;

	@GetMapping("incomeTaxWrite")
	public String incomeTaxWrite(IncomeTaxCommand incomeTaxCommand, Model model) {
		String autoNum = autoNumService.execute("incTax_", "income_Tax_Report_Num",8,"income_Tax_report");
		incomeTaxCommand.setIncomeTaxReportNum(autoNum);
		//String autoNum = autoNumService.execute1("inc", "income_Tax_Report_Num","income_Tax_report");
		//incomeTaxCommand.setincomeTaxReportNum(autoNum);
		model.addAttribute("incomeTaxCommand", incomeTaxCommand);
		return "thymeleaf/incomeTax/incomeTaxWrite";
	}
	


	@PostMapping("incomeTaxWrite")
	public String incomeTaxWrite(HttpSession sesion, IncomeTaxCommand incomeTaxCommand) {
		incomeTaxWriteService.execute(sesion,incomeTaxCommand);
		return "redirect:incomeTaxList";
	}
	@GetMapping("incomeTaxList")
	public String incomeTaxList(HttpSession sesion, Model model) {
		incomeTaxListService.execute( model, sesion);
		return "thymeleaf/incomeTax/incomeTaxList";
	}

	@GetMapping("incomeTaxDetail")
	public String incomeTaxDetail(HttpSession session, String incomeTaxReportNum, Model model) {
		incomeTaxDetailService.execute(session, incomeTaxReportNum, model);
		return "thymeleaf/incomeTax/incomeTaxDetail";
	}

	@GetMapping("incomeTaxUpdate")
	public String incomeTaxUpdate(HttpSession session,String incomeTaxReportNum, Model model) {
		incomeTaxDetailService.execute(session,incomeTaxReportNum, model);
		return "thymeleaf/incomeTax/incomeTaxUpdate";
	}

	@PostMapping("incomeTaxUpdate")
	public String incomeTaxUpdate(HttpSession session, IncomeTaxCommand incomeTaxCommand) {
		incomeTaxUpdateService.execute(session, incomeTaxCommand);
		return "redirect:incomeTaxDetail?incomeTaxReportNum=" + incomeTaxCommand.getIncomeTaxReportNum();
	}

	@GetMapping("incomeTaxDelete")
	public String incomeTaxDelete(HttpSession session, String incomeTaxReportNum) {
		incomeTaxDeleteService.execute(session,incomeTaxReportNum);
		return "redirect:incomeTaxList";
	}
}
