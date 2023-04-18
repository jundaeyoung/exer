package com.airbnb.dao;

import java.util.ArrayList;

import com.airbnb.dto.HomeDTO;


public interface IHomeDAO {
	ArrayList<HomeDTO> select();
	
	ArrayList<HomeDTO> search(String search);
	
	int insert(String price, String name, String day, String view, String image);
	
	HomeDTO select(String price, String name, String day, String view, String image);
}
