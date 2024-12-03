package SmartTax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import SmartTax.command.VatCommand;
import SmartTax.service.AutoNumService;
import SmartTax.service.vat.VatDeleteService;
import SmartTax.service.vat.VatDetailService;
import SmartTax.service.vat.VatListService;
import SmartTax.service.vat.VatUpdateService;
import SmartTax.service.vat.VatWriteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("vat")
public class VatController {
	@Autowired
	VatWriteService vatWriteService;
	@Autowired
	VatListService vatListService;
	@Autowired
	VatDetailService vatDetailService;
	@Autowired
	VatUpdateService vatUpdateService;
	@Autowired
	VatDeleteService vatDeleteService;
	@Autowired
	AutoNumService autoNumService;

	@GetMapping("vatWrite")
	public String vatWrite(VatCommand vatCommand, Model model) {
		String autoNum = autoNumService.execute("vat_", "vat_Report_Num",5,"vat_report");
		vatCommand.setVatReportNum(autoNum);
		//String autoNum = autoNumService.execute1("vat", "vat_Report_Num","vat");
		//vatCommand.setVatReportNum(autoNum);
		model.addAttribute("vatCommand", vatCommand);
		return "thymeleaf/vat/vatWrite";
	}
	


	@PostMapping("vatWrite")
	public String vatWrite(HttpSession sesion, VatCommand vatCommand) {
		vatWriteService.execute(sesion,vatCommand);
		return "redirect:vatList";
	}
	@GetMapping("vatList")
	public String vatList(HttpSession sesion, Model model) {
		vatListService.execute( model, sesion);
		return "thymeleaf/vat/vatList";
	}

	@GetMapping("vatDetail")
	public String vatDetail(HttpSession session, String vatReportNum, Model model) {
		vatDetailService.execute(session, vatReportNum, model);
		return "thymeleaf/vat/vatDetail";
	}

	@GetMapping("vatUpdate")
	public String vatUpdate(HttpSession session,String vatReportNum, Model model) {
		vatDetailService.execute(session,vatReportNum, model);
		return "thymeleaf/vat/vatUpdate";
	}

	@PostMapping("vatUpdate")
	public String vatUpdate(HttpSession session, VatCommand vatCommand) {
		vatUpdateService.execute(session, vatCommand);
		return "redirect:vatDetail?vatNum=" + vatCommand.getVatReportNum();
	}

	@GetMapping("vatDelete")
	public String vatDelete(HttpSession session, String vatReportNum) {
		vatDeleteService.execute(session,vatReportNum);
		return "redirect:vatList";
	}
}
