/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chamado.dao;

import static com.chamado.dao.Dao.emf;
import com.chamado.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author RODRIGO
 */
public class UsuarioDao extends Dao<Usuario> implements Serializable {

    @Override
    public List lista() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Usuario> q = em.createQuery("SELECT o FROM Usuario o", Usuario.class);
            List<Usuario> list = q.getResultList();
            return list;
        } finally {
            em.close();
        }
    }
    
        public List<Usuario> findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            List<Usuario> list = em.createQuery("SELECT u from Usuario u where u.id = '" + id + "'").getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    
      public List<Usuario> findByName(String nome) {
        EntityManager em = emf.createEntityManager();
        try {
            List<Usuario> list = em.createQuery("SELECT o FROM Usuario o where o.pessoa.nome LIKE '%" + nome + "%'").getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public Usuario getUsuario(String login, String senha) {
        EntityManager em = emf.createEntityManager();
        try {
            Usuario usuario = (Usuario) em
                    .createQuery(
                            "SELECT u from Usuario u where u.login = :login and u.senha = :senha")
                    .setParameter("login", login)
                    .setParameter("senha", senha).getSingleResult();

            return usuario;
        } catch (Exception e) {
            return null;
        }
    }

}
