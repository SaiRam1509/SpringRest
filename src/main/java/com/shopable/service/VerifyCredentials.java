package com.shopable.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.shopable.DAO.UserDao;
import com.shopable.model.Userinformation;





@Component
public class VerifyCredentials {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	UserDao ud;

	public String check(String name, String password) throws Exception {

		String sql = "select user_id from user_information where user_id=? and password=?";

		String result = "";
		try {
			result = jdbcTemplate.queryForObject(sql, new RowMapper<String>() {

				public String mapRow(ResultSet rs, int rowNum) throws SQLException {

					return rs.getString("user_id");
				}

			}, name, password);
		} catch (Exception e) {

		}
		
		return result;
		
			 	}
	public void adduser(Userinformation person) {
		ud.insertuser(person);
		return;
		
	}
	
}
	


