package com.situ.dao;

import org.apache.ibatis.annotations.Mapper;

import com.situ.model.Admin;
import com.situ.model.User;

/**
 * 查询User表
 * 
 * @author 浅墨~~
 * @date 2021年12月23日
 */

@Mapper
public interface LoginDAO {
	// 查询admin
	public Admin findAdmin(String username);

	// 添加admin
	public boolean saveAdmin(Admin admin);

	// 修改admin
	public boolean updateAdmin(Admin admin);

	// 删除admin
	public boolean deleteAdmin(String name);

	
	
	// 查询user
	public User findUser(String username);

	// 添加user
	public boolean saveUser(User user);

	// 修改user
	public boolean updateUser(User user);

	// 删除user
	public boolean deleteUser(String name);

}
