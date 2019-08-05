/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chamado.dao;

import static com.chamado.dao.Dao.emf;
import com.chamado.model.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author RODRIGO
 */
public class ClienteDao extends Dao<Cliente> implements Serializable {

	public List<Cliente> findByName(String nome) {
		EntityManager em = emf.createEntityManager();
		try {
			List<Cliente> list = em.createQuery("SELECT o FROM Cliente o where o.pessoa.nome LIKE '%" + nome + "%'")
					.getResultList();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	public Cliente findByNameUnit(String nome) {
		EntityManager em = emf.createEntityManager();
		try {
			Cliente cliente = (Cliente) em
					.createQuery("SELECT o FROM Cliente o where o.pessoa.nome LIKE '%" + nome + "%'").getSingleResult();
			return cliente;
		} catch (Exception e) {
			return null;
		}

	}

	public List<Cliente> findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		try {
			List<Cliente> list = em.createQuery("SELECT u from Cliente u where u.id = '" + id + "'").getResultList();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Cliente> lista() {
		EntityManager em = emf.createEntityManager();

		try {
			TypedQuery<Cliente> q = em.createQuery("SELECT o FROM Cliente o", Cliente.class);
			List<Cliente> list = q.getResultList();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	public Cliente findPrimaryKey(Integer id) {
		EntityManager em = emf.createEntityManager();
		try {
			Cliente cliente = (Cliente) em.createQuery("SELECT u from Cliente u where u.id = :id")
					.setParameter("id", id).getSingleResult();
			return cliente;
		} catch (Exception e) {
			return null;
		}
	}
}
