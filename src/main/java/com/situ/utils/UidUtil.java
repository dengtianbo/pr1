package com.situ.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 随机uid
 * @author 浅墨~~
 * @date  2022年1月10日
 */
public class UidUtil {
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
	public static String range() {
		
		int k1=(int)(Math.random()*1000+100);
		int k2=(int)(Math.random()*1000+100);
		String date = sdf.format(new Date());
		
		return k1+date+k2;
	}
	

}
