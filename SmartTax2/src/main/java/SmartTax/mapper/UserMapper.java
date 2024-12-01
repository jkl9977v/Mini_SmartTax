package SmartTax.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import SmartTax.domain.UserDTO;

@Mapper
public interface UserMapper {

	public void userInsert(UserDTO dto);

	public List<UserDTO> userSelectAll();

	public String userNumSelect(String userId);

	public UserDTO userSelectOne(String userNum);

	public void userDelete(String userNum);

	public void userUpdate(UserDTO dto);

}
