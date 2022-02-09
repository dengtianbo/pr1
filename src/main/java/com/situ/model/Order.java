package com.situ.model;
/**
 * 订单表
 * @author 浅墨~~
 * @date  2022年1月10日
 */
public class Order {
	private Integer id;
	
	private String uid;//业务id
	private int user_id;
	private User user;
	//private Integer od_id;//订单详情id
	private String time;
	private Double price;//总价格
	private int order_status;//订单状态
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
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getOrder_status() {
		return order_status;
	}
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
	
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	
	public Order() {
		super();
	}
	public Order(String uid, int user_id, String time, Double price, int order_status) {
		super();
		this.uid = uid;
		this.user_id = user_id;
		this.time = time;
		this.price = price;
		this.order_status = order_status;
	}
	
	
	public Order(Integer id, String uid, int user_id, User user, String time, Double price, int order_status) {
		super();
		this.id = id;
		this.uid = uid;
		this.user_id = user_id;
		this.user = user;
		this.time = time;
		this.price = price;
		this.order_status = order_status;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", uid=" + uid + ", user_id=" + user_id + ", time=" + time
				+ ", price=" + price + ", order_status=" + order_status + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
