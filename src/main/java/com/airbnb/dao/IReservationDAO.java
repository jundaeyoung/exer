package com.airbnb.dao;

import com.airbnb.dto.ReservationDTO;

public interface IReservationDAO {

	ReservationDTO select(String user_id);
	int insert(String start_date,String end_date,int personNumber,String user_id,int home_id);
	int delete();
}
