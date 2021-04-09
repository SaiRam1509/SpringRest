package com.shopable.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.shopable.model.Userinformation;

@Component
public class UserDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
public void insertuser(Userinformation person) {
	String sql="insert into user_information(user_id,password) values (?,?)";
	jdbcTemplate.update(sql,person.getUsername(),person.getPassword());
	return;
	
}
}
