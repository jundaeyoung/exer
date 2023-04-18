package com.airbnb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.airbnb.dto.ReservationDTO;
import com.airbnb.dto.UserDTO;
import com.airbnb.utils.DBHelper;

public class ReservationDAO implements IReservationDAO{

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ReservationDAO() {
		conn = DBHelper.getInstance().getConnection();
	}
	
	@Override
	public ReservationDTO select(String user_id) {
		ReservationDTO homeDTO = null;
		homeDTO = new ReservationDTO();
		
		String query = " SELECT * FROM reservation "
				+ " WHERE user_id = ? ";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				homeDTO.setId(rs.getInt("id"));
				homeDTO.setStart_date(rs.getString("start_date"));
				homeDTO.setEnd_date(rs.getString("end_date"));
				homeDTO.setPersonNumber(rs.getInt("personNumber"));
				homeDTO.setUser_id(rs.getString("user_id"));
				homeDTO.setHome_id(rs.getInt("home_id"));
			}
		} catch (SQLException e) {
			System.out.println("select 에러 발생");
			e.printStackTrace();
		}
		return homeDTO;
	}
	@Override
	public int insert(String start_date,String end_date,int personNumber,String user_id,int home_id){
		int resultRow = 0 ; 
		String sql = " INSERT INTO reservation(start_date,end_date,personNumber,user_id,home_id) "
				+ " VALUES "
				+ "	( ? , ? , ? , ? , ? ) ";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, start_date);
			pstmt.setString(2, end_date);
			pstmt.setInt(3, personNumber);
			pstmt.setString(4, user_id);
			pstmt.setInt(5, home_id);
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultRow;
	}

	@Override
	public int delete() {
		return 0;
	}


}
