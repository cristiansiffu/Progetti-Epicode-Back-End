package com.secretary.model.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentDTO {

	private Long idStudent;

	private String firstName;

	private String lastName;

	private LocalDate birthDate;

	private String email;

	private String address;

	private String residence;

	private String degreeCourse;

}
