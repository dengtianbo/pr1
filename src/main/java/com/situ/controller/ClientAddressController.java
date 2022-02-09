package com.situ.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.model.Address;
import com.situ.model.User;
import com.situ.service.AddressService;
import com.situ.service.UserListService;

@Controller
@RequestMapping("/client")
public class ClientAddressController {
	
	@Autowired
	private AddressService service;
	
	@Autowired
	 private  UserListService userListService;

	@RequestMapping("/address_list")
	public String address_list(HttpSession session,Map<String, Object>map) {
		User user=(User)session.getAttribute("user");
		user= userListService.findById(user.getId());
		List<Address> lsit=service.findByUserId(user.getId());
		map.put("list", lsit);
		map.put("user", user);
		 
		return "front-end/member_address";
	}
	
	@PostMapping("/address_add")
	public String address_add(Address address,HttpSession session,Map<String , Object>map ) {
		User user=(User)session.getAttribute("user");
		address.setUser_id(user.getId());
		
		System.out.println("+++++"+address);
		//添加地址
		boolean success= service.save(address);
		
		return "redirect:/client/address_list";
	}
	
	@PostMapping(value ="/address_update" , produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String,Object> address_update(Object addre) {
		System.out.println("--------");
		Address address=(Address)addre;
		System.out.println(address);
		//确定id在数据库里
		
		Map<String, Object> resp = new HashMap<>();
		int rows = service.update(address);
		if (rows > 0) {
			resp.put("success", true);
			resp.put("rows", rows);
		} else {
			resp.put("success", false);
			resp.put("error", "修改数据ID时异常");
		}
		
		return resp;
	}
	
	@RequestMapping("/address_detele")
	public String address_detele(Integer id) {
		System.out.println("----"+id);
		service.deleteByid(id);
		
		return "redirect:/client/address_list";
	}
	
}
