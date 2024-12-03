package SmartTax.domain;



import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("taxDeductionsDTO")
@Data
public class TaxDeductionsDTO {
	String deductionNum ;        // 공제 항목 번호
	  String  userNum;             // 사용자 번호 (users 테이블 참조)
	   String deductionType ;       // 공제 항목 종류 (기부금; 의료비 등)
	   Integer deductionAmount ;           // 공제 금액
	   Date deductionDate ;                // 공제 적용일
}
