package com.bong.dao;


import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bong.model.MemberDTO;


public class MemberDAOImpl implements MemberDAO{

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List memberList() {
		String sql = "SELECT * FROM MEMBERS";
		return this.jdbcTemplate.queryForList(sql);
	}

	@Override
	public List descList() {
		String sql = "SELECT * FROM MEMBERS ORDER BY SEQ DESC";
		return this.jdbcTemplate.queryForList(sql);
	}
	
	
	@Override
	public int memberDelete(MemberDTO dto) {
		String sql = "DELETE FROM MEMBERS WHERE SEQ=?";
		Object obj = dto.getSeq();
		return this.jdbcTemplate.update(sql,obj);
	}
	
	@Override
	public void minusSeq(MemberDTO dto) {
		String sql = "UPDATE MEMBERS SET SEQ = ? WHERE SEQ = ?";
		Object[] obj = {dto.getSeq(), dto.getSeq()+1};
		this.jdbcTemplate.update(sql,obj);
	}
	
	@Override
	public int seqCount() {
		String sql = "SELECT COUNT(SEQ) FROM MEMBERS";
		return this.jdbcTemplate.queryForInt(sql);
	}

	@Override
	public void updateSeq(MemberDTO dto) {
		String sql = "ALTER TABLE MEMBERS AUTO_INCREMENT=?";
		Object obj = dto.getSeq();
		this.jdbcTemplate.update(sql,obj);
	}
	
	@Override
	public void memberModify(MemberDTO dto) {
		String sql = "UPDATE MEMBERS SET ID=?,NAME=?,PASSWORD=?,GENDER=?,ADDRESS=?,EMAIL=?,MOD_DATE=NOW() WHERE SEQ=?";
		Object[] obj = {dto.getId(), dto.getName(), dto.getPassword(), dto.getGender(),
						dto.getAddress(), dto.getEmail(), dto.getSeq()};
		this.jdbcTemplate.update(sql, obj);
	}

	@Override
	public void myInfoUpdate(MemberDTO dto) {
		if(dto.getPassword().equals("")) {
			String sql = "UPDATE MEMBERS SET ID=?, NAME=?, ADDRESS=?, EMAIL=?, MOD_DATE=NOW() WHERE SEQ = ?";
			Object[] obj = {dto.getId(), dto.getName(), dto.getAddress(), dto.getEmail(), dto.getSeq()};
			this.jdbcTemplate.update(sql, obj);
		} else {
			String sql = "UPDATE MEMBERS SET ID=?, NAME=?, PASSWORD=?, ADDRESS=?, EMAIL=?, MOD_DATE=NOW() WHERE SEQ = ?";
			Object[] obj = {dto.getId(), dto.getName(), dto.getPassword(), dto.getAddress(), dto.getEmail(), dto.getSeq()};
			this.jdbcTemplate.update(sql, obj);
		}
	}

	@Override
	public List suggestList() {
		String sql = "SELECT * FROM SUGGEST";
		return this.jdbcTemplate.queryForList(sql);
	}

	@Override
	public void suggestInsert(String id, String content,String time) {
		String sql = "INSERT INTO SUGGEST(ID,CONTENT,CRE_TIME) VALUES(?,?,?)";
		Object[] obj = {id, content,time};
		this.jdbcTemplate.update(sql, obj);
	}




	



	
	
	
	
	
	
	
	
	
	
	
}
