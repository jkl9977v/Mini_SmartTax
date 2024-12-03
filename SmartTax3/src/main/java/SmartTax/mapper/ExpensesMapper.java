package SmartTax.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import SmartTax.domain.ExpensesDTO;

@Mapper
public interface ExpensesMapper {
	
	public void expenseInsert(ExpensesDTO dto);

	public void expenseUpdate(ExpensesDTO dto);

	public List<ExpensesDTO> expenseSelectAll(String userNum);

	public ExpensesDTO expenseSelectOne(@Param("expenseNum") String expenseNum
			,@Param("userNum") String userNum);

	public void expenseDelete(@Param("userNum") String userNum
			, @Param("expenseNum") String expenseNum);

	

}
