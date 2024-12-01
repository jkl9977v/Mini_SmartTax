package SmartTax.command;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCommand {
	String userPhone;
	String userNum;
	String userId;
	String userName;
	String userEmail;
	String userPw;
	String userPwCon;
	String userAddr;
	String userAddrDetail;
	Integer userPost;
	String userProfileImage;
	Date userJoinDate;
}
