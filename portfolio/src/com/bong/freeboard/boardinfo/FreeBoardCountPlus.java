package com.bong.freeboard.boardinfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bong.freeboard.dao.FreeBoardDAO;

public class FreeBoardCountPlus implements Controller{

	private FreeBoardDAO freeBoardDAO;
	
	public void setFreeBoardDAO(FreeBoardDAO freeBoardDAO) {
		this.freeBoardDAO = freeBoardDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int count = Integer.parseInt(request.getParameter("count"));
		String subject = request.getParameter("subject");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String mod = request.getParameter("mod");
		
		freeBoardDAO.countPlus(count, seq);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("SEQ",seq);
		mav.addObject("COUNT",count);
		mav.addObject("SUBJECT",subject);
		mav.addObject("WRITER",writer);
		mav.addObject("CONTENT",content);
		mav.addObject("MOD_DATE",mod);
		mav.setViewName("free-board/FreeBoardView");
		return mav;
	}

}
