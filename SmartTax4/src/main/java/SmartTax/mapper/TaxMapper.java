package SmartTax.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import SmartTax.domain.StartEndPageDTO;
import SmartTax.domain.TaxDTO;

@Mapper
public interface TaxMapper {
	
	public void taxInsert(TaxDTO dto);

	public void taxUpdate(TaxDTO dto);

	public List<TaxDTO> taxSelectAll(StartEndPageDTO sepDTO);

	public TaxDTO taxSelectOne(@Param("taxNum") String taxNum
			,@Param("userNum") String userNum);

	public void taxDelete(@Param("userNum") String userNum
			, @Param("taxNum") String taxNum);
	
	public Integer taxCount(String userNum);

	

}
