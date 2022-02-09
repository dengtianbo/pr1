package com.situ.model;

public class Address {
	
	private Integer id;
	private Integer user_id;
	
	private String name;
	private String address;
	
	private String details_address;
	private String phone;
	private String email;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetails_address() {
		return details_address;
	}
	public void setDetails_address(String details_address) {
		this.details_address = details_address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", user_id=" + user_id + ", name=" + name + ", address=" + address
				+ ", details_address=" + details_address + ", phone=" + phone + ", email=" + email + "]";
	}
	
	
	
	

}
