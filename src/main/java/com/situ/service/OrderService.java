package com.situ.service;

import java.util.List;

import com.situ.model.Order;

public interface OrderService {

	
	public  List<Order> findByUserId(Integer id);

	public boolean save(Order order);

	public  List<Order> findAll(String uid);

	//发货
	public Boolean updateSendout(String uid);

	
	public Order findByUid(String uid);

	public void deleteByUid(String uid);
	
	
	

}
