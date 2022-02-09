package com.situ.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.situ.dao.LoginDAO;
import com.situ.model.Admin;
import com.situ.model.User;
import com.situ.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAO dao;

	/**
	 * 查询是否有admin 没有查询到返回null，查到返回admin
	 */
	@Override
	public Admin findAdmin(Admin user) {

		Admin checkuser = dao.findAdmin(user.getUsername());

		if (checkuser == null) {
			return null;
		}
		// 在数据库中新增用户的时候，密码是：username{password}的md5格式
		String encrypt = user.getUsername() + "{" + user.getPassword() + "}";
		String md5Str = DigestUtils.md5DigestAsHex(encrypt.getBytes());

		if (md5Str.equals(checkuser.getPassword())) {

			return checkuser;
		} else {
			return null;
		}
	}

	/**
	 * 查询是否有user 没有查询到返回null，查到返回user
	 */
	@Override
	public User findUser(User user) {
		User checkuser = dao.findUser(user.getUsername());

		if (checkuser == null) {
			return null;
		}
		// 在数据库中新增用户的时候，密码是：username{password}的md5格式
		String encrypt = user.getUsername() + "{" + user.getPassword() + "}";
		String md5Str = DigestUtils.md5DigestAsHex(encrypt.getBytes());

		if (md5Str.equals(checkuser.getPassword())) {
			return checkuser;
		} else {

			return null;
		}
	}
	
	/**
	 * 根据username查询是否有user 没有查询到返回null，查到返回user
	 */
	@Override
	public User findUsername(User user) {
		return dao.findUser(user.getUsername());
	}

	/**
	 * 添加用户
	 */
	@Override
	public boolean save(User user) {
		
		String encrypt = user.getUsername() + "{" + user.getPassword() + "}";
		String md5Str = DigestUtils.md5DigestAsHex(encrypt.getBytes());
		user.setPassword(md5Str);

		return dao.saveUser(user);
	}

}
