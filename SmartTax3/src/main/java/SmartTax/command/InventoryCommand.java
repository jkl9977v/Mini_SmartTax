package SmartTax.command;

import java.sql.Date;

import lombok.Data;

@Data
public class InventoryCommand {
	   String inventoryNum  ;    // 재고 항목 고유 ID
	    String productNum ;      // 제품 ID (products 테이블 참조)
	    String userNum  ;         // 사용자 ID (users 테이블 참조)
	    Integer inventoryQuantity  ;    // 현재 재고 수량
	    Date lastUpdated   ;    // 마지막 업데이트 날짜
}
