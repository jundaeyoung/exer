package com.airbnb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.airbnb.dto.UserDTO;
import com.airbnb.utils.DBHelper;

public class UserDAO implements IUserDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public UserDAO() {
		conn = DBHelper.getInstance().getConnection();
	}

	@Override
	public UserDTO select(String id, String password) {
		UserDTO userDTO = null;
		userDTO = new UserDTO();

		String query = " SELECT * FROM user " + " WHERE id = ? AND password= ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				userDTO.setId(rs.getString("id"));
				userDTO.setPassword(rs.getString("password"));
				userDTO.setTel(rs.getString("tel"));
				userDTO.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			System.out.println("cafeDAO select 에러 발생");
			e.printStackTrace();
		}
		return userDTO;

	}

	@Override
	public int insert(String id, String password, String tel, String email) {
		int resultRow = 0;
		String sql = " INSERT INTO user " + " VALUES " + "	(? , ? , ? ,? ) ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, tel);
			pstmt.setString(4, email);
			resultRow = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultRow;
	}

	@Override
	public UserDTO select(String id) {
		UserDTO userDTO = null;
		userDTO = new UserDTO();

		String query = " SELECT * FROM user " + " WHERE id = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				userDTO.setId(rs.getString("id"));
			}
		} catch (SQLException e) {
			System.out.println("cafeDAO select 에러 발생");
			e.printStackTrace();
		}
		return userDTO;
	}

	@Override
	public int update(String id, String password,String tel, String email, String targetId) {
		int resultRow = 0;

		String sql=" UPDATE user "
				+ " SET id = ? , "
				+ "	password= ? , "
				+ "    tel= ? , "
				+ "    email= ?  "
				+ " WHERE id = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, tel);
			pstmt.setString(4, email);
			pstmt.setString(5, targetId);
			resultRow = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("update실행 에러 발생");
			e.printStackTrace();
		}
		return resultRow;
	}

}
