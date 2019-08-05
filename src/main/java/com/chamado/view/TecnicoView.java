/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chamado.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.chamado.dao.TecnicoDao;
import com.chamado.dao.UsuarioDao;
import com.chamado.model.Tecnico;
import com.chamado.model.Usuario;

/**
 *
 * @author RODRIGO
 */
@ManagedBean
@ViewScoped
public class TecnicoView extends View implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Tecnico tecnico;
	private List<Tecnico> listatecnicos;
	private TecnicoDao tecnicoDao;
	private UsuarioDao usuarioDao;
	private boolean cad;

	@Override
	public void limpar() {
	}

	@Override
	public void salvar() {
		tecnicoDao.salvar(tecnico);
		iniciar();
	}

	@Override
	public void editar() {
		tecnicoDao.editar(tecnico);
	}

	@Override
	public void excluir() {
		tecnicoDao.excluir(tecnico);
	}

	@Override
	public void iniciar() {
		tecnico = new Tecnico();
	}

	public void novoTecnico() {
		tecnico = new Tecnico();
		cad = true;
	}

	public void editarTecnico() {
		cad = true;
	}

	@Override
	public String getTitulo() {
		tecnico = new Tecnico();
		tecnicoDao = new TecnicoDao();
		cad = false;
		return "ChamadoWeb";
	}

	public List<Usuario> oncompleteNomeUsuarios(String nome) {
		nome = nome.trim();
		UsuarioDao usuarioDao1 = new UsuarioDao();
		return usuarioDao1.findByName(nome);
	}

	public List<Tecnico> getTecnicos() {
		listatecnicos = tecnicoDao.lista();
		return listatecnicos;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public List<Tecnico> getListatecnicos() {
		return listatecnicos;
	}

	public void setListatecnicos(List<Tecnico> listatecnicos) {
		this.listatecnicos = listatecnicos;
	}

	public TecnicoDao getTecnicoDao() {
		return tecnicoDao;
	}

	public void setTecnicoDao(TecnicoDao tecnicoDao) {
		this.tecnicoDao = tecnicoDao;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public boolean isCad() {
		return cad;
	}

	public void setCad(boolean cad) {
		this.cad = cad;
	}
}
