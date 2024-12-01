package SmartTax.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import SmartTax.domain.UserDTO;
import SmartTax.mapper.UserMapper;

@Service
public class UserListService {
	@Autowired
	UserMapper userMapper;

	public void execute(Model model) {
		List<UserDTO> list=userMapper.userSelectAll();
		model.addAttribute("list", list);
		
	}

}
