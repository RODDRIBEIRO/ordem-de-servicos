/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chamado.converter;

import com.chamado.dao.TecnicoDao;
import com.chamado.model.Tecnico;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Rodrigo
 */
/**
 *
 * @author Rodrigo
 */
@FacesConverter(forClass = Tecnico.class)
public class TecnicoConverter implements Converter {

    private TecnicoDao tecnicoDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("")) {
            return null;
        }
        Integer id = Integer.parseInt(string);
        tecnicoDao = new TecnicoDao();
        Tecnico obj = tecnicoDao.findById(id).get(0);
        return obj;
    }

    /**
     *
     * @param fc
     * @param uic
     * @param o
     * @return
     */
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Tecnico obj = (Tecnico) o;
        return obj.getId().toString();
    }
}
