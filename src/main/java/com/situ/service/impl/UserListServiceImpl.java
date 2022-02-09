package com.situ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.situ.dao.UserListDAO;
import com.situ.model.User;
import com.situ.model.UserSearchBean;
import com.situ.service.UserListService;

@Service
public   class UserListServiceImpl implements UserListService {

	@Autowired
	private UserListDAO dao;
	/**
	 * 显示user表
	 */
	@Override
	public List<User> findAllUser(UserSearchBean usb) {
		
		return dao.findAllUser(usb);
	}
	//总数count
	@Override
	public Integer findCount(UserSearchBean usb) {
		
		return dao.findCount(usb);
	}
	
	//添加一条user
	@Override
	public boolean save(User user) {
		String encrypt = user.getUsername() + "{" + user.getPassword() + "}";
		String md5Str = DigestUtils.md5DigestAsHex(encrypt.getBytes());
		user.setPassword(md5Str);
		
		return dao.saveUser(user);
	}
	
	//通过ids删除
	@Override
	public int deleteByIds(Integer[] ids) {
		
		return dao.deleteByIds(ids);
	}
	
	
	//修改
	@Override
	public boolean update(User user) {
		String encrypt = user.getUsername() + "{" + user.getPassword() + "}";
		String md5Str = DigestUtils.md5DigestAsHex(encrypt.getBytes());
		user.setPassword(md5Str);
		return dao.update(user);
	}
	
	//通过id查询user
	@Override
	public User findById(Integer id) {
		
		return dao.findById(id);
	}
	@Override
	public Boolean updateAddress(User user1) {
		
		return dao.updateAddress(user1);
	}
	//个人中心修改信息
	@Override
	public void updateInfo(User user) {
		
		dao.updateInfo( user);
	}

	

}
