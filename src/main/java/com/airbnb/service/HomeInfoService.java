package com.airbnb.service;

import com.airbnb.dao.HomeInfoDAO;
import com.airbnb.dto.HomeInfoDTO;

public class HomeInfoService {

	private HomeInfoDAO homeInfoDAO;

	public HomeInfoService() {
		homeInfoDAO = new HomeInfoDAO();
	}

	public HomeInfoDTO homeInfoSelect(int home_id) {
		HomeInfoDTO resultDTO = homeInfoDAO.select(home_id);
		return resultDTO;
	}

}
