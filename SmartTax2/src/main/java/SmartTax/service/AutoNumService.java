package SmartTax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SmartTax.mapper.AutoNumMapper;


@Service
public class AutoNumService {
   @Autowired
   AutoNumMapper autoNumMapper;
   
   public String execute(String sep, String columnName, Integer len, String tableName) {
      //select 
      //concat(#{sep},COALESCE(max(substr(${columnName},#{len})),100000) + 1) 
   //from ${tableName}
      String autoNum=autoNumMapper.autoNumSelect(sep,columnName,len,tableName);
      return autoNum;
      
   }
}
