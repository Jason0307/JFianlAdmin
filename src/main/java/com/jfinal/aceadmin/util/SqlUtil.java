package com.jfinal.aceadmin.util;

import java.util.List;

public class SqlUtil {

	public static String replaceSql(String data){
		List<String> list = StringUtil.spiltString2List(data);
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < list.size(); i++){
			sb.append("\"").append(list.get(i)).append("\"");
			if(i < list.size() - 1){
				sb.append(",");
			}
		}
		
		return sb.toString();
	}
	
}
