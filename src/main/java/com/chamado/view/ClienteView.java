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

import com.chamado.dao.ClienteDao;
import com.chamado.model.Cliente;
import com.chamado.relatorio.Relatorio;

/**
 *
 * @author RODRIGO
 */
@ManagedBean
@ViewScoped
public class ClienteView extends View implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
    private List<Cliente> listaClientes;
    private ClienteDao clienteDao;
    private boolean cad;

    @Override
    public void limpar() {
    }

    @Override
    public void salvar() {
        clienteDao.salvar(cliente);
        iniciar();
    }

    @Override
    public void editar() {
        clienteDao.editar(cliente);
    }

    @Override
    public void excluir() {
        clienteDao.excluir(cliente);
    }

    @Override
    public void iniciar() {
        cad = false;
        cliente = new Cliente();
    }

    @Override
    public String getTitulo() {
        cliente = new Cliente();
        clienteDao = new ClienteDao();
        return "ChamadoWeb";
    }
    
   public void relatorioImp(){
        Relatorio relatorio = new Relatorio();
        relatorio.getRelatorio(listaClientes, "/rel/clientes.jasper");
    }

    public void novaOs() {
        cliente = new Cliente();
        cad = true;
    }

    public void editOs() {
        cad = true;
    }

    public List<Cliente> getClientes() {
        listaClientes = clienteDao.lista();
        return listaClientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
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
