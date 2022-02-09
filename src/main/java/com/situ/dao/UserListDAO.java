package com.situ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.situ.model.User;
import com.situ.model.UserSearchBean;

/**
 * user在后端的管理(增删改查)
 * 
 * @author 浅墨~~
 * @date 2021年12月27日
 */
@Mapper
public interface UserListDAO {

	/**
	 * user所有list
	 * @param usb
	 * @return
	 */
	
	public List<User> findAllUser(UserSearchBean usb);

	/**
	 * user总数
	 * @param usb
	 * @return
	 */
	public Integer findCount(UserSearchBean usb);

	/**
	 * 添加一条user
	 * @param user
	 * @return
	 */
	public boolean saveUser(User user);

	/**
	 * 通过ids删除
	 * @param ids
	 * @return
	 */
	public int deleteByIds(@Param("ids") Integer[] ids);

	/**
	 * 修改user
	 * @param user
	 * @return
	 */
	public boolean update(User user);

	/**
	 * 通过id查询user
	 * @param id
	 * @return
	 */
	public User findById(Integer id);

	/**
	 * 通过id修改地址
	 * @param user1
	 * @return
	 */
	public Boolean updateAddress(User user1);

	/**
	 * 个人中心修改信息
	 * @param user
	 */
	public void updateInfo(User user);

}
