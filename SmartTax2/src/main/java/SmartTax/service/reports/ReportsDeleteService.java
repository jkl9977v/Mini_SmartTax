package SmartTax.service.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.mapper.ReportsMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class ReportsDeleteService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	ReportsMapper reportsMapper;

	public void execute(HttpSession session, String reportNum) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		reportsMapper.reportDelete(userNum, reportNum);
		
	}

}
