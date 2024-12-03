package SmartTax.service.vat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.VatDTO;
import SmartTax.mapper.UserMapper;
import SmartTax.mapper.VatMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class VatListService {
	@Autowired
	VatMapper vatMapper;
	@Autowired
	UserMapper userMapper;
	

	public void execute(Model model, HttpSession session) {
		
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		List<VatDTO> list=vatMapper.vatSelectAll(userNum);
		model.addAttribute("list", list);
		
	}

}
