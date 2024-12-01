package SmartTax.service.reports;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.command.ReportsCommand;
import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.ReportsDTO;
import SmartTax.mapper.ReportsMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class ReportsWriteService {
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
		dto.setPeriodStart(reportsCommand.getPeriodStart() ); //nnnn-01-01
		
		dto.setPeriodEnd(reportsCommand.getPeriodEnd() ); //endDate는 startDate의 +364일로 한다.
		dto.setTotalIncome(reportsCommand.getTotalIncome() );
		dto.setTotalExpenses(reportsCommand.getTotalExpenses() );
		dto.setNetProfit(reportsCommand.getNetProfit() );
	
		reportsMapper.reportInsert(dto);
		
	}

}
