package com.secretary.model;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class College {

	private Map<Long, Student> students = new HashMap<>();

	private Map<Long, DegreeCourse> degreeCourses = new HashMap<>();

}
