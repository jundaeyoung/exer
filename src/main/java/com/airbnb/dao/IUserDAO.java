package com.airbnb.dao;

import com.airbnb.dto.UserDTO;

public interface IUserDAO {

	UserDTO select(String id, String password);
	
	UserDTO select(String id);
	
	int insert(String id, String password,String tel, String email);
	
	int update(String id, String password,String tel, String email, String targetId);
	
}
