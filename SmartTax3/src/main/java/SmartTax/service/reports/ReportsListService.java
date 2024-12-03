package SmartTax.service.reports;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.ReportsDTO;
import SmartTax.mapper.ReportsMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class ReportsListService {
	@Autowired
	ReportsMapper reportsMapper;
	@Autowired
	UserMapper userMapper;
	

	public void execute(Model model, HttpSession session) {
		
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		List<ReportsDTO> list=reportsMapper.reportSelectAll(userNum);
		model.addAttribute("list", list);
		
	}

}
