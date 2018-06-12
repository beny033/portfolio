package com.bong.freeboard.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bong.model.FreeBoardDTO;

public class FreeBoardDAOImpl implements FreeBoardDAO{

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List freeBoardList() {
		String sql = "SELECT * FROM FREE_BOARD";
		return this.jdbcTemplate.queryForList(sql);
	}

	@Override
	public void freeBoardInsert(FreeBoardDTO dto) {
		String sql = "INSERT INTO FREE_BOARD(SUBJECT,PASSWORD,WRITER,CONTENT,CRE_DATE,MOD_DATE) VALUES(?,?,?,?,?,NOW())";
		Object[] obj = {dto.getSubject(), dto.getPassword(), dto.getWriter(), dto.getContent(), dto.getCre_date()};
		this.jdbcTemplate.update(sql,obj);
	}
	
	@Override
	public void countPlus(int count, int seq) {
		String sql = "UPDATE FREE_BOARD SET COUNT = ? WHERE SEQ = ?";
		Object[] obj = {count + 1, seq};
		this.jdbcTemplate.update(sql,obj);
	}
	
	@Override
	public void freeBoardModify(FreeBoardDTO dto) {
		String sql = "UPDATE FREE_BOARD SET WRITER=?, PASSWORD=?, SUBJECT=?, CONTENT=?, MOD_DATE=? WHERE SEQ=?";
		Object[] obj = {dto.getWriter(), dto.getPassword(), dto.getSubject(), dto.getContent(), dto.getMod_date(), dto.getSeq()};
		this.jdbcTemplate.update(sql,obj);
	}
	
	@Override
	public int freeBoardDelete(FreeBoardDTO dto) {
		String sql = "DELETE FROM FREE_BOARD WHERE SEQ=?";
		Object obj = dto.getSeq();
		return this.jdbcTemplate.update(sql,obj);
	}
	
	@Override
	public int totalCount() {
		String sql = "SELECT COUNT(SEQ) FROM FREE_BOARD";
		return this.jdbcTemplate.queryForInt(sql);
	}

	@Override
	public void updateCount(FreeBoardDTO dto) {
		String sql = "UPDATE FREE_BOARD SET SEQ = ? WHERE SEQ = ?";
		Object[] obj = {dto.getSeq(), dto.getSeq()+1};
		this.jdbcTemplate.update(sql,obj);
	}

	@Override
	public void setCount(FreeBoardDTO dto) {
		String sql = "ALTER TABLE FREE_BOARD AUTO_INCREMENT = ?";
		Object obj = dto.getSeq();
		this.jdbcTemplate.update(sql,obj);
	}

	@Override
	public List searchResult(String searchType, String searchText) {
		if(searchType.equals("writer")) {
			String sql = "SELECT * FROM FREE_BOARD WHERE WRITER = ?";
			Object obj = searchText;
			return this.jdbcTemplate.queryForList(sql, obj);
		} else if(searchType.equals("subject")) {
			String sql = "SELECT * FROM FREE_BOARD WHERE SUBJECT LIKE CONCAT( '%', ? , '%')";
			Object obj = searchText;
			return this.jdbcTemplate.queryForList(sql, obj);
		} else if(searchType.equals("content")) {
			String sql = "SELECT * FROM FREE_BOARD WHERE CONTENT LIKE CONCAT( '%', ? , '%')";
			Object obj = searchText;
			return this.jdbcTemplate.queryForList(sql, obj);
		} else 
			return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

