package SmartTax.service.user;

import java.io.File;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.domain.AuthInfoDTO;
import SmartTax.domain.UserDTO;
import SmartTax.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class UserDeleteService {
	@Autowired
	UserMapper userMapper;

	public void execute(HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String userId = auth.getUserId();
		String userNum = userMapper.userNumSelect(userId);

		// userMapper.userDelete(userNum);

		// 파일 삭제
		// 먼저 삭제할 파일의 정보를 가져옵니다.
		UserDTO dto = userMapper.userSelectOne(userNum);
		int i = userMapper.userDelete(userNum);
		// 파일 삭제코드를 추가합니다.
		if (i > 0) {
			// 1. 디렉터리 경로
			URL resource = getClass().getClassLoader().getResource("static/upload");
			String fileDir = resource.getFile();
			// 2. 파일 객체 생성
			File file = new File(fileDir + "/" + dto.getUserProfileImage());
			// 3. 삭제
			if (file.exists())
				file.delete();

			

		}
	}

}
