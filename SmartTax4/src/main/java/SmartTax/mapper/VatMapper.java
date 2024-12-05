package SmartTax.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import SmartTax.domain.StartEndPageDTO;
import SmartTax.domain.VatDTO;

@Mapper
public interface VatMapper {
	
	public void vatInsert(VatDTO dto);

	public void vatUpdate(VatDTO dto);

	public List<VatDTO> vatSelectAll(StartEndPageDTO sepDTO);

	public VatDTO vatSelectOne(@Param("vatReportNum") String vatReportNum
			,@Param("userNum") String userNum);

	public void vatDelete(@Param("userNum") String userNum
			, @Param("vatReportNum") String vatReportNum);

	public Integer vatCount(String userNum);

	

}
