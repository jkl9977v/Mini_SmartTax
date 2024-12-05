package SmartTax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import SmartTax.command.FindCommand;
import SmartTax.service.FindService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("find")
public class findController {
	@Autowired
	FindService findService;
	
	
	@GetMapping("findId")
	public String findId() {
		return "thymeleaf/find/findId";
	}
	@PostMapping("findId")
	public String findId(FindCommand findCommand, Model model) {
		String userId=findService.findUserId(findCommand);
		model.addAttribute("userId", userId);
		return "thymeleaf/find/findIdOk";
	}
	@GetMapping("findPw")
	public String findPw() {
		return "thymeleaf/find/findPw";
	}
	@PostMapping("findPw")
	public String findPw(HttpSession session, FindCommand findCommand, Model model) {
		String userPw=findService.findUserPw(session, findCommand);
		model.addAttribute("userPw", userPw);
		return "thymeleaf/find/findPwOk";
	}
}
