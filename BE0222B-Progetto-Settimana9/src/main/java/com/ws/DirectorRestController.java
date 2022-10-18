package com.ws;

import com.dao.DirectorDAO;
import com.dao.impl.DirectorDAOImpl;
import com.data.Director;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "DirectorRest")
@RequestMapping("/director")
public class DirectorRestController {

	@ApiOperation(value = "Add new director: ", response = String.class, produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Director Added!") })
	@PostMapping("/post")
	public ResponseEntity<String> postDirector(@RequestBody Director d) {
		DirectorDAO dDAO = new DirectorDAOImpl();
		dDAO.postDirector(d);
		return new ResponseEntity<String>("Director added!", HttpStatus.OK);
	}
}
