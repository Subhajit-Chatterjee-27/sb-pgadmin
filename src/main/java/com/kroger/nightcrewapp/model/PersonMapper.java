package com.kroger.nightcrewapp.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

public class PersonMapper implements RowMapper<Person> {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonMapper.class);
	public Person mapRow(ResultSet resultSet, int i) throws SQLException {

		Person person = new Person();
		person.setId(resultSet.getLong("id"));
		person.setFirstName(resultSet.getString("first_name"));
		person.setLastName(resultSet.getString("last_name"));
		person.setAge(resultSet.getInt("age"));
		return person;
	}
}

