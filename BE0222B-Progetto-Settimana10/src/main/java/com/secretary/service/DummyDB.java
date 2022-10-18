package com.secretary.service;

import java.util.Map;

import com.secretary.model.DegreeCourse;
import com.secretary.model.Student;

public interface DummyDB {

	public Map<Long, Student> getAllStudents();

	public Student getStudentById(Long idStudent);

	public Student addStudent(Student student);

	public Student updateStudent(Long idStudent, Student student);

	public void deleteStudent(Long idStudent);

	public Map<Long, DegreeCourse> getAllDegreeCourses();

	public DegreeCourse getDegreeCourseByName(String name);

	public DegreeCourse addDegreeCourse(DegreeCourse degreeCourse);

	public DegreeCourse updateDegreeCourse(Long idCourse, DegreeCourse degreeCourse);

	public void deleteDegreeCourse(Long idCourse);

}
