package com.bugados.backend.dao;

import org.springframework.data.repository.CrudRepository;

import com.bugados.backend.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{

	//caso seja usado email
	public Usuario findByEmailAndSenha(String email, String senha);
	
	//caso seja usado racf
	public Usuario findByRacfAndSenha(String racf, String senha);
	
}
