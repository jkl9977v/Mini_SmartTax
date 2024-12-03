package SmartTax.service.invenTrans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.InvenTransDTO;
import SmartTax.mapper.InvenTransMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class InvenTransDetailService {
	@Autowired
	InvenTransMapper invenTransMapper;
	@Autowired
	UserMapper userMapper;

	public void execute(HttpSession session, String transactionNum, Model model) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		//UserDTO dto=userMapper.userSelectOne(userNum);
		
		InvenTransDTO dto=invenTransMapper.invenTransSelectOne(transactionNum, userNum);
		
		System.out.println(dto);
		
		
		model.addAttribute("dto", dto);
		
	}

}
