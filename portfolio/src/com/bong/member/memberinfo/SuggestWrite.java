package com.bong.member.memberinfo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bong.dao.MemberDAO;

public class SuggestWrite implements Controller{

	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		Calendar cal = Calendar.getInstance(); 
		Date date = cal.getTime();
		String time = new SimpleDateFormat("HH:mm:ss").format(date);

		memberDAO.suggestInsert(id, content,time);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:suggestList.htm");
		return mav;
	}

}
