package com.bong.freeboard.boardinfo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bong.freeboard.dao.FreeBoardDAO;

public class FreeBoardSearchResult implements Controller {

	private FreeBoardDAO freeBoardDAO;
	
	public void setFreeBoardDAO(FreeBoardDAO freeBoardDAO) {
		this.freeBoardDAO = freeBoardDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String searchType = request.getParameter("searchType");
		String searchText = request.getParameter("searchText");
		
		List list = freeBoardDAO.searchResult(searchType, searchText);
		ModelAndView mav = new ModelAndView();
		if(list == null) {
			mav.setViewName("free-board/SearchFail");
			return mav;
		} else {
			mav.addObject("list",list);
			mav.setViewName("free-board/SearchResult");
			return mav;
		}
	}

}
