package com.bong.project.projectinfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bong.dao.ProjectDAO;
import com.bong.model.ProjectDTO;

public class CountPlus implements Controller{

	private ProjectDAO projectDAO;
	
	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int count = Integer.parseInt(request.getParameter("count"));
		String subject = request.getParameter("subject");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String status = request.getParameter("status");
		String members = request.getParameter("members");
		String mod = request.getParameter("mod");
		
		ProjectDTO dto = new ProjectDTO();
		dto.setSeq(seq);
		dto.setCount(count);
		projectDAO.countPlus(dto);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("SEQ", seq);
		mav.addObject("COUNT", count);
		mav.addObject("SUBJECT", subject);
		mav.addObject("WRITER", writer);
		mav.addObject("CONTENT", content);
		mav.addObject("MEMBERS", members);
		mav.addObject("STATUS", status);
		mav.addObject("MOD_DATE", mod);
		mav.setViewName("project-board/ProjectView");
		return mav;
	}

}
