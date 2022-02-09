package com.situ.model;

/**
 * 商品分类
 * 
 * @author 浅墨~~
 * @date 2021年12月28日
 */
public class GoodsClass {
	@Override
	public String toString() {
		return "GoodsClass [id=" + id + ", name=" + name + ", pid=" + pid + "]";
	}

	private Integer id;
	private String name;
	private Integer pid;
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	

}
