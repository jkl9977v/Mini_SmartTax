package SmartTax.command;

import java.sql.Date;

import lombok.Data;

@Data
public class ReportsCommand {
	   String  reportNum ;         // 보고서 번호
	   String userNum ;           // 사용자 번호 (users 테이블 참조)
	   Date periodStart ;               // 보고서 기간 시작일
	   Date periodEnd ;                 // 보고서 기간 종료일
	   Integer totalIncome ;             // 총 매출 금액
	   Integer totalExpenses ;           // 총 비용 금액
	   Integer netProfit ;               // 순이익 (총 매출 - 총 비용)
}
