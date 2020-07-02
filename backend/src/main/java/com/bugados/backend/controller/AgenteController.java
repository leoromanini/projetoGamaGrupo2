package com.bugados.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugados.backend.dao.AgenteDAO;
import com.bugados.backend.model.Agente;

@CrossOrigin(origins = "*")
@RestController
public class AgenteController {

	@Autowired //injeção da dependência - não precisa implementar pois o framework cria
	private AgenteDAO dao;
	
	@GetMapping("/agentes")
	public List<Object[]> listarAgentes(){
		List<Object[]> listaAgentes = dao.findNome();
		return listaAgentes;
	}
	

}


