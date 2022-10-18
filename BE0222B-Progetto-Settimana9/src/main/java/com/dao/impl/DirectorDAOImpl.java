package com.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.dao.DirectorDAO;
import com.data.Director;
import com.util.JpaUtil;

public class DirectorDAOImpl implements DirectorDAO {

	EntityManager entity;

	public void postDirector(Director director) {
		entity = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entity.getTransaction();
		try {
			entityTransaction.begin();
			entity.persist(director);
			entityTransaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		} finally {
			entity.close();
		}
	}

	public Director getDirectorById(Long id) {
		Director director = null;
		entity = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entity.getTransaction();
		try {
			entityTransaction.begin();
			director = entity.find(Director.class, id);
			entityTransaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		} finally {
			entity.close();
		}
		return director;
	}

	public Director getDirectorByFullname(String fullname) {
		entity = JpaUtil.getEntityManagerFactory().createEntityManager();
		Query qFullname = entity.createQuery("SELECT d FROM Director d WHERE d.fullname = :fullname");
		qFullname.setParameter("fullname", fullname);
		Director director = (Director) qFullname.getSingleResult();
		return director;
	}

	public void putDirector(Director director) {
		entity = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entity.getTransaction();
		try {
			entityTransaction.begin();
			entity.merge(director);
			entityTransaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		} finally {
			entity.close();
		}
	}

	public void deleteDirector(Long id) {
		entity = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entity.getTransaction();
		try {
			entityTransaction.begin();
			entity.remove(entity.find(Director.class, id));
			entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		} finally {
			entity.close();
		}
	}

}
