package com.bong.member.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginCheck")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
    public LoginCheckServlet() {
        super();        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","9217");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");		
		String pwd = request.getParameter("pwd");
	
		try {
			pstmt = conn.prepareStatement("SELECT SEQ,NAME,GENDER,ADDRESS,EMAIL,CRE_DATE,MOD_DATE FROM MEMBERS WHERE ID=? AND PASSWORD=?");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("seq", rs.getInt("SEQ"));
				session.setAttribute("id", id);
				session.setAttribute("pwd", pwd);
				session.setAttribute("name", rs.getString("NAME"));
				session.setAttribute("gender", rs.getString("GENDER"));
				session.setAttribute("address", rs.getString("ADDRESS"));
				session.setAttribute("email", rs.getString("EMAIL"));
				session.setAttribute("cre_date", rs.getString("CRE_DATE"));
				session.setAttribute("mod_date", rs.getString("MOD_DATE"));
				session.setMaxInactiveInterval(300);
				response.sendRedirect("index.jsp");
			} else {
				response.sendRedirect("loginError.htm");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{ if(rs != null) rs.close(); }catch(Exception e){}
			try{ if(pstmt != null) pstmt.close(); }catch(Exception e){}
		}
		
	}
}
