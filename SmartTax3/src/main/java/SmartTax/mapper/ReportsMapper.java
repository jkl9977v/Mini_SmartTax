package SmartTax.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import SmartTax.domain.ReportsDTO;

@Mapper
public interface ReportsMapper {
	
	public void reportInsert(ReportsDTO dto);

	public void reportUpdate(ReportsDTO dto);

	public List<ReportsDTO> reportSelectAll(String userNum);

	public ReportsDTO reportSelectOne(@Param("reportNum") String reportNum
			,@Param("userNum") String userNum);

	public void reportDelete(@Param("userNum") String userNum
			, @Param("reportNum") String reportNum);

	

}
