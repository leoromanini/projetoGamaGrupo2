package com.bugados.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="mtb310_transaction")
public class Transacao {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY) - Consideramos que não vamos implementar update de tabela
	@Column(name="id_transacao")
	private int idTransacao;
	
	@Column(name="data_hora", length = 80)
	private String dataHora;
	
	@Column(name ="dispositivo")
	private int dispositivo;
	
	@Column(name = "valor_solic")
	private float valorSolic;
	
	@Column(name = "valor_aut")
	private float valorAut;
	
	@Column(name ="status")
	private int status;
	
	@JsonIgnoreProperties("listaTransacao")
	//@ManyToOne
	@Column(name ="ag_financeiro")
	private int agFinanceiro;

	public int getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(int idTransacao) {
		this.idTransacao = idTransacao;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public int getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(int dispositivo) {
		this.dispositivo = dispositivo;
	}

	public float getValorSolic() {
		return valorSolic;
	}

	public void setValorSolic(float valorSolic) {
		this.valorSolic = valorSolic;
	}

	public float getValorAut() {
		return valorAut;
	}

	public void setValorAut(float valorAut) {
		this.valorAut = valorAut;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAgFinanceiro() {
		return agFinanceiro;
	}

	public void setAgFinanceiro(int agFinanceiro) {
		this.agFinanceiro = agFinanceiro;
	}

}


