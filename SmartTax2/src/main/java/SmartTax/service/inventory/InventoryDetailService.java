package SmartTax.service.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.InventoryDTO;
import SmartTax.mapper.InventoryMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class InventoryDetailService {
	@Autowired
	InventoryMapper inventoryMapper;
	@Autowired
	UserMapper userMapper;

	public void execute(HttpSession session, String productNum, Model model) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		//UserDTO dto=userMapper.userSelectOne(userNum);
		
		InventoryDTO dto=inventoryMapper.inventorySelectOne(productNum, userNum);
		
		System.out.println(dto);
		
		
		model.addAttribute("dto", dto);
		
	}

}
