package com.bong.dao;


import java.util.List;

import com.bong.model.MemberDTO;

public interface MemberDAO {
	public List memberList();
	public List descList();
	public int memberDelete(MemberDTO dto);
	public void minusSeq(MemberDTO dto);
	public int seqCount();
	public void updateSeq(MemberDTO dto);
	public void memberModify(MemberDTO dto);
	public void myInfoUpdate(MemberDTO dto);
	public List suggestList();
	public void suggestInsert(String id, String content,String time);
}
