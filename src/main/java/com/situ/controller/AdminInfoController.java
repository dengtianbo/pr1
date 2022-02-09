package com.situ.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.model.Admin;
import com.situ.service.AdminInfoService;
import com.situ.utils.MD5Util;

@Controller
@RequestMapping("/admin")
public class AdminInfoController {
	@Autowired
	private AdminInfoService service;
	

	@RequestMapping("/info")
	public String info(Map<String, Object> map, HttpSession session) {
		Admin admin = (Admin) session.getAttribute("admin");
		admin= service.findAdminById(admin.getId());
		//System.out.println(admin);
		map.put("admin", admin);
		return "backstage/admin_info";
	}
	
	@RequestMapping("/info_edit")
	public String info_edit(Map<String, Object> map, Admin admin) {
		System.out.println("_______");
		System.out.println(admin);
		System.out.println("_______");
		
		Boolean success = service.editAdmin(admin);
		if(success) {
		Admin editAdmin=service.findAdminById(admin.getId());
			map.put("admin", editAdmin);
			return "backstage/admin_info";
		}
		map.put("admin", admin);
		return "forword:/admin/info_edit";
		
		
	}

	//修改密码
	@RequestMapping("/password_edit")
	public String password_edit(Map<String, Object> map, String password,HttpSession session) {
		Admin admin = (Admin) session.getAttribute("admin");
		admin=service.findAdminById(admin.getId());
		
		System.out.println("_______");
		System.out.println(admin.getUsername());
		System.out.println(password);
		System.out.println("_______");
		
		String md5=MD5Util.Md5(admin.getUsername(), password);
		admin.setPassword(md5);
		Boolean success = service.editPassword(admin);
		
		if(success) {
		Admin editAdmin=service.findAdminById(admin.getId());
			map.put("admin", editAdmin);
		}
		
		
		return "backstage/admin_info";
	}
	
}
