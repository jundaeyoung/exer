package com.airbnb.service;

import com.airbnb.dao.ReservationDAO;
import com.airbnb.dto.ReservationDTO;

public class ReservationService {

	private ReservationDAO reservationDAO;
	private ReservationDTO reservationDTO;

	public ReservationService() {
		reservationDAO = new ReservationDAO();
	}

	public ReservationDTO selectByReservation(String user_id) {
		ReservationDTO resultDTO = reservationDAO.select(user_id);
		return resultDTO;
	}

	public int insertByReservation(String start_date, String end_date, int personNumber, String user_id, int home_id) {
		int resultRow = 0;

		resultRow = reservationDAO.insert(start_date, end_date, personNumber, user_id, home_id);

		return resultRow;
	}

}
