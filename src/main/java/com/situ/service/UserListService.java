package com.situ.service;

import java.util.List;


import com.situ.model.User;
import com.situ.model.UserSearchBean;

/**
 * user在后端的管理(增删改查)
 * @author 浅墨~~
 * @date  2021年12月27日
 */

public interface UserListService {

	public List<User> findAllUser(UserSearchBean usb);

	//总数count
	public Integer findCount(UserSearchBean usb);

	//保存user
	public boolean save(User user);

	//通过ids删除
	public int deleteByIds(Integer[] ids);

	//
	public boolean update(User user);

	//通过id查询user
	public User findById(Integer id);

	//修改默认地址
	public Boolean updateAddress(User user1);

	//个人中心修改信息
	public void updateInfo(User user);

	
}
