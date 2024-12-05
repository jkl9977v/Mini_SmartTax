package SmartTax.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import SmartTax.domain.IncomeTaxDTO;
import SmartTax.domain.StartEndPageDTO;

@Mapper
public interface IncomeTaxMapper {
	
	public void incomeTaxInsert(IncomeTaxDTO dto);

	public void incomeTaxUpdate(IncomeTaxDTO dto);

	public List<IncomeTaxDTO> incomeTaxSelectAll(StartEndPageDTO sepDTO);

	public IncomeTaxDTO incomeTaxSelectOne(@Param("incomeTaxReportNum") String incomeTaxReportNum
			,@Param("userNum") String userNum);

	public void incomeTaxDelete(@Param("userNum") String userNum
			, @Param("incomeTaxReportNum") String incomeTaxReportNum);

	public Integer incomeTaxCount(String userNum);

	

}
