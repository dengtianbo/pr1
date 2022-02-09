package com.situ.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.situ.model.Admin;
import com.situ.model.User;
import com.situ.service.LoginService;
/**
 * 登入
 * @author 浅墨~~
 * @date  2021年12月24日
 */
@Controller
public class LoginController {
	@Autowired
	LoginService service;

	@GetMapping("/user/regist")
	public String regist() {
		return "login/regist";
	}
	
	@GetMapping("/admin/login")
	public String login() {
		return "login/admin";
	}
	
	@GetMapping("/user/login")
	public String login2() {
		return "login/login";
	}

	/**
	 * 管理员登入
	 * @param user
	 * @param map
	 * @param request
	 * @return
	 */
	@PostMapping("/admin/login")
	public String login(Admin user,String captcha, Map<String, Object> map, HttpServletRequest request) {
		System.out.println(user);
		System.out.println(captcha);
		String yan = (String) request.getSession().getAttribute("captcha");
		
		if(!yan.equals(captcha)) {
			System.out.println("验证码错误");
			map.put("info", "验证码错误");
			return "login/admin";
		}
		
		Admin checkuser = service.findAdmin(user);
		System.out.println("管理员"+checkuser);
		
		if (checkuser == null) {
			System.out.println("用户账号或密码错误");
			map.put("info", "用户账号或密码错误");
			return "login/admin";
		}else {
			request.getSession().setAttribute("@@admin_login", checkuser);
			request.getSession().setAttribute("admin", checkuser);
			
			return "redirect:/admin/index";
		}
	}
	
	/**
	 * 用户登入
	 * @param user
	 * @param map
	 * @param request
	 * @return
	 */
	@PostMapping("/user/login")
	public String login2(User user,String captcha, Map<String, Object> map, HttpServletRequest request) {
		System.out.println(user);
		System.out.println(captcha);
		String yan = (String) request.getSession().getAttribute("captcha");
		
		if(!yan.equals(captcha)) {
			System.out.println("验证码错误");
			map.put("info", "验证码错误");
			return "login/login";
		}
		
		User checkuser = service.findUser(user);
		
		
		if (checkuser == null) {
			System.out.println("用户账号或密码错误");
			map.put("info", "用户账号或密码错误");
			return "login/login";
		}else {
			request.getSession().setAttribute("@@client_user_login", checkuser);
			
			request.getSession().setAttribute("user", checkuser);
			
			System.out.println("用户"+checkuser);
			return "redirect:/client/index";
		}
	}
	
	
	/**
	 * 用户注册
	 * @param user
	 * @param map
	 * @param request
	 * @return
	 */
	@PostMapping("/user/regist")
	public String regist(User user,String captcha,String password2, String checkbox,Map<String, Object> map, HttpServletRequest request) {
		System.out.println(user);
		System.out.println(captcha);
		System.out.println(password2);
		System.out.println(checkbox);
		//是否接受协议
		if (checkbox==null) {
			System.out.println("请接收协议");
			map.put("info", "请接收协议");
			return "login/regist";
		} 
		
		//验证码比较
		String yan = (String) request.getSession().getAttribute("captcha");
		if(!yan.equals(captcha)) {
			System.out.println("验证码错误");
			map.put("info", "验证码错误");
			return "login/regist";
		}
		
		//密码两次是否一致
		if(user.getPassword()==null||!user.getPassword().equals(password2)) {
			System.out.println("两次密码不一致");
			map.put("info", "两次密码不一致");
			return "login/regist";
		}
		
		//是否已经存在该用户
		User checkuser = service.findUsername(user);
		if (checkuser != null) {
			System.out.println("该用户存在");
			map.put("info", "该用户存在");
			return "login/regist";
		}
		//添加
		boolean save = service.save(user);
		if(save) {
			return "redirect:/user/login";
		}else {
			System.out.println("添加失败，请联系管理员");
			map.put("info", "添加失败，请联系管理员");
			return "login/regist";
		}
		
		
	}

}
