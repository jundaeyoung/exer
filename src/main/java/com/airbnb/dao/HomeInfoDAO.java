package com.airbnb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.airbnb.dto.HomeDTO;
import com.airbnb.dto.HomeInfoDTO;
import com.airbnb.utils.DBHelper;

public class HomeInfoDAO implements IHomeInfoDAO {

	private Connection conn;
	private DBHelper dbHelper;
	
	
	public HomeInfoDAO() {
		dbHelper = new DBHelper();
		conn= dbHelper.getConnection();
	}

	@Override
	public HomeInfoDTO select(int home_id) {
		HomeInfoDTO homeInfoDTO = null;
		homeInfoDTO = new HomeInfoDTO(); 
		
		String strQry = " SELECT * FROM homeinfo  "
				+ " WHERE home_id =  ?  ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(strQry);
			pstmt.setInt(1, home_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				homeInfoDTO.setTitle(rs.getString("title"));
				homeInfoDTO.setLocation(rs.getString("location"));
				homeInfoDTO.setImage1(rs.getString("image1"));
				homeInfoDTO.setImage2(rs.getString("image2"));
				homeInfoDTO.setImage3(rs.getString("image3"));
				homeInfoDTO.setImage4(rs.getString("image4"));
				homeInfoDTO.setImage5(rs.getString("image5"));
				homeInfoDTO.setHost(rs.getString("host"));
				homeInfoDTO.setInfo(rs.getString("info"));
				homeInfoDTO.setSideimage1(rs.getString("sideimage1"));
				homeInfoDTO.setSideInfo1(rs.getString("sideInfo1"));
				homeInfoDTO.setSideInfo1_1(rs.getString("sideInfo1_1"));
				homeInfoDTO.setSideimage2(rs.getString("sideimage2"));
				homeInfoDTO.setSideInfo2(rs.getString("sideInfo2"));
				homeInfoDTO.setSideInfo2_1(rs.getString("sideInfo2_1"));
				homeInfoDTO.setSideimage3(rs.getString("sideimage3"));
				homeInfoDTO.setSideInfo3(rs.getString("sideInfo3"));
				homeInfoDTO.setSideInfo3_1(rs.getString("sideInfo3_1"));
			}
		} catch (SQLException e) {
			System.out.println("homeinfo select 에러 발생");
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return homeInfoDTO;
	}

	@Override
	public int insert(String title, String location, String image1, String image2, String image3, String image4,
			String image5, String host, String info, String sideimage1, String sideInfo1, String sideInfo1_1,
			String sideimage2, String sideInfo2, String sideInfo2_1, String sideimage3, String sideInfo3,
			String sideInfo3_1, int home_id) {
		int resultRow = 0;
		String sql =" insert into homeinfo "
				+ " values "
				+ "	(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, location);
			pstmt.setString(3, image1);
			pstmt.setString(4, image2);
			pstmt.setString(5, image3);
			pstmt.setString(6, image4);
			pstmt.setString(7, image5);
			pstmt.setString(8, host);
			pstmt.setString(9, info);
			pstmt.setString(10, sideimage1);
			pstmt.setString(11, sideInfo1);
			pstmt.setString(12, sideInfo1_1);
			pstmt.setString(13, sideimage2);
			pstmt.setString(14, sideInfo2);
			pstmt.setString(15, sideInfo2_1);
			pstmt.setString(16, sideimage3);
			pstmt.setString(17, sideInfo3);
			pstmt.setString(18, sideInfo3_1);
			pstmt.setInt(19, home_id);
			resultRow = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultRow;
	}

}
