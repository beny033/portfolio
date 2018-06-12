package com.bong.freeboard.formcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FreeBoardPasswordCheck implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int count = Integer.parseInt(request.getParameter("count"));
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("SEQ",seq);
		mav.addObject("COUNT",count);
		mav.addObject("WRITER",writer);
		mav.addObject("SUBJECT",subject);
		mav.addObject("CONTENT",content);
		mav.setViewName("free-board/FreeBoardPassowordCheck");
		return mav;
	}

}
