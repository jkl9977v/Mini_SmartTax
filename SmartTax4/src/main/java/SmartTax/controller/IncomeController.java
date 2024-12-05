package SmartTax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SmartTax.command.IncomeCommand;
import SmartTax.service.AutoNumService;
import SmartTax.service.income.IncomeDeleteService;
import SmartTax.service.income.IncomeDetailService;
import SmartTax.service.income.IncomeListService;
import SmartTax.service.income.IncomeUpdateService;
import SmartTax.service.income.IncomeWriteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("income")
public class IncomeController {
	@Autowired
	IncomeWriteService incomeWriteService;
	@Autowired
	IncomeListService incomeListService;
	@Autowired
	IncomeDetailService incomeDetailService;
	@Autowired
	IncomeUpdateService incomeUpdateService;
	@Autowired
	IncomeDeleteService incomeDeleteService;
	@Autowired
	AutoNumService autoNumService;

	@GetMapping("incomeWrite")
	public String incomeWrite(IncomeCommand incomeCommand, Model model) {
		String autoNum = autoNumService.execute("income_", "income_num", 8, "income");
		incomeCommand.setIncomeNum(autoNum);
		model.addAttribute("incomeCommand", incomeCommand);
		return "thymeleaf/income/incomeWrite";
	}
	


	@PostMapping("incomeWrite")
	public String incomeWrite(HttpSession sesion, IncomeCommand incomeCommand) {
		incomeWriteService.execute(sesion,incomeCommand);
		return "redirect:incomeList";
	}
	@GetMapping("incomeList")
	public String incomeList(HttpSession sesion, Model model
			, @RequestParam(value="page" , required = false , defaultValue = "1") Integer page
			,@RequestParam(value="searchWord", required = false ) String searchWord) {
		incomeListService.execute( searchWord,page, model, sesion);
		return "thymeleaf/income/incomeList";
	}

	@GetMapping("incomeDetail")
	public String incomeDetail(HttpSession session, String incomeNum, Model model) {
		incomeDetailService.execute(session, incomeNum, model);
		return "thymeleaf/income/incomeDetail";
	}

	@GetMapping("incomeUpdate")
	public String incomeUpdate(HttpSession session,String incomeNum, Model model) {
		incomeDetailService.execute(session,incomeNum, model);
		return "thymeleaf/income/incomeUpdate";
	}

	@PostMapping("incomeUpdate")
	public String incomeUpdate(HttpSession session, IncomeCommand incomeCommand) {
		incomeUpdateService.execute(session, incomeCommand);
		return "redirect:incomeDetail?incomeNum=" + incomeCommand.getIncomeNum();
	}

	@GetMapping("incomeDelete")
	public String incomeDelete(HttpSession session, String incomeNum) {
		incomeDeleteService.execute(session,incomeNum);
		return "redirect:incomeList";
	}
}
