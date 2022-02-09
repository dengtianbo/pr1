package com.situ.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * 后端控制台
 * @author 浅墨~~
 * @date  2021年12月24日
 */
@Controller
@RequestMapping("/admin")
public class AdminConsoleController {
	
	@RequestMapping("/index")
	public String console() {
		
		return "backstage/index";
	}
	/**
	 * 主页
	 * @return
	 */
	@RequestMapping("/home")
	public String home() {
		
		return "backstage/home";
	}
	
	
	
}
