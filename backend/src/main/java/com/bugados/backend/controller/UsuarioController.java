package com.bugados.backend.controller;

//import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bugados.backend.dao.UsuarioDAO;
import com.bugados.backend.model.Usuario;


@CrossOrigin(origins = "*")
@RestController
public class UsuarioController {

	
	@Autowired //injeção da dependência - não precisa implementar pois o framework cria - by Isidro
	private UsuarioDAO dao;
	
	//Não será usado
	/*
	@GetMapping("/usuarios")
	public ArrayList<Usuario> listarTudo(){
		ArrayList<Usuario> lista = (ArrayList<Usuario>) dao.findAll();
		
		return lista;
	}*/
	
	
	
	/*Enviar o JSON conforme abaixo
		{
		    "login":"blair",
		    "senha":"4321"
		}
		ou
		{
		    "login":"d@d.com",
		    "senha":"4321"
		}
	 */
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario userEmailRacf) {
		// Antes verificar se foi enviado email ou racf
		Boolean isEmail;
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		isEmail = userEmailRacf.getLogin().matches(regex);
		//Se for um email
		if (isEmail) {
			Usuario user = dao.findByEmailAndSenha(userEmailRacf.getLogin(), userEmailRacf.getSenha());
			if(user != null) {
				return ResponseEntity.ok(user);
			}else {
				return ResponseEntity.notFound().build();
			}
		//Se for racf
		}else {
			Usuario user = dao.findByRacfAndSenha(userEmailRacf.getLogin(), userEmailRacf.getSenha());
			if(user != null) {
				return ResponseEntity.ok(user);
			}else {
				return ResponseEntity.notFound().build();
			}
		}
	}
}
