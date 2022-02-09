package com.situ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.dao.BuyCarDAO;
import com.situ.model.BuyCarInfo;
import com.situ.service.BuyCarService;

@Service
public class BuyCarServiceImpl implements BuyCarService {
	
	@Autowired
	private BuyCarDAO dao;

	@Override
	public List<BuyCarInfo> list(Integer id) {
		
		return dao.findAll(id);
	}

	@Override
	public int deleteByIds(Integer[] ids) {
		// TODO Auto-generated method stub
		return dao.deleteByIds( ids);
	}

	@Override
	public void save(BuyCarInfo buyCarInfo) {
		// TODO Auto-generated method stub
		dao.save( buyCarInfo);
	}

	@Override
	public BuyCarInfo findByGoodsid(BuyCarInfo buyCarInfo) {
		
		return dao.findByGoodsid(buyCarInfo);
	}

	@Override
	public void updateNumber(BuyCarInfo buyCarInfo) {
		// TODO Auto-generated method stub
		dao.updateNumber(buyCarInfo);
		
	}

	
	

	

}
