package SmartTax.service.tax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.TaxDTO;
import SmartTax.mapper.TaxMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class TaxListService {
	@Autowired
	TaxMapper taxMapper;
	@Autowired
	UserMapper userMapper;
	

	public void execute(Model model, HttpSession session) {
		
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		List<TaxDTO> list=taxMapper.taxSelectAll(userNum);
		model.addAttribute("list", list);
		
	}

}
