package com.situ.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.model.Admin;
import com.situ.model.Order;
import com.situ.model.OrderDetails;
import com.situ.service.AdminInfoService;
import com.situ.service.OrderDetailsService;
import com.situ.service.OrderService;
/**
 * 管理员订单管理
 * @author 浅墨~~
 * @date  2022年1月12日
 */
@Controller
@RequestMapping("/admin")
public class AdminOrderController {
	
	@Autowired
	private OrderService service;
	@Autowired
	private AdminInfoService adminInfoService;
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@RequestMapping("/order_list")
	public String order_list(Map<String, Object>map,Integer pageNo, Integer pageSize,String uid) {
		System.out.println("mmmm");
		if (pageNo == null || pageNo < 1) {
			pageNo = 1;
		}
		if (pageSize == null || pageSize == 0) {
			pageSize = 5;
		}
			System.out.println("uid="+uid);
			map.put("uid", uid);
		PageHelper.startPage(pageNo, pageSize);
		
		List<Order> list = service.findAll(uid);
		
		PageInfo<Order> p =new PageInfo<>(list);
		map.put("list", list);
		map.put("p", p);
		
		return "backstage/order_list";
	}
	
	//发货
	@RequestMapping("/consignment")
	public String consignment(String uid) {
		Boolean b=service.updateSendout(uid);
		if(b) {
			System.out.println("发货成功");
		}
		
		return "redirect:/admin/order_list";
	}
	
	@RequestMapping("/order_detailed")
	public String order_detailed(String uid,Map<String , Object>map,HttpSession session) {
		System.out.println(uid+";;;;;");
		map.put("uid", uid);
		Admin admin= (Admin) session.getAttribute("admin");
		admin = adminInfoService.findAdminById(admin.getId());
		//通过uid查询order
		 Order  order=service.findByUid(uid);
		 System.out.println(order.getUser());
		 map.put("order", order);
		//订单详情
		List<OrderDetails> list=orderDetailsService.findByUid(uid);
		map.put("list", list);
		
		return "backstage/order_detailed";
	}
	
	/**
	 * 删除订单（和订单详情）
	 * @param uid
	 * @return
	 */
	@RequestMapping("order_delete")
	public String order_delete(String uid) {
		// 删除订单
		service.deleteByUid(uid);
		
		//删除订单详情
		orderDetailsService.deleteByUid(uid);
		
		return "redirect:/admin/order_list";
	}
	
	
	

}
