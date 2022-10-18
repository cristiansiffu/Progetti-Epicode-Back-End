package com.secretary.model.dto.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.secretary.model.DegreeCourse;
import com.secretary.service.DummyDB;

@Component
public class DegreeCourseDTOConverter implements Converter<String, DegreeCourse> {

	@Autowired
	private DummyDB dummyDB;

	@Override
	public DegreeCourse convert(String source) {
		return dummyDB.getDegreeCourseByName(source);
	}

}
