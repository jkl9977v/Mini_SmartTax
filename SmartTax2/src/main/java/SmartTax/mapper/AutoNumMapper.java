package SmartTax.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AutoNumMapper {

	String autoNumSelect(@Param(value="sep") String sep
			,@Param(value="columnName") String columnName
			,@Param(value="len") Integer len
			,@Param(value="tableName") String tableName);

}
