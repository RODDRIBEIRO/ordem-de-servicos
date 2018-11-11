/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chamado.dao;

import static com.chamado.dao.Dao.emf;
import com.chamado.model.Tecnico;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author RODRIGO
 */
public class TecnicoDao extends Dao<Tecnico> implements Serializable {

    @Override
    public List lista() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Tecnico> q = em.createQuery("SELECT o FROM Tecnico o", Tecnico.class);
            List<Tecnico> list = q.getResultList();
            return list;
        } finally {
            em.close();
        }
    }
    
        public List<Tecnico> findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            List<Tecnico> list = em.createQuery("SELECT u from Tecnico u where u.id = '" + id + "'").getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    
      public List<Tecnico> findByName(String nome) {
        EntityManager em = emf.createEntityManager();
        try {
            List<Tecnico> list = em.createQuery("SELECT o FROM Tecnico o Where o.usuario.pessoa.nome LIKE '%" + nome + "%'").getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

   

}
