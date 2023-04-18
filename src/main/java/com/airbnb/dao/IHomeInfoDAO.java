package com.airbnb.dao;

import java.util.ArrayList;

import com.airbnb.dto.HomeInfoDTO;

public interface IHomeInfoDAO {

	HomeInfoDTO select(int home_id);

	int insert(String title, String location, String image1, String image2, String image3, String image4,
			String image5, String host, String info, String sideimage1, String sideInfo1, String sideInfo1_1,
			String sideimage2, String sideInfo2, String sideInfo2_1, String sideimage3, String sideInfo3,
			String sideInfo3_1, int home_id);
}
