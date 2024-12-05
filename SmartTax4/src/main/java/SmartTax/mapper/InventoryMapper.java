package SmartTax.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import SmartTax.domain.InventoryDTO;
import SmartTax.domain.StartEndPageDTO;

@Mapper
public interface InventoryMapper {
	
	public void inventoryInsert(InventoryDTO dto);

	public void inventoryUpdate(InventoryDTO dto);

	public List<InventoryDTO> inventorySelectAll(StartEndPageDTO sepDTO);

	public InventoryDTO inventorySelectOne(@Param("inventoryNum") String inventoryNum
			,@Param("userNum") String userNum);

	public void inventoryDelete(@Param("userNum") String userNum
			, @Param("inventoryNum") String inventoryNum);

	public Integer inventoryCount(String userNum);

	

}
