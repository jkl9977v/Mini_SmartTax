package SmartTax.service.vat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.mapper.UserMapper;
import SmartTax.mapper.VatMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class VatDeleteService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	VatMapper vatMapper;

	public void execute(HttpSession session, String vatReportNum) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		vatMapper.vatDelete(userNum, vatReportNum);
		
	}

}
