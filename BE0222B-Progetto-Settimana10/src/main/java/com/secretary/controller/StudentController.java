package com.secretary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.secretary.model.Student;
import com.secretary.model.dto.StudentDTO;
import com.secretary.model.dto.converter.StudentDTOConverter;
import com.secretary.service.DummyDB;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private DummyDB dummyDB;

	@Autowired
	private StudentDTOConverter studentC;

	@GetMapping("/getAllStudents")
	public ModelAndView getAllStudents() {
		ModelAndView modelAndView = new ModelAndView("students");
		modelAndView.addObject("studentList", dummyDB.getAllStudents());
		return modelAndView;
	}

	@GetMapping("/getStudentById")
	public ModelAndView getStudentById() {
		ModelAndView modelAndView = new ModelAndView("students");
		modelAndView.addObject("studentList", dummyDB.getStudentById(null));
		return modelAndView;
	}

	@GetMapping("/formAddStudent")
	public ModelAndView addStudent() {
		ModelAndView m = new ModelAndView("addStudent");
		m.addObject("student", new StudentDTO());
		m.addObject("courses", dummyDB.getAllDegreeCourses());
		return m;
	}

	@PostMapping("/addStudent")
	public ModelAndView addStudent(@ModelAttribute("student") StudentDTO studentDTO) {
		ModelAndView m = new ModelAndView("addStudent");
		Student student = studentC.convert(studentDTO);
		dummyDB.addStudent(student);
		return m;
	}

	@PutMapping("/updateStudent")
	public ModelAndView updateStudent() {
		return null;
	}

	@DeleteMapping("/deleteStudent")
	public ModelAndView deleteStudent() {
		return null;
	}

}
