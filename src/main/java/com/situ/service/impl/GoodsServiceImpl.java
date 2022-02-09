package com.situ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.dao.GoodsDAO;
import com.situ.model.Goods;
import com.situ.model.GoodsSearchBean;
import com.situ.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDAO dao;
	
	
	@Override
	public List<Goods> findAllGoods(GoodsSearchBean gsb) {
		
		return dao.findAllGoods(gsb);
	}

	@Override
	public Integer findCount(GoodsSearchBean gsb) {
		// TODO Auto-generated method stub
		return dao.findCount(gsb);
	}

	@Override
	public Goods findUsername(Goods goods) {
		// TODO Auto-generated method stub
		return dao.findGoodsname(goods.getName());
	}

	@Override
	public boolean save(Goods goods) {
		// TODO Auto-generated method stub
		return dao.save(goods);
	}

	@Override
	public Goods findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public boolean update(Goods goods) {
		// TODO Auto-generated method stub
		return dao.update(goods);
	}

	@Override
	public int deleteByIds(Integer[] ids) {
		// TODO Auto-generated method stub
		return dao.deleteByIds(ids) ;
	}

	
	
}
