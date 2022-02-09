package com.situ.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.situ.model.Admin;
import com.situ.model.User;
import com.situ.service.AdminInfoService;
import com.situ.service.UserListService;


@Service
public class QuickLocateLogin {
	
	@Autowired
	private  UserListService userListService;
	

	@Autowired
	private  AdminInfoService adminInfoService;
	
	
	/**
	 * 通过id快速查询登录者user
	 * @param id
	 * @return
	 */
	public  User findUserById1(Integer id) {
		return userListService.findById(id);
		
	}
	/**
	 * 通过id快速查询登录者admin
	 * @param id
	 * @return
	 */
	public  Admin findAdminById1(Integer id) {
		return adminInfoService.findAdminById(id);
		
	}
}
