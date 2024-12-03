package SmartTax.service.invenTrans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.mapper.InvenTransMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class InvenTransDeleteService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	InvenTransMapper invenTransMapper;

	public void execute(HttpSession session, String transactionNum) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		invenTransMapper.invenTransDelete(userNum, transactionNum);
		
	}

}
