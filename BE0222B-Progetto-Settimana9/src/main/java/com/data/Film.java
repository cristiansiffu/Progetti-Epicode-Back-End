package com.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Film {

	private Long idFilm;
	private String title;
	@Temporal(TemporalType.DATE)
	private Date releaseDate;
	private String type;
	private String gross;
	private Director director;

	public Film() {
		super();
	}

	public Film(Long idFilm, String title, Date releaseDate, String type, String gross, Director director) {
		super();
		this.idFilm = idFilm;
		this.title = title;
		this.releaseDate = releaseDate;
		this.type = type;
		this.gross = gross;
		this.director = director;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return idFilm;
	}

	public void setId(Long idFilm) {
		this.idFilm = idFilm;
	}

	@Column(nullable = false, unique = true)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(nullable = false)
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Column(nullable = false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGross() {
		return gross;
	}

	public void setGross(String gross) {
		this.gross = gross;
	}

	@ManyToOne
	@JoinColumn(name = "idDirector")
	@JsonIgnoreProperties("films")
	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}
}
