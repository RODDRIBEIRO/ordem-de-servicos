/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chamado.converter;

import com.chamado.dao.OrdemDeServicosDao;
import com.chamado.model.OrdemDeServicos;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Rodrigo
 */
@FacesConverter(forClass = OrdemDeServicos.class)
public class OrdemDeServicosConverter implements Converter {

    private OrdemDeServicosDao osDao;

    @Override
       public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("")) {
            return null;
        }
        Integer id = Integer.parseInt(string);
        osDao = new OrdemDeServicosDao();
        OrdemDeServicos obj = osDao.findById(id).get(0);
        return obj;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        OrdemDeServicos obj = (OrdemDeServicos) o;
        return obj.getId().toString();
    }
}
