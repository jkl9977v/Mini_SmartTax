package SmartTax.service.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.mapper.ProductsMapper;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class ProductsDeleteService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	ProductsMapper productsMapper;

	public void execute(HttpSession session, String productNum) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		productsMapper.productsDelete(userNum, productNum);
		
	}

}
