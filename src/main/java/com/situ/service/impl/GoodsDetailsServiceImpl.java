package com.situ.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.dao.GoodsDetailsDAO;
import com.situ.model.GoodsDetails;
import com.situ.service.GoodsDetailsService;
@Service
public class GoodsDetailsServiceImpl implements GoodsDetailsService{

	@Autowired
	private GoodsDetailsDAO dao;
	
	@Override
	public GoodsDetails findByGoodsId(Integer id) {
		return dao.findByGoodsId(id);
	}

}
