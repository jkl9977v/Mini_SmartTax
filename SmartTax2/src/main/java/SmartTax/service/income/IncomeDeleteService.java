package SmartTax.service.income;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.mapper.IncomeMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class IncomeDeleteService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	IncomeMapper incomeMapper;

	public void execute(HttpSession session, String incomeNum) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		incomeMapper.incomeDelete(userNum, incomeNum);
		
	}

}
