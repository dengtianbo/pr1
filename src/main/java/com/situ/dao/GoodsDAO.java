package com.situ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.situ.model.Goods;
import com.situ.model.GoodsSearchBean;

@Mapper
public interface GoodsDAO {

	/**
	 * 查询满总所有goods
	 * @param gsb
	 * @return
	 */
	public  List<Goods> findAllGoods(GoodsSearchBean gsb);

	/**
	 * 通过name查询是否有相同的goods
	 * @param name
	 * @return
	 */
	public Goods findGoodsname(String name);

	/**
	 * 通过id查询goods
	 * @param id
	 * @return
	 */
	public Goods findById(Integer id);
	
	/**
	 * 查询满总所有goods的个数
	 * @param gsb
	 * @return
	 */
	public Integer findCount(GoodsSearchBean gsb);

	
	/**
	 * 保存一条记录
	 * @param goods
	 * @return
	 */
	public boolean save(Goods goods);

	public boolean update(Goods goods);

	public int deleteByIds(@Param("ids")  Integer[] ids);

	
	
	
	
	
	

}
