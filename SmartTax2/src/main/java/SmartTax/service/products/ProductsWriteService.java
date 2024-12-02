package SmartTax.service.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.command.ProductsCommand;
import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.ProductsDTO;
import SmartTax.mapper.ProductsMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class ProductsWriteService {
	@Autowired
	ProductsMapper productsMapper;
	@Autowired
	UserMapper userMapper;
	
	public void execute(HttpSession session, ProductsCommand productsCommand) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		ProductsDTO dto = new ProductsDTO();
		dto.setProductNum(productsCommand.getProductNum() );
		dto.setUserNum(userNum );
		dto.setProductName(productsCommand.getProductName() ) ; // 제품 이름
		dto.setCategory(productsCommand.getCategory() ) ;             // 제품 카테고리
		dto.setPurchasePrice(productsCommand.getPurchasePrice() ) ;             // 제품 구매 가격
		dto.setSalePrice(productsCommand.getSalePrice() ) ; 
	
		productsMapper.productsInsert(dto);
		
	}

}
