package SmartTax.service.tax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.mapper.TaxMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class TaxDeleteService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	TaxMapper taxMapper;

	public void execute(HttpSession session, String taxNum) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		taxMapper.taxDelete(userNum, taxNum);
		
	}

}
