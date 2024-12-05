package SmartTax.service.invenTrans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.command.InvenTransCommand;
import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.InvenTransDTO;
import SmartTax.mapper.InvenTransMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class InvenTransUpdateService {
	@Autowired
	InvenTransMapper invenTransMapper;
	@Autowired
	UserMapper userMapper;
	
	public void execute(HttpSession session, InvenTransCommand invenTransCommand) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		InvenTransDTO dto = new InvenTransDTO();
		dto.setTransactionNum(invenTransCommand.getTransactionNum() );
		dto.setProductNum(invenTransCommand.getProductNum());		
		dto.setUserNum(userNum );
		dto.setAddQuantity(invenTransCommand.getAddQuantity() ) ; 
		dto.setTransactionDate(invenTransCommand.getTransactionDate() ) ; 
	
		invenTransMapper.invenTransUpdate(dto);
		
	}


}
