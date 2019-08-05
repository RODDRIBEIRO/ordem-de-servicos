/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chamado.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.chamado.dao.UsuarioDao;
import com.chamado.model.Usuario;

/**
 *
 * @author RODRIGO
 */
@ManagedBean
@ViewScoped
public class UsuarioView extends View implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private List<Usuario> listausuarios;
	private UsuarioDao usuarioDao;
	private boolean cad;

	public String envia() {

		usuario = usuarioDao.getUsuario(usuario.getLogin(), usuario.getSenha());
		if (usuario == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));
			return "/index";
		} else {
			return "/principal";
		}

	}

	@Override
	public void limpar() {
	}

	@Override
	public void salvar() {
		usuarioDao.salvar(usuario);
		iniciar();
	}

	@Override
	public void editar() {
		usuarioDao.editar(usuario);
	}

	@Override
	public void excluir() {
		usuarioDao.excluir(usuario);
	}

	@Override
	public void iniciar() {
		usuario = new Usuario();
	}

	@Override
	public String getTitulo() {
		usuario = new Usuario();
		usuarioDao = new UsuarioDao();
		return "ChamadoWeb";
	}

	public List<Usuario> getUsuarios() {
		listausuarios = usuarioDao.lista();
		return listausuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListausuarios() {
		return listausuarios;
	}

	public void setListausuarios(List<Usuario> listausuarios) {
		this.listausuarios = listausuarios;
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
