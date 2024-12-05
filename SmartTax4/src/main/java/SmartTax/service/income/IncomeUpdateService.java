package SmartTax.service.income;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.command.IncomeCommand;
import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.IncomeDTO;
import SmartTax.mapper.IncomeMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class IncomeUpdateService {
	@Autowired
	IncomeMapper incomeMapper;
	@Autowired
	UserMapper userMapper;
	
	public void execute(HttpSession session, IncomeCommand incomeCommand) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		IncomeDTO dto = new IncomeDTO();
		dto.setIncomeNum(incomeCommand.getIncomeNum() );
		dto.setUserNum(userNum );
		dto.setIncomeAmount(incomeCommand.getIncomeAmount() );
		dto.setIncomeDate(incomeCommand.getIncomeDate() );
		dto.setIncomeCategory(incomeCommand.getIncomeCategory() );
		dto.setIncomeDescription(incomeCommand.getIncomeDescription() );
		dto.setIncomeVatAmount(incomeCommand.getIncomeAmount() );
	
		incomeMapper.incomeUpdate(dto);
		
	}
}
