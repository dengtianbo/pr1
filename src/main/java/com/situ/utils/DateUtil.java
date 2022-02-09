package com.situ.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 把Date转String
 * @author 浅墨~~
 * @date  2022年1月10日
 */
public class DateUtil {
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

	public static String dateString(Date date) {
		
		return sdf.format(date);
	}
	
}
