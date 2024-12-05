package SmartTax.service.incomeTax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.command.IncomeTaxCommand;
import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.IncomeTaxDTO;
import SmartTax.mapper.IncomeTaxMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class IncomeTaxWriteService {
	@Autowired
	IncomeTaxMapper incomeTaxMapper;
	@Autowired
	UserMapper userMapper;
	
	public void execute(HttpSession session, IncomeTaxCommand incomeTaxCommand) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		IncomeTaxDTO dto = new IncomeTaxDTO();
		dto.setIncomeTaxReportNum(incomeTaxCommand.getIncomeTaxReportNum() );
		dto.setUserNum(userNum );
		dto.setIncomeTaxReportDate(incomeTaxCommand.getIncomeTaxReportDate() );
		dto.setTaxableIncome(incomeTaxCommand.getTaxableIncome() );
		dto.setIncomeTaxDue(incomeTaxCommand.getIncomeTaxDue() );
		dto.setIncomeTaxPaymentStatus(incomeTaxCommand.getIncomeTaxPaymentStatus() );
	
		incomeTaxMapper.incomeTaxInsert(dto);
		
	}

}
