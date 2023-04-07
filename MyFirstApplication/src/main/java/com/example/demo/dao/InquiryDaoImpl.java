package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Inquiry;

// @Repository讓DI控制器知道要對DB進行操作
@Repository
public class InquiryDaoImpl implements InquiryDao {
	
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public InquiryDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insertInquiry(Inquiry inquiry) {
		jdbcTemplate.update("INSERT INTO inquiry(name, email, contents, created) VALUER(?, ?, ?, ?)", // 之後再決定內容
				inquiry.getName(), inquiry.getEmail(), inquiry.getContents(), inquiry.getCreated());

	}

	@Override
	public List<Inquiry> getAll() {
		String sql = "SELECT id, name, email, contents, created FROM inquiry";
		List<Map<String, Object>> resultlist = jdbcTemplate.queryForList(sql);
		List<Inquiry> list = new ArrayList<Inquiry>();
		for(Map<String, Object> result : resultlist ) {
			Inquiry inquiry = new Inquiry();
			inquiry.setId((int)result.get("id"));
			
		}
		return null;
	}

}
