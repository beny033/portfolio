package com.bong.project.projectinfo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bong.dao.ProjectDAO;
import com.bong.model.ProjectDTO;

public class ProjectModifyController implements Controller{

	private ProjectDAO projectDAO;
	
	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		int seq = Integer.parseInt((String)session.getAttribute("seq"));
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String members = request.getParameter("members");
		String content = request.getParameter("content");
		String status = request.getParameter("status");
		Date mod_date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
		
		ProjectDTO dto = new ProjectDTO();
		dto.setSeq(seq);
		dto.setWriter(writer);
		dto.setSubject(subject);
		dto.setMembers(members);
		dto.setContent(content);
		dto.setStatus(status);
		dto.setMod_date(mod_date);
		this.projectDAO.projectUpdate(dto);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("project-board/UpdateSucess");
		return mav;
	}

}
