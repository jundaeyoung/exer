package com.airbnb.dto;

public class ReservationDTO {

	private int id;
	private String start_date;
	private String end_date;
	private int personNumber;
	private String user_id;
	private int home_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public int getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(int personNumber) {
		this.personNumber = personNumber;
	}

	public int getHome_id() {
		return home_id;
	}

	public void setHome_id(int home_id) {
		this.home_id = home_id;
	}

	@Override
	public String toString() {
		return "HomeDTO [id=" + id + ", start_date=" + start_date + ", end_date=" + end_date + ", personNumber="
				+ personNumber + ", user_id=" + user_id + ", home_id=" + home_id + "]";
	}

	public ReservationDTO() {
	}
}
