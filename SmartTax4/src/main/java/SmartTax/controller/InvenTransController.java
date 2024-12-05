package SmartTax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SmartTax.command.InvenTransCommand;
import SmartTax.service.AutoNumService;
import SmartTax.service.invenTrans.InvenTransDeleteService;
import SmartTax.service.invenTrans.InvenTransDetailService;
import SmartTax.service.invenTrans.InvenTransListService;
import SmartTax.service.invenTrans.InvenTransUpdateService;
import SmartTax.service.invenTrans.InvenTransWriteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("invenTrans")
public class InvenTransController {
	@Autowired
	InvenTransWriteService invenTransWriteService;
	@Autowired
	InvenTransListService invenTransListService;
	@Autowired
	InvenTransDetailService invenTransDetailService;
	@Autowired
	InvenTransUpdateService invenTransUpdateService;
	@Autowired
	InvenTransDeleteService invenTransDeleteService;
	@Autowired
	AutoNumService autoNumService;

	@GetMapping("invenTransWrite")
	public String invenTransWrite(InvenTransCommand invenTransCommand, Model model) {
		String autoNum = autoNumService.execute("invenT_", "transaction_Num", 8, "inventory_transactions");
		invenTransCommand.setTransactionNum(autoNum);
		model.addAttribute("invenTransCommand", invenTransCommand);
		return "thymeleaf/invenTrans/invenTransWrite";
	}
	


	@PostMapping("invenTransWrite")
	public String invenTransWrite(HttpSession sesion, InvenTransCommand invenTransCommand) {
		invenTransWriteService.execute(sesion,invenTransCommand);
		return "redirect:invenTransList";
	}
	@GetMapping("invenTransList")
	public String invenTransList(HttpSession sesion, Model model
			, @RequestParam(value="page" , required = false , defaultValue = "1") Integer page
			,@RequestParam(value="searchWord", required = false ) String searchWord) {
		invenTransListService.execute( searchWord,page, model, sesion);
		return "thymeleaf/invenTrans/invenTransList";
	}

	@GetMapping("invenTransDetail")
	public String invenTransDetail(HttpSession session, String transactionNum, Model model) {
		invenTransDetailService.execute(session, transactionNum, model);
		return "thymeleaf/invenTrans/invenTransDetail";
	}

	@GetMapping("invenTransUpdate")
	public String invenTransUpdate(HttpSession session,String transactionNum, Model model) {
		invenTransDetailService.execute(session,transactionNum, model);
		return "thymeleaf/invenTrans/invenTransUpdate";
	}

	@PostMapping("invenTransUpdate")
	public String invenTransUpdate(HttpSession session, InvenTransCommand invenTransCommand) {
		invenTransUpdateService.execute(session, invenTransCommand);
		return "redirect:invenTransDetail?transactionNum=" + invenTransCommand.getTransactionNum();
	}

	@GetMapping("invenTransDelete")
	public String invenTransDelete(HttpSession session, String transactionNum) {
		invenTransDeleteService.execute(session,transactionNum);
		return "redirect:invenTransList";
	}
}
