package SmartTax.domain;



import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("incomeTaxDTO")
@Data
public class IncomeTaxDTO {
	   String  incomeTaxReportNum ; // 소득세 신고 번호
	   String userNum ;              // 사용자 번호 (users 테이블 참조)
	   Date incomeTaxReportDate ;        // 신고 일자
	   Integer taxableIncome ;              // 신고된 과세소득 금액
	   Integer incomeTaxDue ;              // 납부해야 할 소득세 금액
	   String incomeTaxPaymentStatus ; // 납부 상태 (납부 완료; 미납 등)
}
