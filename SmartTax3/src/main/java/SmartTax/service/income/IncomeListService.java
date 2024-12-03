package SmartTax.service.income;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.IncomeDTO;
import SmartTax.mapper.IncomeMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class IncomeListService {
	@Autowired
	IncomeMapper incomeMapper;
	@Autowired
	UserMapper userMapper;
	

	public void execute(Model model, HttpSession session) {
		
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		List<IncomeDTO> list=incomeMapper.incomeSelectAll(userNum);
		model.addAttribute("list", list);
		
	}

}
