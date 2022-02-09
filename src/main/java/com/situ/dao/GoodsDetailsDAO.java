package com.situ.dao;

import org.apache.ibatis.annotations.Mapper;

import com.situ.model.GoodsDetails;
@Mapper
public interface GoodsDetailsDAO {

	//通过id查询商品详情
	public GoodsDetails findByGoodsId(Integer id);

}
