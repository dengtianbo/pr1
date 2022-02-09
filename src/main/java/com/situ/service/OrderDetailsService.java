package com.situ.service;

import java.util.List;

import com.situ.model.OrderDetails;

public interface OrderDetailsService {

	public boolean save(OrderDetails orderDetails);

	
	public List<OrderDetails> findByUid(String uid);


	public void deleteByUid(String uid);

}
