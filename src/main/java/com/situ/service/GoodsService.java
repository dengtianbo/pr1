package com.situ.service;

import java.util.List;

import com.situ.model.Goods;
import com.situ.model.GoodsSearchBean;

public interface GoodsService {
	
	public List<Goods> findAllGoods(GoodsSearchBean dsb);

	public Integer findCount(GoodsSearchBean gsb);

	public Goods findUsername(Goods goods);

	public boolean save(Goods goods);

	public Goods findById(Integer id);

	public boolean update(Goods goods);

	public int deleteByIds(Integer[] ids);
	

}
