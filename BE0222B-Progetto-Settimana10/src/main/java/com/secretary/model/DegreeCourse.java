package com.secretary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DegreeCourse {

	@NonNull
	private Long idCourse;

	@NonNull
	private String name;

	@NonNull
	private String address;

	@NonNull
	private Integer examsNumber;

}
