package SmartTax.service.taxDeductions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.TaxDeductionsDTO;
import SmartTax.mapper.TaxDeductionsMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class TaxDeductionsListService {
	@Autowired
	TaxDeductionsMapper taxDeductionsMapper;
	@Autowired
	UserMapper userMapper;
	

	public void execute(Model model, HttpSession session) {
		
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		List<TaxDeductionsDTO> list=taxDeductionsMapper.taxDeductionsSelectAll(userNum);
		model.addAttribute("list", list);
		
	}

}
