package SmartTax.service.user;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import SmartTax.command.UserCommand;
import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.UserDTO;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class UserUpdateService {
	@Autowired
	UserMapper userMapper;
	
	public void execute(HttpSession session, UserCommand userCommand) {
		AuthInfoDTO auth=(AuthInfoDTO)session.getAttribute("auth");
		String userId=auth.getUserId();
		String userNum=userMapper.userNumSelect(userId);
		
		UserDTO dto = new UserDTO();
		dto.setUserNum(userNum);
		dto.setUserId(userCommand.getUserId());
		dto.setUserPw(userCommand.getUserPw());
		dto.setUserPwCon(userCommand.getUserPwCon());
		dto.setUserName(userCommand.getUserName());
		dto.setUserPhone(userCommand.getUserPhone());
		dto.setUserEmail(userCommand.getUserEmail());
		dto.setUserAddr(userCommand.getUserAddr());
		dto.setUserAddrDetail(userCommand.getUserAddrDetail());
		dto.setUserPost(userCommand.getUserPost());
		dto.setUserJoinDate(userCommand.getUserJoinDate());
		
		
		//dto.setUserProfileImage(userCommand.getUserProfileImage());
		
	////// 파일 추가
			/// 경로
			//URL resource = getClass().getClassLoader().getResource("static/upload");
			//System.out.println("resource : " + resource);
			//String filrDir = resource.getFile();
			String filrDir = "C:/Users/user/eclipse-workspace4/SmartTax4/src/main/resources/static/upload";
			//String filrDir = "C:/Users/misolaptop1/eclipse-workspace/real_time_data_process_20240708/springBootMVCShopping/target/classes/static/upload";
			////////파일 관련 내용
			//  메인이미지
			MultipartFile mf = userCommand.getUserProfileImage(); //메인이미지 파일처리
			String originalFile = mf.getOriginalFilename(); //메인이미지 파일 이름 가져오기
			
			
			/// 저장하기 위한 이름 만들기 : UUID : shfioshiof30750937skfhs
			// 확장자 : .jpg, .png : abcd.abdc.jpg
			//1. 확장자명 가져오기
			String extension = originalFile.substring(originalFile.lastIndexOf("."));
			// uuid 기능을 사용하여 새로운 파일 이름 짖기
			String imageName = UUID.randomUUID().toString().replace("-", "");
			String notOriginalFile = imageName + extension;
			
			
			// 파일 생성, 파일디렉토리에 새로 생성한 파일을 넣는다.
			File file = new File(filrDir + "/" + originalFile);
			File file2 = new File(filrDir + "/" + notOriginalFile);
			
			try {
				mf.transferTo(file);
				mf.transferTo(file2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			/// dto에저장
			dto.setUserProfileImage(originalFile);
			dto.setUserProfileImage2(notOriginalFile);
			////
		userMapper.userUpdate(dto);
		
	}

}
