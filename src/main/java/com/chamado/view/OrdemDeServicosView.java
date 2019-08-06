/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chamado.view;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FlowEvent;

import com.chamado.dao.ClienteDao;
import com.chamado.dao.OrdemDeServicosDao;
import com.chamado.model.Cliente;
import com.chamado.model.OrdemDeServicos;

/**
 *
 * @author RODRIGO
 */
@ManagedBean
@ViewScoped
public class OrdemDeServicosView extends View implements Serializable {

	private static final long serialVersionUID = -2762166247924213014L;

	private OrdemDeServicos os;
	private OrdemDeServicosDao osDao;
	private ClienteDao clienteDao;
	private boolean cad;
	private boolean skip;

	public OrdemDeServicosView() {
		this.os = new OrdemDeServicos();
		this.osDao = new OrdemDeServicosDao();
		this.clienteDao = new ClienteDao();
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	@Override
	public void limpar() {
	}

	@Override
	public void salvar() {
		osDao.salvar(os);
		iniciar();
	}

	@Override
	public void editar() {
		osDao.editar(os);
	}

	@Override
	public void excluir() {
		osDao.excluir(os);
	}

	@Override
	public void iniciar() {
		cad = false;
	}

	public void novaOs() {
		os = new OrdemDeServicos();
		cad = true;
	}

	public void editOs() {
		cad = true;
	}

	@Override
	public String getTitulo() {
		os = new OrdemDeServicos();
		osDao = new OrdemDeServicosDao();
		clienteDao = new ClienteDao();
		cad = false;
		return "ChamadoWeb";
	}

	public List<Cliente> oncompleteNomeClientes(String nome) {
		nome = nome.trim();
		List list = clienteDao.findByName(nome);
		return list;
	}

	public Date getDataAbertura() {
		Date dataAtual = new Date();
		os.setAbertura(dataAtual);
		return dataAtual;
	}

	public OrdemDeServicos getOs() {
		return os;
	}

	public void setOs(OrdemDeServicos os) {
		this.os = os;
	}

	public List<OrdemDeServicos> getListaos() {
		List list = osDao.lista();
		return list;
	}

	public OrdemDeServicosDao getOsDao() {
		return osDao;
	}

	public void setOsDao(OrdemDeServicosDao osDao) {
		this.osDao = osDao;
	}

	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	public boolean isCad() {
		return cad;
	}

	public void setCad(boolean cad) {
		this.cad = cad;
	}

}
