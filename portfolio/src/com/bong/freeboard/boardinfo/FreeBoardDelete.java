package com.bong.freeboard.boardinfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bong.freeboard.dao.FreeBoardDAO;
import com.bong.model.FreeBoardDTO;

public class FreeBoardDelete implements Controller{

	private FreeBoardDAO freeBoardDAO;
	
	public void setFreeBoardDAO(FreeBoardDAO freeBoardDAO) {
		this.freeBoardDAO = freeBoardDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int seq = Integer.parseInt(request.getParameter("SEQ"));
		
		FreeBoardDTO dto = new FreeBoardDTO();
		dto.setSeq(seq);
		
		int n = freeBoardDAO.freeBoardDelete(dto);
		
		if(n > 0) {
			int totalCount = freeBoardDAO.totalCount();
			for(int i = 0; i < totalCount; i++) { 
				freeBoardDAO.updateCount(dto);
				seq += 1;
				dto.setSeq(seq);
			}
				dto.setSeq(totalCount);
				freeBoardDAO.setCount(dto);
		} 

		ModelAndView mav = new ModelAndView();
		mav.setViewName("free-board/DeleteSucess");
		return mav;
	}
}
