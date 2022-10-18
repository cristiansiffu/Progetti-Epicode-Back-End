package com.library.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAuthor;

	@NotNull
	@Column(nullable = false)
	private String firstName;

	@NotNull
	@Column(nullable = false)
	private String lastName;

	@NotNull
	@ManyToMany
	@Column(nullable = false)
	private List<Book> books = new ArrayList<>();

}
