package SmartTax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.command.FindCommand;
import SmartTax.domain.AuthInfoDTO;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class FindService {
	@Autowired
	UserMapper userMapper;

	public String findUserId(FindCommand findCommand) {
		String userId=userMapper.findUserId(findCommand.getUserPhone(), findCommand.getUserEmail());
		if(userId!=null) {
			return userId;
		}
		return null;
		
	}

	public String findUserPw(HttpSession session, FindCommand findCommand) {
		AuthInfoDTO auth=userMapper.findUserPw(findCommand.getUserId(), findCommand.getUserEmail());
		
		
		if(auth!=null) {
			String userPw=auth.getUserPw();
			return userPw;
		}
		return null;
		
	}

}
