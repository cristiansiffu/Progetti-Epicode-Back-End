package com.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	
	public Optional<Author> findByFirstNameAndLastName(String firstName, String lastName);

}
