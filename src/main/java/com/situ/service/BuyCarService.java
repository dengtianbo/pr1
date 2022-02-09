package com.situ.service;

import java.util.List;

import com.situ.model.BuyCarInfo;

public interface BuyCarService {

	public  List<BuyCarInfo> list(Integer id);

	public int deleteByIds(Integer[] ids);

	public void save(BuyCarInfo buyCarInfo);

	public BuyCarInfo findByGoodsid(BuyCarInfo buyCarInfo);

	public void updateNumber(BuyCarInfo buyCarInfo);

	
	
}
