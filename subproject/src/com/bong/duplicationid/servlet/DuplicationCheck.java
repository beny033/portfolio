package com.bong.duplicationid.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bong.member.model.DAO;
import com.bong.member.model.MemberDTO;


@WebServlet("/checkid")
public class DuplicationCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DAO dao;
	
    public DuplicationCheck() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8"); 
		String id = request.getParameter("id");	
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String cpwd = request.getParameter("cpwd");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
	
		if(!pwd.equals(cpwd)) {
			response.sendRedirect("PasswordError.jsp");
			return;
		}
			dao = new DAO();
	
			if(dao.joinCheck(id)) {
				response.sendRedirect("DuplicationError.jsp");
				return;
			} else {
				MemberDTO dto = new MemberDTO();
				dto.setId(id);
				dto.setName(name);
				dto.setPassword(pwd);
				dto.setGender(gender);
				dto.setAddress(address);
				dto.setEmail(email);
				dao.memberInsert(dto);
				response.sendRedirect("../portfolio/joinCheck.htm");
			}
	}

}
