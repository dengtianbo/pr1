package com.situ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.situ.model.BuyCarInfo;


@Mapper
public interface BuyCarDAO {

	/**
	 * 显示
	 * @param user_id
	 * @return
	 */
	public List<BuyCarInfo> findAll(int user_id);

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	public int deleteByIds(@Param("ids") Integer[] ids);

	/**
	 * 添加一条
	 * @param buyCarInfo
	 * @return
	 */
	public void save(BuyCarInfo buyCarInfo);

	/**
	 * 查询该用户是否添加过该商品进购物车
	 * @param buyCarInfo
	 * @return
	 */
	public BuyCarInfo findByGoodsid(BuyCarInfo buyCarInfo);

	/**
	 * 购物车有就增加数量
	 * @param buyCarInfo
	 */
	public void updateNumber(BuyCarInfo buyCarInfo);

}
