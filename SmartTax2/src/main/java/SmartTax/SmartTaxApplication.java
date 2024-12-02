package SmartTax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.service.user.UserIndexDetailService;
import jakarta.servlet.http.HttpSession;


@SpringBootApplication
@Controller
public class SmartTaxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartTaxApplication.class, args);
	}
	
	@Autowired
	UserIndexDetailService userIndexDetailService;
	
	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		if(auth!=null) {
			userIndexDetailService.execute(auth, model);
			return "thymeleaf/index";
		}
		return "thymeleaf/index";
	}
	@GetMapping("prodInven")
	public String prodInven(HttpSession session, Model model) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		if(auth!=null) {
			userIndexDetailService.execute(auth, model);
			return "thymeleaf/prodInven";
		}
		return "thymeleaf/index";
	}
	

}
