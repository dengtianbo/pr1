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

import com.situ.model.BuyCarInfo;
import com.situ.model.User;
import com.situ.service.BuyCarService;

@Controller
@RequestMapping("/client")
public class BuyCarController {

	@Autowired
	private BuyCarService service;

	/**
	 * 显示购物车
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping("/buycar")
	public String list(HttpSession session, Map<String, Object> map) {
		User user = (User) session.getAttribute("user");
		List<BuyCarInfo> list = service.list(user.getId());
		for (BuyCarInfo buyCarInfo : list) {
			System.out.println(buyCarInfo);
			System.out.println(buyCarInfo.getGoods());
		}
		map.put("list", list);
		return "front-end/buyCar";
	}
	
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	
	@PostMapping(value = "/buycar_delete", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String, Object> delete(Integer[] ids) {
		System.out.println("+++++++");
		for (Integer integer : ids) {
			System.out.println(integer);
		}
		System.out.println("+++++++");
		Map<String, Object> resp = new HashMap<>();
		Integer rows = service.deleteByIds(ids);
		if (rows > 0) {
			resp.put("success", true);
			resp.put("rows", rows);
		} else {
			resp.put("success", false);
			resp.put("error", "删除数据时异常");
		}
		return resp;
	}
	
	/**
	 * 添加一条记录
	 */
	@RequestMapping(value= "/buycar_add" , produces = "application/json;charset=utf-8")
	@ResponseBody
	public void buycar_add(HttpSession session, Integer id,Integer number) {
		User user = (User) session.getAttribute("user");
		System.out.println(id+"___"+number);
		BuyCarInfo buyCarInfo =new BuyCarInfo();
		buyCarInfo.setUser_id(user.getId());
		buyCarInfo.setGoods_id(id);
		buyCarInfo.setNumber(number);
		//判断该用户添加的商品是否存在
		BuyCarInfo buy=service.findByGoodsid(buyCarInfo);
		if(buy!=null) {
			//购物车有就增加数量
			service.updateNumber(buyCarInfo);
			System.out.println("111");
		}else {
			//添加一条记录
			service.save(buyCarInfo);
			System.out.println("2222");
		}
	}
	
	
}
