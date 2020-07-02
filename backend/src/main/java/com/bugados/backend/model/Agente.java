package com.bugados.backend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="mtb310_ag_financeiro")
public class Agente {

	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY) - Consideramos que não vamos implementar update de tabela
	@Column(name="id_agente")
	private int idAgente;
	
	@Column(name="nome_agente", length=100, nullable=false)
	private String nomeAgente;
	
	@Column(name="volume_transacional")
	private float volumeTransacional;
	
	@JsonIgnoreProperties("ag_financeiro")
	@OneToMany(mappedBy = "agFinanceiro", cascade = CascadeType.ALL)
	private List<Transacao> listaTransacao;

	public int getIdAgente() {
		return idAgente;
	}

	public void setIdAgente(int idAgente) {
		this.idAgente = idAgente;
	}

	public String getNomeAgente() {
		return nomeAgente;
	}

	public void setNomeAgente(String nomeAgente) {
		this.nomeAgente = nomeAgente;
	}

	public float getVolumeTransacional() {
		return volumeTransacional;
	}

	public void setVolumeTransacional(float volumeTransacional) {
		this.volumeTransacional = volumeTransacional;
	}

	public List<Transacao> getListaTransacao() {
		return listaTransacao;
	}

	public void setListaTransacao(List<Transacao> listaTransacao) {
		this.listaTransacao = listaTransacao;
	}	
	
	
	
}
