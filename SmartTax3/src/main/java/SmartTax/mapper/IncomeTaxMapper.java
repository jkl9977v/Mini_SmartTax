package SmartTax.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import SmartTax.domain.IncomeTaxDTO;

@Mapper
public interface IncomeTaxMapper {
	
	public void incomeTaxInsert(IncomeTaxDTO dto);

	public void incomeTaxUpdate(IncomeTaxDTO dto);

	public List<IncomeTaxDTO> incomeTaxSelectAll(String userNum);

	public IncomeTaxDTO incomeTaxSelectOne(@Param("incomeTaxReportNum") String incomeTaxReportNum
			,@Param("userNum") String userNum);

	public void incomeTaxDelete(@Param("userNum") String userNum
			, @Param("incomeTaxReportNum") String incomeTaxReportNum);

	

}
