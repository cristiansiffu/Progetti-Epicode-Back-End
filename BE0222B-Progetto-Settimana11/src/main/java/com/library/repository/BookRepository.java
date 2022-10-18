package com.library.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	@Query("select b from Book b where b.authors = any(select a from Author a where a.idAuthor = :id )")
	public Page<Book> findByAuthor(@Param("id") Long idAuthor, Pageable pageable);

	@Query("select b from Book b where b.categories = any(select c from Category c where c.idCategory = :id )")
	public Page<Book> findByCategory(@Param("id") Long idCategory, Pageable pageable);

}
