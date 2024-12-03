package SmartTax.service.vat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.VatDTO;
import SmartTax.mapper.UserMapper;
import SmartTax.mapper.VatMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class VatDetailService {
	@Autowired
	VatMapper vatMapper;
	@Autowired
	UserMapper userMapper;

	public void execute(HttpSession session, String vatReportNum, Model model) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		//UserDTO dto=userMapper.userSelectOne(userNum);
		
		VatDTO dto=vatMapper.vatSelectOne(vatReportNum, userNum);
		
		System.out.println(dto);
		
		
		model.addAttribute("dto", dto);
		
	}

}
