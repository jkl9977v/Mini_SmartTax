package SmartTax.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("userDTO")
public class UserDTO {
	String userPhone;
	String userNum; //
	String userId; //
	String userName; //
	String userEmail; //
	String userPw; // 
	String userPwCon;//
	String userAddr;//
	String userAddrDetail;//
	Integer userPost;
	String userProfileImage;
	Date userJoinDate;
}