package SmartTax.service.tax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.TaxDTO;
import SmartTax.mapper.TaxMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class TaxDetailService {
	@Autowired
	TaxMapper taxMapper;
	@Autowired
	UserMapper userMapper;

	public void execute(HttpSession session, String taxNum, Model model) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		//UserDTO dto=userMapper.userSelectOne(userNum);
		
		TaxDTO dto=taxMapper.taxSelectOne(taxNum, userNum);
		
		System.out.println(dto);
		
		
		model.addAttribute("dto", dto);
		
	}

}
