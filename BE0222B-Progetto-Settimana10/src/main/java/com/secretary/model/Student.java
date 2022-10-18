package com.secretary.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@NonNull
	private Long idStudent;

	@NonNull
	private String firstName;

	@NonNull
	private String lastName;

	@NonNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	@NonNull
	private String email;

	@NonNull
	private String address;

	@NonNull
	private String residence;
	
	@NonNull
	private DegreeCourse degreeCourse;

}
