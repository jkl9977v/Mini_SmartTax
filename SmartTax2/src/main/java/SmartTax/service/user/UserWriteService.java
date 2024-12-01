package SmartTax.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.command.UserCommand;
import SmartTax.domain.UserDTO;
import SmartTax.mapper.UserMapper;

@Service
public class UserWriteService {
	@Autowired
	UserMapper userMapper;

	public void execute(UserCommand userCommand) {
		UserDTO dto = new UserDTO();
		dto.setUserNum(userCommand.getUserNum());
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
		userMapper.userInsert(dto);
	}

}
