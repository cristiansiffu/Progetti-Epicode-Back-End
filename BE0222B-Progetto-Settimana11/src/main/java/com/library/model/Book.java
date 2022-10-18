package com.library.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idBook;

	@NotNull
	@Column(nullable = false, unique = true)
	private String title;

	@NotNull
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate relaseDate;

	@NotNull
	@Column(nullable = false)
	private Double price;

	@NotNull
	@ManyToMany
	@Column(nullable = false)
	private List<Author> authors = new ArrayList<>();

	@NotNull
	@ManyToMany
	@Column(nullable = false)
	private List<Category> categories = new ArrayList<>();

}
