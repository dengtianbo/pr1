package com.situ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.situ.model.OrderDetails;
@Mapper
public interface OrderDetailsDAO {

	public boolean save(OrderDetails orderDetails);

	//通过uid查询订单详情
	public List<OrderDetails> findByUid(String uid);

	//通过uid删除订单详情
	public void deleteByUid(String uid);

}
