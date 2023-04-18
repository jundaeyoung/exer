package com.airbnb.service;

import com.airbnb.dao.HomeDAO;
import com.airbnb.dao.HomeInfoDAO;

public class HomeInfoUploadService {

	private HomeInfoDAO homeInfoDAO;
	
	public HomeInfoUploadService() {
		homeInfoDAO = new HomeInfoDAO();
	}
	public int insertByHomeInfo(String title, String location, String image1, String image2, String image3, String image4,
			String image5, String host, String info, String sideimage1, String sideInfo1, String sideInfo1_1,
			String sideimage2, String sideInfo2, String sideInfo2_1, String sideimage3, String sideInfo3,
			String sideInfo3_1, int home_id) {
	int resultRow =0;
	
	resultRow = homeInfoDAO.insert(title, location, image1, image2, image3, image4, image5, host, info, sideimage1, sideInfo1, sideInfo1_1, sideimage2, sideInfo2, sideInfo2_1, sideimage3, sideInfo3, sideInfo3_1, home_id);
	return resultRow;
	}
}
