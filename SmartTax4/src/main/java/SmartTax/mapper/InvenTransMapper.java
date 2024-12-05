package SmartTax.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import SmartTax.domain.InvenTransDTO;
import SmartTax.domain.StartEndPageDTO;

@Mapper
public interface InvenTransMapper {
	
	public void invenTransInsert(InvenTransDTO dto);

	public void invenTransUpdate(InvenTransDTO dto);

	public List<InvenTransDTO> invenTransSelectAll(StartEndPageDTO sepDTO);

	public InvenTransDTO invenTransSelectOne(@Param("transactionNum") String transactionNum
			,@Param("userNum") String userNum);

	public void invenTransDelete(@Param("userNum") String userNum
			, @Param("transactionNum") String transactionNum);

	public Integer invenTransCount(String userNum);

	

}
