package SmartTax.command;

import java.sql.Date;

import lombok.Data;

@Data
public class ProductsCommand {
	String productNum ;   // 제품 고유 ID
	 String userNum; //등록한 사용자
    String productName ; // 제품 이름
    String category ;             // 제품 카테고리
    Integer purchasePrice ;             // 제품 구매 가격
    Integer salePrice ;                  // 제품 판매 가격
    Date productDate; //제품 등록일
}
