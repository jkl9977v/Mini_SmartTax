package SmartTax.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.command.UserCommand;
import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.UserDTO;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class UserUpdateService {
	@Autowired
	UserMapper userMapper;
	
	public void execute(HttpSession session, UserCommand userCommand) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		UserDTO dto = new UserDTO();
		dto.setUserNum(userNum);
		dto.setUserId(userCommand.getUserId());
		dto.setUserPw(userCommand.getUserPw());
		dto.setUserPwCon(userCommand.getUserPwCon());
		dto.setUserName(userCommand.getUserName());
		dto.setUserPhone(userCommand.getUserPhone());
		dto.setUserEmail(userCommand.getUserEmail());
		dto.setUserAddr(userCommand.getUserAddr());
		dto.setUserAddrDetail(userCommand.getUserAddrDetail());
		dto.setUserPost(userCommand.getUserPost());
		dto.setUserProfileImage(userCommand.getUserProfileImage());
		dto.setUserJoinDate(userCommand.getUserJoinDate());
		userMapper.userUpdate(dto);
		
	}

}
