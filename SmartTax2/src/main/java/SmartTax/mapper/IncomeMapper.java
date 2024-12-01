package SmartTax.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import SmartTax.domain.IncomeDTO;

@Mapper
public interface IncomeMapper {
	
	public void incomeInsert(IncomeDTO dto);

	public void incomeUpdate(IncomeDTO dto);

	public List<IncomeDTO> incomeSelectAll(String userNum);

	public IncomeDTO incomeSelectOne(@Param("incomeNum") String incomeNum
			,@Param("userNum") String userNum);

	public void incomeDelete(@Param("userNum") String userNum
			, @Param("incomeNum") String incomeNum);

	

}
