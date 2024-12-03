package SmartTax.service.taxDeductions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.mapper.TaxDeductionsMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class TaxDeductionsDeleteService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	TaxDeductionsMapper taxDeductionsMapper;

	public void execute(HttpSession session, String taxDeductionsReportNum) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		taxDeductionsMapper.taxDeductionsDelete(userNum, taxDeductionsReportNum);
		
	}

}
