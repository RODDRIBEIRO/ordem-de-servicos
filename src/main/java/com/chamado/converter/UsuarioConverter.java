/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chamado.converter;

import com.chamado.dao.UsuarioDao;
import com.chamado.model.Usuario;
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
@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {

    private UsuarioDao usuarioDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("")) {
            return null;
        }
        Integer id = Integer.parseInt(string);
        usuarioDao = new UsuarioDao();
        Usuario obj = usuarioDao.findById(id).get(0);
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
        Usuario obj = (Usuario) o;
        return obj.getId().toString();
    }
}
