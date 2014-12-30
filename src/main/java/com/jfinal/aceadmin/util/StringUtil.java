package com.jfinal.aceadmin.util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {

	public static List<String> spiltString2List(String data){
		String[] arr = data.split(",");
		List<String> result = Arrays.asList(arr);
		return result;
	}
}
