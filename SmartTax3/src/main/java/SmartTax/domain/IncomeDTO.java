package SmartTax.domain;



import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("incomeDTO")
@Data
public class IncomeDTO {
	String incomeNum;
	String userNum;
Integer incomeAmount; //매출금액
	Date incomeDate; //매출 발생일
	String incomeCategory; //매출 카테고리
	String incomeDescription; //매출 설명
	Integer incomeVatAmount; //부가세
	
	
}
