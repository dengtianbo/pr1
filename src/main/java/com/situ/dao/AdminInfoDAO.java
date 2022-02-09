package com.situ.dao;

import org.apache.ibatis.annotations.Mapper;

import com.situ.model.Admin;

@Mapper
public interface AdminInfoDAO {

	/**
	 * 编辑admin
	 * @param admin
	 * @return
	 */
	public Boolean editAdmin(Admin admin);

	/**
	 * 通过id查询admin
	 * @param id
	 * @return
	 */
	public Admin findAdminById(Integer id);

	/**
	 * 修改密码
	 * @param md5
	 * @return
	 */
	public Boolean editPassword(Admin admin);
	
}
