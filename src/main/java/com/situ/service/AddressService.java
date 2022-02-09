package com.situ.service;

import java.util.List;

import com.situ.model.Address;

public interface AddressService {

	public boolean save(Address address);

	public List<Address> findByUserId(Integer id);
	
	public Address findById(Integer id);

	public Integer update(Address addre);

	public boolean deleteByid(Integer id);

}
