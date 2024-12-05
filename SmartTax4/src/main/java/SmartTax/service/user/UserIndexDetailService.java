package SmartTax.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.UserDTO;
import SmartTax.mapper.UserMapper;

@Service
public class UserIndexDetailService {
	@Autowired
	UserMapper userMapper;

	public void execute(AuthInfoDTO auth, Model model) {
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		UserDTO dto=userMapper.userSelectOne(userNum);
		
		model.addAttribute("dto", dto);
		
	}

}
