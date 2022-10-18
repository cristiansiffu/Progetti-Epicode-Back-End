package com.secretary.model.dto.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.secretary.model.Student;
import com.secretary.model.dto.StudentDTO;

@Component
public class StudentDTOConverter implements Converter<StudentDTO, Student> {

	@Autowired
	private DegreeCourseDTOConverter degreeCourseC;

	@Override
	public Student convert(StudentDTO source) {
		Student student = new Student();
		student.setAddress(source.getAddress());
		student.setBirthDate(source.getBirthDate());
		student.setDegreeCourse(degreeCourseC.convert(source.getDegreeCourse()));
		student.setEmail(source.getEmail());
		student.setFirstName(source.getFirstName());
		student.setIdStudent(source.getIdStudent());
		student.setLastName(source.getLastName());
		student.setResidence(source.getResidence());
		return student;
	}

}
