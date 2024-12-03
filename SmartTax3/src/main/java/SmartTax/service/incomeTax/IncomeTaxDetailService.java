package SmartTax.service.incomeTax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.IncomeTaxDTO;
import SmartTax.mapper.IncomeTaxMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class IncomeTaxDetailService {
	@Autowired
	IncomeTaxMapper incomeTaxMapper;
	@Autowired
	UserMapper userMapper;

	public void execute(HttpSession session, String incomeTaxReportNum, Model model) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		//UserDTO dto=userMapper.userSelectOne(userNum);
		
		IncomeTaxDTO dto=incomeTaxMapper.incomeTaxSelectOne(incomeTaxReportNum, userNum);
		
		System.out.println(dto);
		
		
		model.addAttribute("dto", dto);
		
	}

}
