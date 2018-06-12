package com.bong.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bong.model.ProjectDTO;

public class ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List projectList() {
		String sql = "SELECT * FROM PROJECT_BOARD";
		return this.jdbcTemplate.queryForList(sql);
	}
	
	public void countPlus(ProjectDTO dto) {
		String sql = "UPDATE PROJECT_BOARD SET COUNT=? WHERE SEQ=?";
		Object[] obj = {dto.getCount()+1, dto.getSeq()};
		this.jdbcTemplate.update(sql, obj);
	}
	
	public void projectInsert(ProjectDTO dto) {
		String sql = "INSERT INTO PROJECT_BOARD(SUBJECT,WRITER,MEMBERS,CONTENT,STATUS,CRE_DATE,MOD_DATE)" + 
					" VALUES(?,?,?,?,?,?,NOW())";
		Object[] obj = {dto.getSubject(), dto.getWriter(), dto.getMembers(), dto.getContent(), dto.getStatus(), dto.getCre_date()};
		
		this.jdbcTemplate.update(sql,obj);
	}
	
	public void projectUpdate(ProjectDTO dto) {
		String sql = "UPDATE PROJECT_BOARD SET SUBJECT=?, WRITER=?, MEMBERS=?, CONTENT=?, STATUS=?, MOD_DATE=?" + 
					" WHERE SEQ = ?";
		Object[] obj = {dto.getSubject(), dto.getWriter(), dto.getMembers(), dto.getContent(),
						dto.getStatus(), dto.getMod_date(), dto.getSeq()};
		this.jdbcTemplate.update(sql,obj);
	}
	
	public int projectDelete(ProjectDTO dto) {
		String sql = "DELETE FROM PROJECT_BOARD WHERE SEQ = ?";
		Object obj = dto.getSeq();
		return this.jdbcTemplate.update(sql,obj);
	}
	
	public void updateSeq(ProjectDTO dto) {
		String sql = "UPDATE PROJECT_BOARD SET SEQ = ? WHERE SEQ = ?";
		Object[] obj = {dto.getSeq() , dto.getSeq()+1};
		this.jdbcTemplate.update(sql,obj);
	}
	
	public void setSeq(ProjectDTO dto) {
		String sql = "ALTER TABLE PROJECT_BOARD AUTO_INCREMENT=?";
		Object obj = dto.getSeq();
		this.jdbcTemplate.update(sql,obj);
	}
	
	public int seqCount() {
		String sql = "SELECT COUNT(SEQ) FROM PROJECT_BOARD";
		return this.jdbcTemplate.queryForInt(sql);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
