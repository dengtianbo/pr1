package com.situ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.situ.model.Picture;
@Mapper
public interface PictureDAO {
	
	public List<Picture> findByPid(Integer pid);

}
