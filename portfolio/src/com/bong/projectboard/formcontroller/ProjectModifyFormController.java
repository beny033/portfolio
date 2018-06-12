package com.bong.projectboard.formcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ProjectModifyFormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String seq = request.getParameter("seq");
		String subject = request.getParameter("subject");
		String members = request.getParameter("members");
		String content = request.getParameter("content");
		HttpSession session = request.getSession();
		session.setAttribute("seq", seq);

		ModelAndView mav = new ModelAndView();
		mav.addObject("SUBJECT",subject);
		mav.addObject("MEMBERS",members);
		mav.addObject("CONTENT",content);
		mav.setViewName("project-board/ProjectModifyForm");
		return mav;
	}

}
