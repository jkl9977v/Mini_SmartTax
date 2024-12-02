package SmartTax.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import SmartTax.domain.ProductsDTO;

@Mapper
public interface ProductsMapper {
	
	public void productsInsert(ProductsDTO dto);

	public void productsUpdate(ProductsDTO dto);

	public List<ProductsDTO> productsSelectAll(String userNum);

	public ProductsDTO productsSelectOne(@Param("productNum") String productNum
			,@Param("userNum") String userNum);

	public void productsDelete(@Param("userNum") String userNum
			, @Param("productNum") String productNum);

	

}
