package com.bong.project.projectinfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bong.dao.ProjectDAO;
import com.bong.model.ProjectDTO;

public class ProjectDeleteController implements Controller{

	private ProjectDAO projectDAO;
	
	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		ProjectDTO dto = new ProjectDTO();
		dto.setSeq(seq);
		
		int n = projectDAO.projectDelete(dto);
	
		if(n>0) {
			int seqCount = projectDAO.seqCount();
			for (int i = 0; i < seqCount; i++) {
				projectDAO.updateSeq(dto);
				seq += 1;
				dto.setSeq(seq);
			}
			dto.setSeq(seqCount);
			projectDAO.setSeq(dto);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:projectList.htm");
		return mav;
	}

}
