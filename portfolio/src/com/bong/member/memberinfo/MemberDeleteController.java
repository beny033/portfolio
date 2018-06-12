package com.bong.member.memberinfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bong.dao.MemberDAO;
import com.bong.model.MemberDTO;

public class MemberDeleteController implements Controller{

	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int seq = Integer.parseInt(request.getParameter("seq"));
		MemberDTO dto = new MemberDTO();
		dto.setSeq(seq);
		
		int n = memberDAO.memberDelete(dto);

		if(n>0) {
			int seqCount = memberDAO.seqCount();
			for (int i = 0; i < seqCount; i++) {
				memberDAO.minusSeq(dto);
				seq +=1;
				dto.setSeq(seq);
			}
			dto.setSeq(seqCount);
			memberDAO.updateSeq(dto);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:memberList.htm");
		return mav;
	}

}
