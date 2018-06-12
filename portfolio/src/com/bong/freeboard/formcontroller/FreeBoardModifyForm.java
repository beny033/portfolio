package com.bong.freeboard.formcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FreeBoardModifyForm implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int seq = Integer.parseInt(request.getParameter("SEQ"));
		String writer = request.getParameter("WRITER");
		String subject = request.getParameter("SUBJECT");
		String content = request.getParameter("CONTENT");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("SEQ",seq);
		mav.addObject("WRITER",writer);
		mav.addObject("SUBJECT",subject);
		mav.addObject("CONTENT",content);
		mav.setViewName("free-board/FreeBoardModifyForm");
		return mav;
	}

}
