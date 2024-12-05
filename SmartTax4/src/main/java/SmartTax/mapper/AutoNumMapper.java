package SmartTax.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AutoNumMapper {

	public String autoNumSelect(@Param(value="sep") String sep
			,@Param(value="columnName") String columnName
			,@Param(value="len") Integer len
			,@Param(value="tableName") String tableName);

	public String autoNumSelect1(
			@Param(value="sep1") String sep1
			,@Param(value="columnName") String columnName
			,@Param(value="tableName") String tableName
			,@Param(value="today") String today);

}
