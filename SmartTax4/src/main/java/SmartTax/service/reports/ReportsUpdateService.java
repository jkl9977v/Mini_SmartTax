package SmartTax.service.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.command.ExpensesCommand;
import SmartTax.command.ReportsCommand;
import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.ExpensesDTO;
import SmartTax.domain.ReportsDTO;
import SmartTax.mapper.ExpensesMapper;
import SmartTax.mapper.ReportsMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class ReportsUpdateService {
	@Autowired
	ReportsMapper reportsMapper;
	@Autowired
	UserMapper userMapper;
	
	public void execute(HttpSession session, ReportsCommand reportsCommand) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		ReportsDTO dto = new ReportsDTO();
		dto.setReportNum(reportsCommand.getReportNum() );
		dto.setUserNum(userNum );
		dto.setPeriodStart(reportsCommand.getPeriodStart() );
		
		//dto.setPeriodEnd(reportsCommand.getPeriodEnd() );
		dto.setTotalIncome(reportsCommand.getTotalIncome() );
		dto.setTotalExpenses(reportsCommand.getTotalExpenses() );
		dto.setNetProfit(reportsCommand.getNetProfit() );
	
		reportsMapper.reportUpdate(dto);
		
	}


}
