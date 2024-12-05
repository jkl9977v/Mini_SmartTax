package SmartTax.service.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.mapper.InventoryMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class InventoryDeleteService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	InventoryMapper inventoryMapper;

	public void execute(HttpSession session, String inventoryNum) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		inventoryMapper.inventoryDelete(userNum, inventoryNum);
		
	}

}
