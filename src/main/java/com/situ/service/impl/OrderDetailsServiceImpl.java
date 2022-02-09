package com.situ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.dao.OrderDetailsDAO;
import com.situ.model.OrderDetails;
import com.situ.service.OrderDetailsService;
/**
 * 订单详情操作
 * @author 浅墨~~
 * @date  2022年1月10日
 */
@Service
public class OrderDetailsServiceImpl  implements OrderDetailsService{

	@Autowired
	private OrderDetailsDAO dao;
	
	@Override
	public boolean save(OrderDetails orderDetails) {
		
		return dao.save(orderDetails);
	}

	@Override
	public List<OrderDetails> findByUid(String uid) {
		// TODO Auto-generated method stub
		return dao.findByUid(uid);
	}

	@Override
	public void deleteByUid(String uid) {
		// TODO Auto-generated method stub
		dao.deleteByUid(uid);
	}

}
