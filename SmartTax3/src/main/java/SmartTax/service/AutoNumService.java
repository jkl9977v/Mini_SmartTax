package SmartTax.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.mapper.AutoNumMapper;


@Service
public class AutoNumService {
   @Autowired
   AutoNumMapper autoNumMapper;
   
   public String execute(String sep, String columnName, Integer len, String tableName) {
      //select 
      //concat(#{sep},nvl(max(substr(${columnName},#{len})),100000) + 1) 
   //from ${tableName}
      String autoNum=autoNumMapper.autoNumSelect(sep,columnName,len,tableName);
      return autoNum;
      
   }
   
   public String execute1(String sep, String columnName, String tableName) {
		//ded+날짜+1의 형태로 //ex ded20241202_1
	   //날짜가 일치하는 번호 중 13번째 자리부터 숫자를 가져와서 거기에 +1을 한다.
	   //len=13 or 14
	   //concat(#{sep1},nvl(max(substr(${columnName},13)),1) + 1) from ${tableName} where ${columnName} like '%'||#{today}||'%'
	   
	   SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd"); 
	    LocalDate now=LocalDate.now();
	    String today=sdf1.format(now+"_");
	    String sep1=sep+today;
	    System.out.println("today");
	    
		String autoNum=autoNumMapper.autoNumSelect1(sep1, columnName, tableName, today);
		return autoNum;
	}
}
