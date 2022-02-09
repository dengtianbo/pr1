package com.situ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.situ.model.Address;
/**
 * 地址的增删改查
 * @author 浅墨~~
 * @date  2022年1月11日
 */
@Mapper
public interface AddressDAO {

	public  boolean save(Address address);

	public List<Address> findByUserId(Integer id);
	
	public Address findById(Integer id);

	public Integer update(Address addre);

	public boolean deleteByid(Integer id);

}
