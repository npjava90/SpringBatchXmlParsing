package org.batch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.batch.model.Student;
import org.springframework.jdbc.core.RowMapper;

public class Student_RowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowRows) throws SQLException {
		// TODO Auto-generated method stub
		
		Student student = new Student();
		
		student.setId(rs.getString(1));
		student.setName(rs.getString(2));
		student.setCollege(rs.getString(3));
		student.setStatus(rs.getString(4));
		
		return student;
	}

}
