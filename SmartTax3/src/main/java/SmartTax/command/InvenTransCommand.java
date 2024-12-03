package SmartTax.command;

import java.sql.Date;

import lombok.Data;

@Data
public class InvenTransCommand {
	String transactionNum  ;       // 거래 고유 ID
    String productNum ;  // 재고 ID (inventory 테이블 참조)
    String userNum ;
    Integer addQuantity ;       // 입고출고 수량
    Date transactionDate ;               // 거래 일자
}
