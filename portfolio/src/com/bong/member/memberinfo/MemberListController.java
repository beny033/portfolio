package com.bong.member.memberinfo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bong.dao.MemberDAO;

public class MemberListController implements Controller{

	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		List memberList = memberDAO.memberList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",memberList);
		mav.setViewName("members/MemberList");
		
		return mav;
	}

}
