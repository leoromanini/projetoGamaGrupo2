package com.bugados.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//Criamos a tables, que não veio com o SQL do projeto.
@Entity
@Table(name="tbl_usuario")
public class Usuario {
	
	//Atributos do usuário para login. Apenas para acesso do sisema.
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idusuario")
	private int id;
	
	@Column(name="nome", length=100, nullable=false)
	private String nome;
	
	@Column(name="email", length=100, nullable=false, unique=true)
	private String email;
	
	@Column(name="racf", length=7, nullable=false, unique=true)
	private String racf;
	
	@Column(name="senha", length=30)
	private String senha;
	
	//Não sei se vão implementar
	@Column(name="linkfoto", length=200)
	private String linkFoto;
	
	//É usado apenas quando algum usuário é instanciado, no demais é um campo inútil....
	@Column(name="login", length=1)
	private String login;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRacf() {
		return racf;
	}

	public void setRacf(String racf) {
		this.racf = racf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
