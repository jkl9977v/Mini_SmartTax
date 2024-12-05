package SmartTax.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

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
	
	Date userJoinDate;
	
	//디비에 파일명을 저장하기 위해 필요하다.
	String userProfileImage; //원래 파일명 저장
	String userProfileImage2; //별도의 파일명 저장
	
}