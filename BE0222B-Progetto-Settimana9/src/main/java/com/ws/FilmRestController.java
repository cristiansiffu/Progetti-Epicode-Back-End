package com.ws;

import java.util.List;

import com.dao.FilmDAO;
import com.dao.impl.FilmDAOImpl;
import com.data.Film;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "FilmRest")
@RequestMapping("/film")
public class FilmRestController {

	@ApiOperation(value = "Add new film: ", response = String.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Film Added!") })
	@PostMapping("/post")
	public ResponseEntity<String> postFilm(@RequestBody Film f) {
		FilmDAO filmDAO = new FilmDAOImpl();
		filmDAO.postFilm(f);
		return new ResponseEntity<String>("Film Added!", HttpStatus.OK);
	}

	@GetMapping("/getbydirector/{director}")
	public ResponseEntity<List<Film>> getByDirector(@RequestBody String director) {
		FilmDAO fDAO = new FilmDAOImpl();
		List<Film> f = fDAO.getFilmByDirector(director);
		return new ResponseEntity<List<Film>>(f, HttpStatus.OK);
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Film> getById(@PathVariable Long id) {
		FilmDAO fDAO = new FilmDAOImpl();
		Film f = fDAO.getFilmById(id);
		return new ResponseEntity<Film>(f, HttpStatus.OK);
	}
}
