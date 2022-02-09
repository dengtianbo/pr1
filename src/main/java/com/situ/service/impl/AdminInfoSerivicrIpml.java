package com.situ.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.dao.AdminInfoDAO;
import com.situ.model.Admin;
import com.situ.service.AdminInfoService;

@Service
public class AdminInfoSerivicrIpml implements  AdminInfoService {

	@Autowired
	private AdminInfoDAO dao;
	
	//编辑admin信息
	@Override
	public Boolean editAdmin(Admin admin) {
		
		return dao.editAdmin(admin);
	}

	@Override
	public Admin findAdminById(Integer id) {
		
		return dao.findAdminById(id);
	}

	//修改密码
	@Override
	public Boolean editPassword(Admin md5) {
		
		return dao.editPassword(md5);
	}

	

}
