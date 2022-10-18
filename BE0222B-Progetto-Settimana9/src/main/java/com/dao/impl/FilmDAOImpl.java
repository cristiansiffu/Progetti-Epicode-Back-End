package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.dao.FilmDAO;
import com.data.Film;
import com.util.JpaUtil;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class FilmDAOImpl implements FilmDAO {

	EntityManager entity;

	public void postFilm(Film f) {
		entity = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entity.getTransaction();
		try {
			entityTransaction.begin();
			String cryptGross = BCrypt.hashpw(f.getGross(), BCrypt.gensalt());
			f.setGross(cryptGross);
			entity.persist(f);
			entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		} finally {
			entity.close();
		}
	}

	public Film getFilmById(Long id) {
		Film f = null;
		entity = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entity.getTransaction();
		try {
			entityTransaction.begin();
			f = entity.find(Film.class, id);
			entityTransaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		} finally {
			entity.close();
		}
		return f;
	}

	public List<Film> getFilmByDirector(String director) {
		entity = JpaUtil.getEntityManagerFactory().createEntityManager();
		List<Film> films = new ArrayList<Film>();
		Query qFullname = entity.createQuery(
				"SELECT f FROM Film f WHERE f.director = any (SELECT d FROM Director d WHERE d.fullname LIKE :fullname)");
		qFullname.setParameter("fullname", director);
		films = qFullname.getResultList();
		return films;
	}

	public List<Film> getAllFilms() {
		List<Film> films = new ArrayList<Film>();
		entity = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entity.getTransaction();
		try {
			entityTransaction.begin();
			Query qFilms = entity.createQuery("SELECT f FROM Film f");
			films = qFilms.getResultList();
			entityTransaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		} finally {
			entity.close();
		}
		return films;
	}

	public void putFilm(Film f) {
		entity = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entity.getTransaction();
		try {
			entityTransaction.begin();
			entity.merge(f);
			entityTransaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		} finally {
			entity.close();
		}
	}

	public void deleteFilm(Long id) {
		entity = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entity.getTransaction();
		try {
			entityTransaction.begin();
			Film f = entity.find(Film.class, id);
			if (f != null) {
				entity.remove(f);
				entityTransaction.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		} finally {
			entity.close();
		}
	}

}
