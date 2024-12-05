package SmartTax.command;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCommand {
	@NotBlank(message="전화번호를 입력하여주세요")
	String userPhone;
	String userNum;
	@NotBlank(message="아이디를 입력하여주세요")
	String userId;
	@NotBlank(message="이름을 입력하여주세요")
	String userName;
	@NotBlank(message="이메일을 입력하여주세요")
	String userEmail;
	@NotBlank(message="비밀번호를 입력하여주세요")
	String userPw;
	@NotBlank(message="비밀번호 확인을 입력하여주세요")
	String userPwCon;
	@NotBlank(message="주소를 입력하여주세요")
	String userAddr;
	String userAddrDetail;
	@NotNull(message="우편번호를 입력하여주세요")
	Integer userPost;
	
	MultipartFile userProfileImage;
	//MultipartFile userProfileImage2;
	Date userJoinDate;
}
