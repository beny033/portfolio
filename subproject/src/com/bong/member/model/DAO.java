package com.bong.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public DAO() {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","9217");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean joinCheck(String id) {
		try {
			pstmt = conn.prepareStatement("SELECT ID FROM MEMBERS WHERE ID=?");
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{ if(rs != null) rs.close(); }catch(Exception e){}
			try{ if(pstmt != null) pstmt.close(); }catch(Exception e){}
		}
		
		return false;
	}
	
	public void memberInsert(MemberDTO dto) {
		String sql = "INSERT INTO MEMBERS(ID,NAME,PASSWORD,GENDER,ADDRESS,EMAIL,CRE_DATE,MOD_DATE)" + 
					 " VALUES(?,?,?,?,?,?,NOW(),NOW())";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPassword());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getAddress());
			pstmt.setString(6, dto.getEmail());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{ if(pstmt != null) pstmt.close(); }catch(Exception e){}
		}
	}
	
	public String passwordCheck(int seq) {
		String sql = "SELECT PASSWORD FROM FREE_BOARD WHERE SEQ = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String rs_Password = rs.getString("PASSWORD");
				return rs_Password;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{ if(rs != null) rs.close(); }catch(Exception e){}
			try{ if(pstmt != null) pstmt.close(); }catch(Exception e){}
		}
		return null;
	}

	
	
}
