/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chamado.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name = "ordem_servicos")
public class OrdemDeServicos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String problemaRelatado;
	private String diagnostico;
	private String status;
	@Temporal(TemporalType.TIMESTAMP)
	private Date abertura;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechamento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (getId() != null ? getId().hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof OrdemDeServicos)) {
			return false;
		}
		OrdemDeServicos other = (OrdemDeServicos) object;
		if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.chamado.model.NewEntity[ id=" + getId() + " ]";
	}

	public String getProblemaRelatado() {
		return problemaRelatado;
	}

	public void setProblemaRelatado(String problemaRelatado) {
		this.problemaRelatado = problemaRelatado;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getAbertura() {
		return abertura;
	}

	public void setAbertura(Date abertura) {
		this.abertura = abertura;
	}

	public Date getFechamento() {
		return fechamento;
	}

	public void setFechamento(Date fechamento) {
		this.fechamento = fechamento;
	}
}
