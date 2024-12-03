package SmartTax.service.taxDeductions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.TaxDeductionsDTO;
import SmartTax.mapper.TaxDeductionsMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class TaxDeductionsDetailService {
	@Autowired
	TaxDeductionsMapper taxDeductionsMapper;
	@Autowired
	UserMapper userMapper;

	public void execute(HttpSession session, String taxDeductionsReportNum, Model model) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		//UserDTO dto=userMapper.userSelectOne(userNum);
		
		TaxDeductionsDTO dto=taxDeductionsMapper.taxDeductionsSelectOne(taxDeductionsReportNum, userNum);
		
		System.out.println(dto);
		
		
		model.addAttribute("dto", dto);
		
	}

}
