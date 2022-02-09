package com.situ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.situ.model.GoodsClass;

@Mapper
public interface GoodsClassDAO {

	public	List<GoodsClass> findGoodsClass1(Integer pid);

	
	
	
}
