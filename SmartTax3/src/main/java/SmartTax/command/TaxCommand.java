package SmartTax.command;

import java.sql.Date;

import lombok.Data;

@Data
public class TaxCommand {
	 String taxNum ;            // 세금 번호 //tax+오늘날짜+1
	   String userNum ;           // 사용자 번호 (users 테이블 참조)
	   Integer incomeTax ;               // 소득세 금액
	   Integer vatTax ;                  // 부가세 금액 (매출세액 - 매입세액)
	   Integer taxDeduction ;            // 공제 금액
	   Date taxDueDate ;               // 세금 신고 및 납부 기한
	   String taxPaymentStatus;    // 납부 상태 (납부 완료; 미납 등)
}
