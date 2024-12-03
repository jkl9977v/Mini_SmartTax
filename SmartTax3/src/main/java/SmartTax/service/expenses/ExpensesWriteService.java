package SmartTax.service.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.command.ExpensesCommand;
import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.ExpensesDTO;
import SmartTax.mapper.ExpensesMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class ExpensesWriteService {
	@Autowired
	ExpensesMapper expensesMapper;
	@Autowired
	UserMapper userMapper;
	
	public void execute(HttpSession session, ExpensesCommand expensesCommand) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		ExpensesDTO dto = new ExpensesDTO();
		dto.setExpenseNum(expensesCommand.getExpenseNum() );
		dto.setUserNum(userNum );
		dto.setExpenseAmount(expensesCommand.getExpenseAmount() );
		dto.setExpenseDate(expensesCommand.getExpenseDate() );
		dto.setExpenseCategory(expensesCommand.getExpenseCategory() );
		dto.setExpenseDescription(expensesCommand.getExpenseDescription() );
		dto.setExpenseVatAmount(expensesCommand.getExpenseVatAmount() );
	
		expensesMapper.expenseInsert(dto);
		
	}

}
