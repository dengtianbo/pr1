package com.situ.model;

/**
 * 订单详情表
 * 
 * @author 浅墨~~
 * @date 2022年1月10日
 */
public class OrderDetails {
	private Integer id;
	private String uid;
	private Order order;
	private Integer goods_id;
	private Goods goods;
	private Integer number;
	
	
	
	public OrderDetails() {
		super();
	}


	public OrderDetails(String uid, Integer goods_id,Integer num) {
		super();
		this.uid = uid;
		this.goods_id = goods_id;
		this.number=num;
	}
	
	
	public OrderDetails(Integer id, String uid, Integer goods_id, Goods goods, Integer number) {
		super();
		this.id = id;
		this.uid = uid;
		this.goods_id = goods_id;
		this.goods = goods;
		this.number = number;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", uid=" + uid + ", order=" + order + ", goods_id=" + goods_id + ", goods="
				+ goods + ", number=" + number + "]";
	}
	
	
	
	
}
