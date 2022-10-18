package com.secretary.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DegreeCourseDTO {
	
	private Long idCourse;

	private String name;

	private String address;

	private Integer examsNumber;

}
