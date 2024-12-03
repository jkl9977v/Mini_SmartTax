package SmartTax.service.inventory;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.command.InventoryCommand;
import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.InventoryDTO;
import SmartTax.mapper.InventoryMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class InventoryUpdateService {
	@Autowired
	InventoryMapper inventoryMapper;
	@Autowired
	UserMapper userMapper;
	
	public void execute(HttpSession session, InventoryCommand inventoryCommand) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		InventoryDTO dto = new InventoryDTO();
		dto.setInventoryNum(inventoryCommand.getInventoryNum() );
		dto.setUserNum(userNum );
		dto.setProductNum(inventoryCommand.getProductNum() ) ; 
		dto.setInventoryQuantity(inventoryCommand.getInventoryQuantity() ) ; 
	
		inventoryMapper.inventoryUpdate(dto);
		
	}


}
