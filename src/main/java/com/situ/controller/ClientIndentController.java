package com.situ.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.model.BuyCarInfo;
import com.situ.model.Goods;
import com.situ.model.Order;
import com.situ.model.OrderDetails;
import com.situ.model.User;
import com.situ.service.BuyCarService;
import com.situ.service.GoodsService;
import com.situ.service.OrderDetailsService;
import com.situ.service.OrderService;
import com.situ.service.UserListService;
import com.situ.utils.DateUtil;
import com.situ.utils.UidUtil;

@Controller
@RequestMapping("/client")
public class ClientIndentController {
	//商品id数组
	private Integer [] ids;
	//商品id对应的数量
	private Integer [] nums;
	
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private BuyCarService buyCarService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	@Autowired
	private UserListService userListService;
	
	
	
	@PostMapping(value = "/indent", produces = "application/json;charset=utf-8")
	@ResponseBody
	//@RequestMapping("/indent")
	public String getIds(Integer[] ids,Integer [] nums){
		System.out.println(nums.length);
		if(ids==null||ids.length==0) {
			System.out.println("nuLL");
		}else {
			System.out.println("不为null");
			for (Integer integer : ids) {
				System.out.println(integer);
			}
			this.ids=ids;
			this.nums=nums;
			
		}
		
		return "front-end/indent";
	}
	
	/**
	 * 预订单
	 * @param price
	 * @param map
	 * @param session
	 * @return
	 */
	@GetMapping("/indent")
	public String list(Double price,Map<String, Object>map,HttpSession session) {
		User user = (User) session.getAttribute("user");
		user=userListService.findById(user.getId());
		map.put("user", user);
		List<BuyCarInfo> buyCarInfos = buyCarService.list(user.getId());
		map.put("buy", buyCarInfos);
		List<Goods>list =new ArrayList<Goods>();
		
		System.out.println("+++++"+price);
		map.put("ids", ids);
		for (Integer id : ids) {
		 	Goods goods = goodsService.findById(id);
			list.add(goods);
			System.out.println(goods);
			System.out.println(id);
		}
		map.put("list", list);
		map.put("price", price);
		//预订单
		
		
		
		return "front-end/indent";
	}
	
	
	/**
	 * 添加订单
	 * @param session
	 * @param price
	 * @param map
	 * @return
	 */
	@RequestMapping("/order_add")
	public String order_add(HttpSession session,Double price,Map<String, Object>map) {
		User user=(User) session.getAttribute("user");
		
		System.out.println("++++++++"+ids.length);
		System.out.println(price);
		map.put("price", price);
		//添加到订单和订单详情表里
		String uid=UidUtil.range();
		map.put("uid", uid);
		String date=DateUtil.dateString(new Date());
		
		Order order=new Order(uid,user.getId(),date, price,2);
		//添加到订单
		boolean success = orderService.save(order);
		
		//添加到订单详情表里
		OrderDetails orderDetails;
		
		for(int i=0;i<ids.length;i++) {
			
			orderDetails=new OrderDetails(uid,ids[i],nums[i]);
			orderDetailsService.save(orderDetails);
			
			
		}
		
		 return "front-end/indent_success";
	}
	
	
}
