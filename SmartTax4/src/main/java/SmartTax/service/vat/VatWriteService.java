package SmartTax.service.vat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.command.VatCommand;
import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.VatDTO;
import SmartTax.mapper.UserMapper;
import SmartTax.mapper.VatMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class VatWriteService {
	@Autowired
	VatMapper vatMapper;
	@Autowired
	UserMapper userMapper;
	
	public void execute(HttpSession session, VatCommand vatCommand) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		VatDTO dto = new VatDTO();
		dto.setVatReportNum(vatCommand.getVatReportNum() );
		dto.setUserNum(userNum );
		dto.setVatReportDate(vatCommand.getVatReportDate() ) ; 
		dto.setTotalVat(vatCommand.getTotalVat() ) ;
		dto.setVatDueDate(vatCommand.getVatDueDate() ) ;
		dto.setVatPaymentStatus(vatCommand.getVatPaymentStatus() ) ; 
	
		vatMapper.vatInsert(dto);
		
	}

}
