/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chamado.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author RODRIGO
 * @param <T>
 */
public abstract class Dao<T> implements Serializable {

	private static final long serialVersionUID = 1912821899744168130L;

	static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("chamadocrudPU");
	}

	public void salvar(T t) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			t = em.merge(t);
			em.persist(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void excluir(T t) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			t = em.merge(t);
			em.remove(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void editar(T t) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public abstract List lista();

}
