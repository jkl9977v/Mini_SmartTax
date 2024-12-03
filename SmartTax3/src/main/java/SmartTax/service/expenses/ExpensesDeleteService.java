package SmartTax.service.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.mapper.ExpensesMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class ExpensesDeleteService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	ExpensesMapper expensesMapper;

	public void execute(HttpSession session, String expenseNum) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		expensesMapper.expenseDelete(userNum, expenseNum);
		
	}

}
