package com.situ.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.situ.global.Global;
import com.situ.model.User;
import com.situ.service.UserListService;

@Controller
@RequestMapping("/client")
public class ClientUserController {

	@Autowired
	private UserListService service;
	
	
	@RequestMapping("/user_info")
	public String user_info(Map<String, Object> map, HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println("*****"+user);
		user=service.findById(user.getId());
		map.put("user", user);

		return "front-end/member_user";
	}
	//设置默认地址
	@RequestMapping("/user_address")
	public String user_address(String address,HttpSession session) {
		System.out.println(address);
		User user= (User) session.getAttribute("user");
		User user1=new User();
		user1.setId(user.getId());
		user1.setAddress(address);
		service.updateAddress(user1);
		
		return  "redirect:/client/address_list";
	}
	
	//修改头像
	@GetMapping("/editportrait")
	public String editportrait() {
		
		return "front-end/editportrait";
	}
	
	@PostMapping("/editportrait")
	public String editportrait2( Map<String, Object> map, 
			@RequestParam(name = "portrait-pic") MultipartFile file ,HttpSession session) {
		
		User user= (User) session.getAttribute("user");
		user=service.findById(user.getId());
		String uid = UUID.randomUUID().toString();// 保证不重复
		String originalName = file.getOriginalFilename();// 原始文件名
		System.out.println(originalName);
		int lidx = originalName.lastIndexOf(".");
		String ext = originalName.substring(lidx + 1);// 上传文件的扩展名
		// 用户可自定义位置
		String fullName = Global.UPLOAD_PORTRAIT_PATH + "/" + uid + "." + ext;// 文件全名

		File target = new File(fullName);
		try {
			file.transferTo(target);
			user.setPortrait("/upload/image/portrait/" + uid + "." + ext);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		boolean success = false;
		success = service.update(user);
		if (success) {
			return "redirect:/client/user_info";
		} else {
			map.put("error", "您的操作出现异常，请检查后稍候再试，或联系管理员");
			map.put("user", user);
			return "front-end/editportrait";
		}
	}
	
	@RequestMapping("/user_edit")
	public String user_edit(User user, HttpSession session) {
		System.out.println("---"+user);
		
		service.updateInfo(user);
		

		return "redirect:/client/user_info";
	}
	
	
}
