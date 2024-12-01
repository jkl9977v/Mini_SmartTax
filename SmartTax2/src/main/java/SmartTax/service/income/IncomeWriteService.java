package SmartTax.service.income;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.command.IncomeCommand;
import SmartTax.command.UserCommand;
import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.IncomeDTO;
import SmartTax.domain.UserDTO;
import SmartTax.mapper.IncomeMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class IncomeWriteService {
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
	
		incomeMapper.incomeInsert(dto);
		
	}

}
