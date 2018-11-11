/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chamado.dao;

import static com.chamado.dao.Dao.emf;
import com.chamado.model.OrdemDeServicos;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author RODRIGO
 */
public class OrdemDeServicosDao extends Dao<OrdemDeServicos> implements Serializable {

    @Override
    public List<OrdemDeServicos> lista() {
        EntityManager em = emf.createEntityManager();
        try {
            List<OrdemDeServicos> list = em.createQuery("SELECT o FROM OrdemDeServicos o").getResultList();
            return list;
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    public List<OrdemDeServicos> findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            List<OrdemDeServicos> list = em.createQuery("SELECT o FROM OrdemDeServicos o where o.id ='" + id + "'").getResultList();
            return list;
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

}
