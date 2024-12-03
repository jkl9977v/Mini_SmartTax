package SmartTax.service.incomeTax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.IncomeTaxDTO;
import SmartTax.mapper.IncomeTaxMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class IncomeTaxListService {
	@Autowired
	IncomeTaxMapper incomeTaxMapper;
	@Autowired
	UserMapper userMapper;
	

	public void execute(Model model, HttpSession session) {
		
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		List<IncomeTaxDTO> list=incomeTaxMapper.incomeTaxSelectAll(userNum);
		model.addAttribute("list", list);
		
	}

}
