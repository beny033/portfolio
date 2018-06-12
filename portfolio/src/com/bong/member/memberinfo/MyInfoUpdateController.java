package com.bong.member.memberinfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bong.dao.MemberDAO;
import com.bong.model.MemberDTO;

public class MyInfoUpdateController implements Controller{

	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int seq = Integer.parseInt(request.getParameter("seq"));
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String passwordCheck = request.getParameter("passwordCheck");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		ModelAndView mav = new ModelAndView();
		if(!password.equals(passwordCheck)) {
			mav.setViewName("members/PasswordError");
			return mav;
		}
		MemberDTO dto = new MemberDTO();
		dto.setSeq(seq);
		dto.setId(id);
		dto.setName(name);
		dto.setPassword(password);
		dto.setAddress(address);
		dto.setEmail(email);
		
		memberDAO.myInfoUpdate(dto);
		HttpSession session = request.getSession();
		session.setAttribute("seq", dto.getSeq());
		session.setAttribute("id", dto.getId());
		session.setAttribute("name", dto.getName());
		session.setAttribute("pwd", dto.getPassword());
		session.setAttribute("address", dto.getAddress());
		session.setAttribute("email", dto.getEmail());
		session.setMaxInactiveInterval(300);
		mav.setViewName("members/MyInfoUpdateResult");
		return mav;
	}

}
