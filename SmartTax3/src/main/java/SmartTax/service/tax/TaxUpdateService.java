package SmartTax.service.tax;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.command.TaxCommand;
import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.TaxDTO;
import SmartTax.mapper.TaxMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class TaxUpdateService {
	@Autowired
	TaxMapper taxMapper;
	@Autowired
	UserMapper userMapper;
	
	public void execute(HttpSession session, TaxCommand taxCommand) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		TaxDTO dto = new TaxDTO();
		dto.setTaxNum(taxCommand.getTaxNum() );
		dto.setUserNum(userNum );
		dto.setIncomeTax(taxCommand.getIncomeTax() ) ; // 제품 이름
		dto.setVatTax(taxCommand.getVatTax() ) ;             // 제품 카테고리
		dto.setTaxDeduction(taxCommand.getTaxDeduction() ) ;             // 제품 구매 가격
		dto.setTaxDueDate(taxCommand.getTaxDueDate() ) ;  
		dto.setTaxPaymentStatus(taxCommand.getTaxPaymentStatus() ) ;

		
		taxMapper.taxUpdate(dto);
		
	}


}
