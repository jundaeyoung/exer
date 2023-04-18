package com.airbnb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.websocket.Session;

import com.airbnb.dto.HomeDTO;
import com.airbnb.utils.DBHelper;

public class HomeDAO implements IHomeDAO {

	private Connection conn;
	private DBHelper dbHelper;

	public HomeDAO() {
		dbHelper = new DBHelper();
		conn = dbHelper.getConnection();
	}

	@Override
	public ArrayList<HomeDTO> select() {
		ArrayList<HomeDTO> list = new ArrayList<>();

		String strQry = " SELECT * FROM home ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(strQry);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String price = rs.getString("price");
				String name = rs.getString("name");
				String day = rs.getString("day");
				String view = rs.getString("view");
				String image = rs.getString("image");
				HomeDTO dto = new HomeDTO(id, price, name, day, view, image);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public ArrayList<HomeDTO> search(String search) {
		ArrayList<HomeDTO> list = new ArrayList<>();

		String strQry = " SELECT * FROM home WHERE name like ?  ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(strQry);
			pstmt.setString(1, "%" + search + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String price = rs.getString("price");
				String name = rs.getString("name");
				String day = rs.getString("day");
				String view = rs.getString("view");
				String image = rs.getString("image");
				HomeDTO dto = new HomeDTO(id, price, name, day, view, image);
				System.out.println(list);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public int insert(String price, String name, String day, String view, String image) {
		int resultRow = 0;
		int homeUpdateId = 0;
		PreparedStatement pstmt = null;
		String sql = " INSERT INTO home(price,name,day,view,image) " + " VALUES " + "	(?,?,?,?,?) ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, price);
			pstmt.setString(2, name);
			pstmt.setString(3, day);
			pstmt.setString(4, view);
			pstmt.setString(5, image);
			resultRow = pstmt.executeUpdate();
			HomeDTO resultDTO = select(price, name, day, view, image);
			homeUpdateId = resultDTO.getId();

		} catch (SQLException e) {
			System.out.println("여기서 오류");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return homeUpdateId;
	}

	@Override
	public HomeDTO select(String price, String name, String day, String view, String image) {

		String strQry = " SELECT id FROM home " + " WHERE price= ? AND name= ? AND day= ? AND view= ? AND image=? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HomeDTO homeDTO = null;
		homeDTO = new HomeDTO();
		try {
			pstmt = conn.prepareStatement(strQry);
			pstmt.setString(1, price);
			pstmt.setString(2, name);
			pstmt.setString(3, day);
			pstmt.setString(4, view);
			pstmt.setString(5, image);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				homeDTO.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return homeDTO;

	}

}
