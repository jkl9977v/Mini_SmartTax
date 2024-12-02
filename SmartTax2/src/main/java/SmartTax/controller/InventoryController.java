package SmartTax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import SmartTax.command.InventoryCommand;
import SmartTax.service.AutoNumService;
import SmartTax.service.inventory.InventoryDeleteService;
import SmartTax.service.inventory.InventoryDetailService;
import SmartTax.service.inventory.InventoryListService;
import SmartTax.service.inventory.InventoryUpdateService;
import SmartTax.service.inventory.InventoryWriteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("inventory")
public class InventoryController {
	@Autowired
	InventoryWriteService inventoryWriteService;
	@Autowired
	InventoryListService inventoryListService;
	@Autowired
	InventoryDetailService inventoryDetailService;
	@Autowired
	InventoryUpdateService inventoryUpdateService;
	@Autowired
	InventoryDeleteService inventoryDeleteService;
	@Autowired
	AutoNumService autoNumService;

	@GetMapping("inventoryWrite")
	public String inventoryWrite(InventoryCommand inventoryCommand, Model model) {
		String autoNum = autoNumService.execute("prod_", "inventory_num", 6, "inventory");
		inventoryCommand.setInventoryNum(autoNum);
		model.addAttribute("inventoryCommand", inventoryCommand);
		return "thymeleaf/inventory/inventoryWrite";
	}
	


	@PostMapping("inventoryWrite")
	public String inventoryWrite(HttpSession sesion, InventoryCommand inventoryCommand) {
		inventoryWriteService.execute(sesion,inventoryCommand);
		return "redirect:inventoryList";
	}
	@GetMapping("inventoryList")
	public String inventoryList(HttpSession sesion, Model model) {
		inventoryListService.execute( model, sesion);
		return "thymeleaf/inventory/inventoryList";
	}

	@GetMapping("inventoryDetail")
	public String inventoryDetail(HttpSession session, String inventoryNum, Model model) {
		inventoryDetailService.execute(session, inventoryNum, model);
		return "thymeleaf/inventory/inventoryDetail";
	}

	@GetMapping("inventoryUpdate")
	public String inventoryUpdate(HttpSession session,String inventoryNum, Model model) {
		inventoryDetailService.execute(session,inventoryNum, model);
		return "thymeleaf/inventory/inventoryUpdate";
	}

	@PostMapping("inventoryUpdate")
	public String inventoryUpdate(HttpSession session, InventoryCommand inventoryCommand) {
		inventoryUpdateService.execute(session, inventoryCommand);
		return "redirect:inventoryDetail?inventoryNum=" + inventoryCommand.getInventoryNum();
	}

	@GetMapping("inventoryDelete")
	public String inventoryDelete(HttpSession session, String inventoryNum) {
		inventoryDeleteService.execute(session,inventoryNum);
		return "redirect:inventoryList";
	}
}
