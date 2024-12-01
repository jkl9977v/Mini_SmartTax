package SmartTax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import SmartTax.command.ExpensesCommand;
import SmartTax.service.AutoNumService;
import SmartTax.service.expenses.ExpensesDeleteService;
import SmartTax.service.expenses.ExpensesDetailService;
import SmartTax.service.expenses.ExpensesListService;
import SmartTax.service.expenses.ExpensesUpdateService;
import SmartTax.service.expenses.ExpensesWriteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("expenses")
public class ExpensesController {
	@Autowired
	ExpensesWriteService expensesWriteService;
	@Autowired
	ExpensesListService expensesListService;
	@Autowired
	ExpensesDetailService expensesDetailService;
	@Autowired
	ExpensesUpdateService expensesUpdateService;
	@Autowired
	ExpensesDeleteService expensesDeleteService;
	@Autowired
	AutoNumService autoNumService;

	@GetMapping("expensesWrite")
	public String expensesWrite(ExpensesCommand expensesCommand, Model model) {
		String autoNum = autoNumService.execute("expense_", "expense_num", 9, "expenses");
		expensesCommand.setExpenseNum(autoNum);
		model.addAttribute("expensesCommand", expensesCommand);
		return "thymeleaf/expenses/expensesWrite";
	}
	


	@PostMapping("expensesWrite")
	public String expensesWrite(HttpSession sesion, ExpensesCommand expensesCommand) {
		expensesWriteService.execute(sesion,expensesCommand);
		return "redirect:expensesList";
	}
	@GetMapping("expensesList")
	public String expensesList(HttpSession sesion, Model model) {
		expensesListService.execute( model, sesion);
		return "thymeleaf/expenses/expensesList";
	}

	@GetMapping("expensesDetail")
	public String expensesDetail(HttpSession session, String expenseNum, Model model) {
		expensesDetailService.execute(session, expenseNum, model);
		return "thymeleaf/expenses/expensesDetail";
	}

	@GetMapping("expensesUpdate")
	public String expensesUpdate(HttpSession session,String expenseNum, Model model) {
		expensesDetailService.execute(session,expenseNum, model);
		return "thymeleaf/expenses/expensesUpdate";
	}

	@PostMapping("expensesUpdate")
	public String expensesUpdate(HttpSession session, ExpensesCommand expensesCommand) {
		expensesUpdateService.execute(session, expensesCommand);
		return "redirect:expensesDetail?expenseNum=" + expensesCommand.getExpenseNum();
	}

	@GetMapping("expensesDelete")
	public String expensesDelete(HttpSession session, String expenseNum) {
		expensesDeleteService.execute(session,expenseNum);
		return "redirect:expensesList";
	}
}
