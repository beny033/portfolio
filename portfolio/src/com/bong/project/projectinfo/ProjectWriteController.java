package com.bong.project.projectinfo;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bong.dao.ProjectDAO;
import com.bong.model.ProjectDTO;

public class ProjectWriteController implements Controller{

	private ProjectDAO projectDAO;
	
	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String members = request.getParameter("members");
		String content = request.getParameter("content");
		String status = request.getParameter("status");
		Date cre_date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
		
		ProjectDTO dto = new ProjectDTO();
		dto.setWriter(writer);
		dto.setSubject(subject);
		dto.setMembers(members);
		dto.setContent(content);
		dto.setStatus(status);
		dto.setCre_date(cre_date);
		this.projectDAO.projectInsert(dto);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:projectList.htm");
		
		return mav;
	}

}
