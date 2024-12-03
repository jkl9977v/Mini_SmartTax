package SmartTax.service.invenTrans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.InvenTransDTO;
import SmartTax.mapper.InvenTransMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class InvenTransListService {
	@Autowired
	InvenTransMapper invenTransMapper;
	@Autowired
	UserMapper userMapper;
	

	public void execute(Model model, HttpSession session) {
		
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		List<InvenTransDTO> list=invenTransMapper.invenTransSelectAll(userNum);
		model.addAttribute("list", list);
		
	}

}