package SmartTax.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import SmartTax.domain.IncomeDTO;
import SmartTax.domain.StartEndPageDTO;

@Mapper
public interface IncomeMapper {
	
	public void incomeInsert(IncomeDTO dto);

	public void incomeUpdate(IncomeDTO dto);

	public List<IncomeDTO> incomeSelectAll(StartEndPageDTO sepDTO);

	public IncomeDTO incomeSelectOne(@Param("incomeNum") String incomeNum
			,@Param("userNum") String userNum);

	public void incomeDelete(@Param("userNum") String userNum
			, @Param("incomeNum") String incomeNum);

	public Integer incomeCount(String userNum);

	

}
