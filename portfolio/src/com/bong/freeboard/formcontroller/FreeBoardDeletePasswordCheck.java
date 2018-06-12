package com.bong.freeboard.formcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FreeBoardDeletePasswordCheck implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String seq = request.getParameter("seq");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("SEQ",seq);
		mav.setViewName("free-board/FreeBoardDeletePasswordCheck");
		return mav;
	}

}
