package SmartTax.mapper;

import org.apache.ibatis.annotations.Mapper;

import SmartTax.domain.AuthInfoDTO;

@Mapper
public interface LoginMapper {

	public AuthInfoDTO userLoginSelectOne(String userId);

}