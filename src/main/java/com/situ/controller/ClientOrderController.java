package com.situ.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.model.Order;
import com.situ.model.OrderDetails;
import com.situ.model.User;
import com.situ.service.OrderDetailsService;
import com.situ.service.OrderService;


@Controller
@RequestMapping("/client")
public class ClientOrderController {
	
	@Autowired
	private OrderService service;
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@RequestMapping("/order_list")
	public String order_list(HttpSession session,Map<String, Object>map){
		User user=(User)session.getAttribute("user");
		
		List<Order> orders=service.findByUserId(user.getId());
		
		map.put("orders", orders);
		
		return "front-end/member_Order";
	}
	
	/**
	 * 订单详情
	 * @param uid
	 * @param map
	 * @param session
	 * @return
	 */
	@RequestMapping("/order_detailed")
	public String order_detailed(String uid,Map<String , Object>map,HttpSession session) {
		System.out.println(uid+";;;;;");
		map.put("uid", uid);
			
		//通过uid查询order
		 Order  order=service.findByUid(uid);
		 System.out.println(order.getUser());
		 map.put("order", order);
		//订单详情
		List<OrderDetails> list=orderDetailsService.findByUid(uid);
		map.put("list", list);
		System.out.println("11111");
		System.out.println(list.size());
		
		return "backstage/order_detailed";
	}
	
	
	
	
	/*
	 * 在ClientIndentController里
	 * @RequestMapping("/order_add") public String order_add(Integer []
	 * ids,HttpSession session,Double price) { User user=(User)
	 * session.getAttribute("user");
	 * 
	 * System.out.println("++++++++"+ids.length); System.out.println(price);
	 * //添加到订单和订单详情表里 String uid=UidUtil.range(); String
	 * date=DateUtil.dateString(new Date());
	 * 
	 * Order order=new Order(uid,user.getId(),date, price,2);
	 * 
	 * boolean success = service.save(order);
	 * 
	 * 
	 * return "client/indent_success"; }
	 */
	
	
	
	

}
