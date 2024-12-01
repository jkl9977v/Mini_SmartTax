package SmartTax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import SmartTax.command.UserCommand;
import SmartTax.service.AutoNumService;
import SmartTax.service.EmailCheckService;
import SmartTax.service.IdcheckService;
import SmartTax.service.user.UserDeleteService;
import SmartTax.service.user.UserDetailService;
import SmartTax.service.user.UserListService;
import SmartTax.service.user.UserUpdateService;
import SmartTax.service.user.UserWriteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	UserWriteService userWriteService;
	@Autowired
	UserListService userListService;
	@Autowired
	UserDetailService userDetailService;
	@Autowired
	UserUpdateService userUpdateService;
	@Autowired
	UserDeleteService userDeleteService;
	@Autowired
	AutoNumService autoNumService;

	@GetMapping("userWrite")
	public String UserWrite(UserCommand userCommand, Model model) {
		String autoNum = autoNumService.execute("user_", "user_num", 6, "users");
		userCommand.setUserNum(autoNum);
		model.addAttribute("UserCommand", userCommand);
		return "thymeleaf/user/userWrite";
	}
	
	@Autowired
	IdcheckService idcheckService;
	// spring 방식
	@PostMapping("userIdCheck")
	public @ResponseBody Integer userIdCheck(String userId) {
		// html, jsp파일경로(x)
		return idcheckService.execute(userId);
		
	}
	
	@Autowired
	EmailCheckService emailCheckService;
	
	@PostMapping("userEmailCheck")
	public @ResponseBody Integer userEmailCheck(String userEmail) {
		return emailCheckService.execute(userEmail);
	}

	@PostMapping("userWrite")
	public String UserWrite(UserCommand userCommand) {
		userWriteService.execute(userCommand);
		return "redirect:/";
	}
	@GetMapping("userList")
	public String userList(Model model) {
		userListService.execute(model);
		return "thymeleaf/user/userList";
	}

	@GetMapping("userDetail")
	public String UserDetail(HttpSession session, Model model) {
		userDetailService.execute(session, model);
		return "thymeleaf/user/userDetail";
	}

	@GetMapping("userUpdate")
	public String UserUpdate(HttpSession session, Model model) {
		userDetailService.execute(session, model);
		return "thymeleaf/user/userUpdate";
	}

	@PostMapping("userUpdate")
	public String UserUpdate(HttpSession session, UserCommand userCommand) {
		userUpdateService.execute(session, userCommand);
		return "redirect:userDetail?userNum=" + userCommand.getUserNum();
	}

	@GetMapping("userDelete")
	public String UserDelete(HttpSession session) {
		userDeleteService.execute(session);
		return "redirect:/";
	}
}
