package com.situ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.dao.GoodsClassDAO;
import com.situ.model.GoodsClass;
import com.situ.service.GoodsClassService;

@Service
public class GoodsClassServiceImpl implements GoodsClassService{

	@Autowired
	private GoodsClassDAO dao;
	
	/**
	 * 查询下一级分类
	 */
	@Override
	public List<GoodsClass> findGoodsClass1(Integer id) {
		
		return dao.findGoodsClass1(id);
	}

	
	
	

}
