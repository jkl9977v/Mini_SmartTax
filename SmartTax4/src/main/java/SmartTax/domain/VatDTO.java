package SmartTax.domain;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("vatDTO")
@Data
public class VatDTO {
 	String vatReportNum ;  // 부가세 신고 번호
    String userNum ;       // 사용자 번호 (users 테이블 참조)
    Date vatReportDate ;   // 신고 일자
    Integer totalVat ;     // 신고된 총 부가세 금액 //financialReports 테이블의 순수익 항목의 10%
    Date vatDueDate ;      // 납부 기한
    String vatPaymentStatus ;  // 납부 상태 (납부 완료; 미납 등)
}
