package SmartTax.service.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.command.InventoryCommand;
import SmartTax.command.ProductsCommand;
import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.InventoryDTO;
import SmartTax.domain.ProductsDTO;
import SmartTax.mapper.InventoryMapper;
import SmartTax.mapper.ProductsMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class InventoryWriteService {
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
	
		inventoryMapper.inventoryInsert(dto);
		
	}


}
