package SmartTax.service.incomeTax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.IncomeTaxDTO;
import SmartTax.domain.StartEndPageDTO;
import SmartTax.domain.UserDTO;
import SmartTax.mapper.IncomeTaxMapper;
import SmartTax.mapper.UserMapper;
import SmartTax.service.StartEndPageService;
import jakarta.servlet.http.HttpSession;

@Service
public class IncomeTaxListService {
	@Autowired
	IncomeTaxMapper incomeTaxMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	StartEndPageService startEndPageService;
	

	public void execute(String searchWord, Integer page, Model model, HttpSession session) {
		
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		UserDTO dto=userMapper.userSelectOne(userNum);
		model.addAttribute("dto",dto);
		
		Integer limit=3;
		StartEndPageDTO sepDTO = startEndPageService.execute(page, limit, searchWord,userNum);
		
		List<IncomeTaxDTO> list=incomeTaxMapper.incomeTaxSelectAll(sepDTO);
		Integer count = incomeTaxMapper.incomeTaxCount(userNum);
		//model.addAttribute("list", list);
		startEndPageService.execute(page, limit, count, searchWord, list, model);
		
	}

}
