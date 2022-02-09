package com.situ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.situ.model.Order;
/**
 * 订单表的操作
 * @author 浅墨~~
 * @date  2022年1月10日
 */
@Mapper
public interface OrderDAO {

	//通过user_id查询该用户的订单
	public List<Order> findByUserId(Integer user_id);

	//保存订单
	public boolean save(Order order);

	//查询所有订单
	public List<Order> findAll(String uid);

	//发货
	public Boolean updateSendout(String uid);

	//通过uid查询order
	public Order findByUid(String uid);

	//通过uid删除order
	public void deleteByUid(String uid);

}
