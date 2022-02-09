package com.situ.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.model.Goods;
import com.situ.model.GoodsClass;
import com.situ.service.GoodsClassService;
import com.situ.service.GoodsService;

/**
 * 客户端控制器
 * @author 浅墨~~
 * @date  2021年12月28日
 */
@Controller
@RequestMapping("/client")
public class ClientConsoleController {

	@Autowired
	private GoodsClassService service;
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/index")
	public String index(Map<String, Object>map) {
		
		List<GoodsClass> list = service.findGoodsClass1(0);
		map.put("list1", list);
		List<GoodsClass> list2 = new ArrayList<GoodsClass>() ;
		List<GoodsClass> list3 = new ArrayList<GoodsClass>();
		List<GoodsClass> temp;
		
		for(int i=0;i<list.size();i++) {
			temp=service.findGoodsClass1(list.get(i).getId());
			list2.addAll(temp); 
			for(int j=0;j<temp.size();j++) {
				list3.addAll(service.findGoodsClass1(temp.get(j).getId()));
			}
			
		}
		map.put("list2", list2);
		map.put("list3", list3);
		
		//查询具体商品
		 List<Goods> goodslist = goodsService.findAllGoods(null);
		
		map.put("goodslist", goodslist);
		
		
		return "front-end/index";
	}
	

}
