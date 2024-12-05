package SmartTax.command;

import java.sql.Date;

import lombok.Data;

@Data
public class ExpensesCommand {
	String expenseNum ;        // 비용 번호
    String userNum;           // 사용자 번호 users 테이블 참조
    String expenseAmount ;           // 비용 금액
    Date expenseDate;               // 비용 발생일
    String expenseCategory;   // 비용 카테고리 임대료 급여 등
    String expenseDescription ; // 비용 설명 옵션
   Integer expenseVatAmount ;        // 부가세 금액
}
