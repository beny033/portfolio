package com.bong.member.memberinfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bong.dao.MemberDAO;
import com.bong.model.MemberDTO;

public class MemberModifyController implements Controller{

	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int seq = Integer.parseInt(request.getParameter("seq"));
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		MemberDTO dto = new MemberDTO();
		dto.setSeq(seq);
		dto.setId(id);
		dto.setName(name);
		dto.setPassword(password);
		dto.setGender(gender);
		dto.setAddress(address);
		dto.setEmail(email);
		
		memberDAO.memberModify(dto);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:memberList.htm");
		return mav;
	}

}
