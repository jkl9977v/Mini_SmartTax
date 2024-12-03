package SmartTax.service.incomeTax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.mapper.IncomeTaxMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class IncomeTaxDeleteService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	IncomeTaxMapper incomeTaxMapper;

	public void execute(HttpSession session, String incomeTaxReportNum) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		incomeTaxMapper.incomeTaxDelete(userNum, incomeTaxReportNum);
		
	}

}
