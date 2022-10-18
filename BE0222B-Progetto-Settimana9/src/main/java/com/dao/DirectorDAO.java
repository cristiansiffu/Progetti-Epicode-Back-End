package com.dao;

import com.data.Director;

public interface DirectorDAO {

	public void postDirector(Director d);

	public Director getDirectorById(Long id);

	public Director getDirectorByFullname(String fullname);

	public void putDirector(Director d);

	public void deleteDirector(Long id);
}
