/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chamado.view;

import java.io.Serializable;

/**
 *
 * @author Rodrigo
 */
public abstract class View implements Serializable{

    public abstract void limpar();

    public abstract void salvar();

    public abstract void editar();

    public abstract void excluir();

    public abstract void iniciar();

    public abstract String getTitulo();
}
