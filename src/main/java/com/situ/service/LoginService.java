package com.situ.service;

import com.situ.model.Admin;
import com.situ.model.User;

public interface LoginService {

	/**
	 * 查询是否有user
	 * @param user
	 * @return
	 */
	public Admin findAdmin(Admin user);
	
	
	public User findUser(User user);

	
	public boolean save(User user);


	/**
	 * 根据username查询是否有user 没有查询到返回null，查到返回user
	 */
	public User findUsername(User user);
}
