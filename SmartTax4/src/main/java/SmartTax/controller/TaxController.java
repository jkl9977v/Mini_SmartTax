package SmartTax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SmartTax.command.TaxCommand;
import SmartTax.service.AutoNumService;
import SmartTax.service.tax.TaxDeleteService;
import SmartTax.service.tax.TaxDetailService;
import SmartTax.service.tax.TaxListService;
import SmartTax.service.tax.TaxUpdateService;
import SmartTax.service.tax.TaxWriteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("tax")
public class TaxController {
	@Autowired
	TaxWriteService taxWriteService;
	@Autowired
	TaxListService taxListService;
	@Autowired
	TaxDetailService taxDetailService;
	@Autowired
	TaxUpdateService taxUpdateService;
	@Autowired
	TaxDeleteService taxDeleteService;
	@Autowired
	AutoNumService autoNumService;

	@GetMapping("taxWrite")
	public String taxWrite(TaxCommand taxCommand, Model model) {
		String autoNum = autoNumService.execute("tax_", "tax_Num",5,"taxes");
		taxCommand.setTaxNum(autoNum);
		//String autoNum = autoNumService.execute1("tax", "tax_Num","taxes");
		//taxCommand.setTaxNum(autoNum);
		model.addAttribute("taxCommand", taxCommand);
		return "thymeleaf/tax/taxWrite";
	}
	


	@PostMapping("taxWrite")
	public String taxWrite(HttpSession sesion, TaxCommand taxCommand) {
		taxWriteService.execute(sesion,taxCommand);
		return "redirect:taxList";
	}
	@GetMapping("taxList")
	public String taxList(HttpSession sesion, Model model
			, @RequestParam(value="page" , required = false , defaultValue = "1") Integer page
			,@RequestParam(value="searchWord", required = false ) String searchWord) {
		taxListService.execute(searchWord,page, model, sesion);
		return "thymeleaf/tax/taxList";
	}

	@GetMapping("taxDetail")
	public String taxDetail(HttpSession session, String taxNum, Model model) {
		taxDetailService.execute(session, taxNum, model);
		return "thymeleaf/tax/taxDetail";
	}

	@GetMapping("taxUpdate")
	public String taxUpdate(HttpSession session,String taxNum, Model model) {
		taxDetailService.execute(session,taxNum, model);
		return "thymeleaf/tax/taxUpdate";
	}

	@PostMapping("taxUpdate")
	public String taxUpdate(HttpSession session, TaxCommand taxCommand) {
		taxUpdateService.execute(session, taxCommand);
		return "redirect:taxDetail?taxNum=" + taxCommand.getTaxNum();
	}

	@GetMapping("taxDelete")
	public String taxDelete(HttpSession session, String taxNum) {
		taxDeleteService.execute(session,taxNum);
		return "redirect:taxList";
	}
}
