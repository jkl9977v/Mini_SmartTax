package SmartTax.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import SmartTax.domain.TaxDeductionsDTO;

@Mapper
public interface TaxDeductionsMapper {
	
	public void taxDeductionsInsert(TaxDeductionsDTO dto);

	public void taxDeductionsUpdate(TaxDeductionsDTO dto);

	public List<TaxDeductionsDTO> taxDeductionsSelectAll(String userNum);

	public TaxDeductionsDTO taxDeductionsSelectOne(@Param("deductionNum") String deductionNum
			,@Param("userNum") String userNum);

	public void taxDeductionsDelete(@Param("userNum") String userNum
			, @Param("deductionNum") String deductionNum);

	

}
