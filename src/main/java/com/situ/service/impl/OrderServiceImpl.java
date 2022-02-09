package com.situ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.dao.OrderDAO;
import com.situ.model.Order;
import com.situ.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDAO dao;
	
	@Override
	public List<Order> findByUserId(Integer id) {
		return dao.findByUserId(id);
	}

	@Override
	public boolean save(Order order) {
		return dao.save(order);
	}

	@Override
	public List<Order> findAll(String uid) {
		// TODO Auto-generated method stub
		return dao.findAll(uid);
	}

	//发货
	@Override
	public Boolean updateSendout(String uid) {
		
		return dao.updateSendout(uid);
	}

	@Override
	public Order findByUid(String uid) {
		
		return dao.findByUid(uid);
	}

	@Override
	public void deleteByUid(String uid) {
		dao.deleteByUid(uid);
		
	}

	

}
