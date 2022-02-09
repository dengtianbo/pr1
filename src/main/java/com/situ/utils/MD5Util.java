package com.situ.utils;

import org.springframework.util.DigestUtils;

/**
 * 密码是：username{password}的md5格式
 * @author 浅墨~~
 * @date  2021年12月28日
 */
public class MD5Util {

	/**
	 * 返回值为加密后的密码
	 * @param name
	 * @param passwrod
	 * @return
	 */
	public static String Md5(String name,String passwrod) {
		// 在数据库中新增用户的时候，密码是：username{password}的md5格式
		String encrypt = name + "{" + passwrod + "}";
		String md5Str = DigestUtils.md5DigestAsHex(encrypt.getBytes());
		return md5Str;
	}
}
