package SmartTax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import SmartTax.command.LoginCommand;
import SmartTax.service.LoginService;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	LoginService loginService;

	
	@GetMapping("login")
	public String login(//@Validated LoginCommand loginCommand, Model model
			) {
		//model.addAttribute("loginCommand", loginCommand);
		return "thymeleaf/login";
	}
	@PostMapping("login")
	public String login(@Validated LoginCommand loginCommand, HttpSession session,
			BindingResult result) { //@Validated, BindingResult result
		if(result.hasErrors()) { 
			 return "thymeleaf/login"; 
		}
		loginService.execute(loginCommand, session, result);
		return "redirect:/";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}





