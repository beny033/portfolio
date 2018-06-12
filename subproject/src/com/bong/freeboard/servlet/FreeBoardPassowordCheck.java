package com.bong.freeboard.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bong.member.model.DAO;

@WebServlet("/pwCheck")
public class FreeBoardPassowordCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DAO dao;
	
    public FreeBoardPassowordCheck() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String password = request.getParameter("password");
		
		String url = "http://localhost:9000/portfolio/boardDeletePasswordCheck.htm";
		String referer = request.getHeader("referer");
		String urlSubstr = referer.substring(0, 60);
		
		dao = new DAO();
		String rs_Password = dao.passwordCheck(seq);

		if(password.equals(rs_Password)) {
			if(url.equals(urlSubstr.substring(0, 60))) {
				response.sendRedirect("../portfolio/freeBoardDelete.htm?SEQ="+seq);
				return;
			}
			response.sendRedirect("../portfolio/freeBoardModifyForm.htm?SEQ="+seq+
								  "&WRITER="+writer+"&SUBJECT="+subject+"&CONTENT="+content);
		} else {
			response.sendRedirect("CheckError.jsp");
		}
		
		
	}

}
