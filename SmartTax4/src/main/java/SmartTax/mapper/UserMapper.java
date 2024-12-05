package SmartTax.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.UserDTO;

@Mapper
public interface UserMapper {

	public void userInsert(UserDTO dto);

	public List<UserDTO> userSelectAll();

	public String userNumSelect(String userId);

	public UserDTO userSelectOne(String userNum);

	public int userDelete(String userNum);

	public void userUpdate(UserDTO dto);

	public String findUserId(@Param("userPhone") String userPhone
			,@Param("userEmail") String userEmail);

	public AuthInfoDTO findUserPw(@Param("userId") String userId
			,@Param("userEmail") String userEmail);

}
