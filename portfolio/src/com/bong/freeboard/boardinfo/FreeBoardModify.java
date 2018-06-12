package com.bong.freeboard.boardinfo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bong.freeboard.dao.FreeBoardDAO;
import com.bong.model.FreeBoardDTO;

public class FreeBoardModify implements Controller {

	private FreeBoardDAO freeBoardDAO;
	
	public void setFreeBoardDAO(FreeBoardDAO freeBoardDAO) {
		this.freeBoardDAO = freeBoardDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int seq = Integer.parseInt(request.getParameter("seq"));
		String writer = request.getParameter("writer");
		String password = request.getParameter("password");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		Date mod_date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
		
	
		FreeBoardDTO dto = new FreeBoardDTO();
		dto.setSeq(seq);
		dto.setWriter(writer);
		dto.setPassword(password);
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setMod_date(mod_date);
		freeBoardDAO.freeBoardModify(dto);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("free-board/ModifySucess");
		return mav;
	}

}
