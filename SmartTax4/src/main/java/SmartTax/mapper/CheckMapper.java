package SmartTax.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CheckMapper {

	public Integer userIdCheck(String userId);

	public Integer userEmailCheck(String userEmail);

}
