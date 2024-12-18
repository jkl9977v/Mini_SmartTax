package SmartTax.command;

import java.sql.Date;

import lombok.Data;

@Data
public class TaxDeductionsCommand {
	String deductionNum ;        // 공제 항목 번호
	  String  userNum;             // 사용자 번호 (users 테이블 참조)
	   String deductionType ;       // 공제 항목 종류 (기부금; 의료비 등)
	   Integer deductionAmount ;           // 공제 금액
	   Date deductionDate ;                // 공제 적용일
}
