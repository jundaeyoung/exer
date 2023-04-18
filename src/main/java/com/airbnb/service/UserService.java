package com.airbnb.service;

import com.airbnb.dao.UserDAO;
import com.airbnb.dto.UserDTO;

public class UserService {

	private UserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}

	public UserDTO selectByUserId(String id) {
		UserDTO resultDTO = userDAO.select(id);
		return resultDTO;
	}

	public UserDTO selectByUserId(String id, String password) {
		UserDTO resultDTO = userDAO.select(id, password);
		return resultDTO;
	}

	public int insertByUser(String id, String password, String tel, String email) {
		int resultRow = 0;

		UserDTO userDTO = userDAO.select(id);

		if (userDTO != null) {
			String userWriterId = userDTO.getId();
		if(id.equals(userWriterId)) {
			System.out.println("해당 아이디가 존재합니다.");
		}else {
			resultRow = userDAO.insert(id, password, tel, email);
		}
		}
		return resultRow;

	}

	public int updateByUser(String id, String password, String tel, String email, String targetId) {
		int resultRow = 0;
		resultRow = userDAO.update(id, password, tel, email, targetId);
		return resultRow;
	}

}
