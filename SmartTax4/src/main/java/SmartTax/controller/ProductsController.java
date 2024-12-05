package SmartTax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SmartTax.command.ProductsCommand;
import SmartTax.service.AutoNumService;
import SmartTax.service.products.ProductsDeleteService;
import SmartTax.service.products.ProductsDetailService;
import SmartTax.service.products.ProductsListService;
import SmartTax.service.products.ProductsUpdateService;
import SmartTax.service.products.ProductsWriteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("products")
public class ProductsController {
	@Autowired
	ProductsWriteService productsWriteService;
	@Autowired
	ProductsListService productsListService;
	@Autowired
	ProductsDetailService productsDetailService;
	@Autowired
	ProductsUpdateService productsUpdateService;
	@Autowired
	ProductsDeleteService productsDeleteService;
	@Autowired
	AutoNumService autoNumService;

	@GetMapping("productsWrite")
	public String productsWrite(ProductsCommand productsCommand, Model model) {
		String autoNum = autoNumService.execute("prod_", "product_num", 6, "products");
		productsCommand.setProductNum(autoNum);
		model.addAttribute("productsCommand", productsCommand);
		return "thymeleaf/products/productsWrite";
	}
	


	@PostMapping("productsWrite")
	public String productsWrite(HttpSession sesion, ProductsCommand productsCommand) {
		productsWriteService.execute(sesion,productsCommand);
		return "redirect:productsList";
	}
	@GetMapping("productsList")
	public String productsList(HttpSession sesion, Model model
			, @RequestParam(value="page" , required = false , defaultValue = "1") Integer page
			,@RequestParam(value="searchWord", required = false ) String searchWord) {
		productsListService.execute(searchWord,page, model, sesion);
		return "thymeleaf/products/productsList";
	}

	@GetMapping("productsDetail")
	public String productsDetail(HttpSession session, String productNum, Model model) {
		productsDetailService.execute(session, productNum, model);
		return "thymeleaf/products/productsDetail";
	}

	@GetMapping("productsUpdate")
	public String productsUpdate(HttpSession session,String productNum, Model model) {
		productsDetailService.execute(session,productNum, model);
		return "thymeleaf/products/productsUpdate";
	}

	@PostMapping("productsUpdate")
	public String productsUpdate(HttpSession session, ProductsCommand productsCommand) {
		productsUpdateService.execute(session, productsCommand);
		return "redirect:productsDetail?productNum=" + productsCommand.getProductNum();
	}

	@GetMapping("productsDelete")
	public String productsDelete(HttpSession session, String productNum) {
		productsDeleteService.execute(session,productNum);
		return "redirect:productsList";
	}
}
