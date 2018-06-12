package com.bong.freeboard.boardinfo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bong.freeboard.dao.FreeBoardDAO;
import com.bong.model.FreeBoardDTO;

public class FreeBoardWrite implements Controller{

	private FreeBoardDAO freeBoardDAO;
	
	public void setFreeBoardDAO(FreeBoardDAO freeBoardDAO) {
		this.freeBoardDAO = freeBoardDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String writer = request.getParameter("writer");
		String password = request.getParameter("password");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		Date cre_date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
		
		ModelAndView mav = new ModelAndView();
		if(password.length() < 4) {
			mav.setViewName("free-board/PasswordLengthError");
			return mav;
		}
		
		FreeBoardDTO dto = new FreeBoardDTO();
		dto.setWriter(writer);
		dto.setPassword(password);
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setCre_date(cre_date);
		
		freeBoardDAO.freeBoardInsert(dto);
		
		mav.setViewName("redirect:freeBoardList.htm");
		return mav;
	}

}
