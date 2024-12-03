package SmartTax.service.taxDeductions;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.command.TaxDeductionsCommand;
import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.TaxDeductionsDTO;
import SmartTax.mapper.TaxDeductionsMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class TaxDeductionsUpdateService {
	@Autowired
	TaxDeductionsMapper taxDeductionsMapper;
	@Autowired
	UserMapper userMapper;
	
	public void execute(HttpSession session, TaxDeductionsCommand taxDeductionsCommand) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		TaxDeductionsDTO dto = new TaxDeductionsDTO();
		dto.setDeductionNum(taxDeductionsCommand.getDeductionNum() );
		dto.setUserNum(userNum );
		dto.setDeductionType(taxDeductionsCommand.getDeductionType() );
		dto.setDeductionAmount(taxDeductionsCommand.getDeductionAmount() );
		dto.setDeductionDate(taxDeductionsCommand.getDeductionDate() );
	
	
		taxDeductionsMapper.taxDeductionsUpdate(dto);
		
	}
}
