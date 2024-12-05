package SmartTax.service.vat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.StartEndPageDTO;
import SmartTax.domain.UserDTO;
import SmartTax.domain.VatDTO;
import SmartTax.mapper.UserMapper;
import SmartTax.mapper.VatMapper;
import SmartTax.service.StartEndPageService;
import jakarta.servlet.http.HttpSession;

@Service
public class VatListService {
	@Autowired
	VatMapper vatMapper;
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
		
		List<VatDTO> list=vatMapper.vatSelectAll(sepDTO);
		Integer count = vatMapper.vatCount(userNum);
		//model.addAttribute("list", list);
		startEndPageService.execute(page, limit, count, searchWord, list, model);
		
	}

}
