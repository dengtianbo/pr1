package com.situ.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.model.Goods;
import com.situ.model.GoodsDetails;
import com.situ.service.GoodsDetailsService;
import com.situ.service.GoodsService;
/**
 * 商品详情
 * @author 浅墨~~
 * @date  2022年1月14日
 */
@Controller
@RequestMapping("/client")
public class ClientGoodsDetailsController {

	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private GoodsDetailsService goodsDetailsService;
	
	@RequestMapping("/goods")
	public String goods(Integer id,Map<String, Object>map) {
		
		Goods goods = goodsService.findById(id);
		System.out.println("商品详情"+id);
		
		map.put("goods", goods);
		
		GoodsDetails goodsDetails=goodsDetailsService.findByGoodsId(id);
		
		map.put("goodsDetails", goodsDetails);
		//System.out.println(goodsDetails.getPictures()+"....");
		
		return "front-end/goods";
	}
}
