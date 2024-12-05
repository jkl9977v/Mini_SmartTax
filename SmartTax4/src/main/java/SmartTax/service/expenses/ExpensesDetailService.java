package SmartTax.service.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.ExpensesDTO;
import SmartTax.mapper.ExpensesMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class ExpensesDetailService {
	@Autowired
	ExpensesMapper expensesMapper;
	@Autowired
	UserMapper userMapper;

	public void execute(HttpSession session, String expenseNum, Model model) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		//UserDTO dto=userMapper.userSelectOne(userNum);
		
		ExpensesDTO dto=expensesMapper.expenseSelectOne(expenseNum, userNum);
		
		System.out.println(dto);
		
		
		model.addAttribute("dto", dto);
		
	}

}
