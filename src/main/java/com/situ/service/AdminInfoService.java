package com.situ.service;

import com.situ.model.Admin;

public interface AdminInfoService {

	//
	public Boolean editAdmin(Admin admin) ;

	public Admin findAdminById(Integer id);

	//修改密码
	public Boolean editPassword(Admin admin);

}
