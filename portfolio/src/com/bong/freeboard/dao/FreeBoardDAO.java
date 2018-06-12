package com.bong.freeboard.dao;

import java.util.List;

import com.bong.model.FreeBoardDTO;

public interface FreeBoardDAO {
	public List freeBoardList();
	public void freeBoardInsert(FreeBoardDTO dto);
	public void countPlus(int count, int seq);
	public void freeBoardModify(FreeBoardDTO dto);
	public int freeBoardDelete(FreeBoardDTO dto);
	public int totalCount();
	public void updateCount(FreeBoardDTO dto);
	public void setCount(FreeBoardDTO dto);
	public List searchResult(String serchType, String serchText);
}
