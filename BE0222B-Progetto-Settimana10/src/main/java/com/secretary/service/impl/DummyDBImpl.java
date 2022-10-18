package com.secretary.service.impl;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.secretary.model.College;
import com.secretary.model.DegreeCourse;
import com.secretary.model.Student;
import com.secretary.service.DummyDB;

@Configuration
public class DummyDBImpl implements DummyDB {

	private Long id = 0L;

	private final College college = new College();

	@Bean
	public College college() {
		return college;
	}

	@Override
	public Map<Long, Student> getAllStudents() {
		return college.getStudents();
	}

	@Override
	public Student getStudentById(Long idStudent) {
		return college.getStudents().get(idStudent);
	}

	@Override
	public Student addStudent(Student student) {
		student.setIdStudent(id);
		id++;
		college.getStudents().put(student.getIdStudent(), student);
		return student;
	}

	@Override
	public Student updateStudent(Long idStudent, Student student) {
		Student newStudent = null;
		if (college.getStudents().containsKey(idStudent)) {
			newStudent = college.getStudents().get(idStudent);
			newStudent.setAddress(student.getAddress());
			newStudent.setBirthDate(student.getBirthDate());
			newStudent.setEmail(student.getEmail());
			newStudent.setFirstName(student.getFirstName());
			newStudent.setLastName(student.getLastName());
			newStudent.setResidence(student.getResidence());
		}
		return newStudent;
	}

	@Override
	public void deleteStudent(Long idStudent) {
		if (college.getStudents().containsKey(idStudent)) {
			college.getStudents().remove(idStudent);
		}
	}

	@Override
	public Map<Long, DegreeCourse> getAllDegreeCourses() {
		return college.getDegreeCourses();
	}

	@Override
	public DegreeCourse getDegreeCourseByName(String name) {
		return college.getDegreeCourses().values().stream().filter((item) -> item.equals(name)).findAny().get();
	}

	@Override
	public DegreeCourse addDegreeCourse(DegreeCourse degreeCourse) {
		degreeCourse.setIdCourse(id);
		id++;
		college.getDegreeCourses().put(degreeCourse.getIdCourse(), degreeCourse);
		return degreeCourse;
	}

	@Override
	public DegreeCourse updateDegreeCourse(Long idCourse, DegreeCourse degreeCourse) {
		DegreeCourse newDegreeCourse = null;
		if (college.getDegreeCourses().containsKey(idCourse)) {
			newDegreeCourse = college.getDegreeCourses().get(idCourse);
			newDegreeCourse.setAddress(degreeCourse.getAddress());
			newDegreeCourse.setName(degreeCourse.getName());
		}
		return newDegreeCourse;
	}

	@Override
	public void deleteDegreeCourse(Long idCourse) {
		if (college.getDegreeCourses().containsKey(idCourse)) {
			college.getDegreeCourses().remove(idCourse);
		}
	}

}
