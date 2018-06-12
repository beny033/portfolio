package com.bong.member.formcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MemberDeleteFormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse arg1) throws Exception {
		String seq = request.getParameter("seq");
		ModelAndView mav = new ModelAndView();
		mav.addObject("seq",seq);
		mav.setViewName("members/MemberDelete");
		return mav;
	}

}
