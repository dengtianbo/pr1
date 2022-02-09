package com.situ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.dao.AddressDAO;
import com.situ.model.Address;
import com.situ.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDAO dao;
	@Override
	public boolean save(Address address) {
		
		return dao.save(address);
	}
	@Override
	public List<Address> findByUserId(Integer id) {
		
		return dao.findByUserId( id);
	}
	@Override
	public Integer update(Address addre) {
	
		return dao.update(addre);
	}
	@Override
	public boolean deleteByid(Integer id) {
		
		return dao.deleteByid( id);
	}
	@Override
	public Address findById(Integer id) {
		
		return dao.findById(id);
	}

}
