package SmartTax.service.expenses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.ExpensesDTO;
import SmartTax.mapper.ExpensesMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class ExpensesListService {
	@Autowired
	ExpensesMapper expensesMapper;
	@Autowired
	UserMapper userMapper;
	

	public void execute(Model model, HttpSession session) {
		
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		List<ExpensesDTO> list=expensesMapper.expenseSelectAll(userNum);
		model.addAttribute("list", list);
		
	}

}
