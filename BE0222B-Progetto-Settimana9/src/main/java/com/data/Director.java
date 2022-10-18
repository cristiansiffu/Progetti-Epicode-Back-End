package com.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Director {

	private Long idDirector;
	private String fullname;
	private List<Film> films;

	public Director() {
		super();
	}

	public Director(Long idDirector, String fullname, List<Film> films) {
		super();
		this.idDirector = idDirector;
		this.fullname = fullname;
		this.films = new ArrayList<Film>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdDirector() {
		return idDirector;
	}

	public void setIdDirector(Long idDirector) {
		this.idDirector = idDirector;
	}

	@Column(nullable = false, unique = true)
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("director")
	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

}
