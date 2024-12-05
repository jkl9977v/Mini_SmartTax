package SmartTax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.mapper.CheckMapper;

@Service
public class IdcheckService {
	@Autowired
	CheckMapper checkMapper;

	public Integer execute(String userId) {
		return checkMapper.userIdCheck(userId);
	}

}
