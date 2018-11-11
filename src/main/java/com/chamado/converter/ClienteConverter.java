/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chamado.converter;

import com.chamado.dao.ClienteDao;
import com.chamado.model.Cliente;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Rodrigo
 */
@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {

    private ClienteDao clienteDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("")) {
            return null;
        }
        Integer id = Integer.parseInt(string);
        clienteDao = new ClienteDao();
        Cliente obj = clienteDao.findById(id).get(0);
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
        Cliente obj = (Cliente) o;
        return obj.getId().toString();
    }
}
