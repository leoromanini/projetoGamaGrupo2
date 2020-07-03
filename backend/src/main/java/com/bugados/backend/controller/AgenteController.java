package com.bugados.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bugados.backend.dao.AgenteDAO;
import com.bugados.backend.model.Agente;
import com.bugados.backend.model.Transacao;

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
	
	@GetMapping("/agentes2")
	public ArrayList<Agente>listarAgentes2(){
		ArrayList<Agente> listaAgentes = (ArrayList<Agente>) dao.findNome2();
		return listaAgentes;
	}
	
	@GetMapping("/agentes3")
	public ArrayList<Agente> listarAgentes3(){
		ArrayList<Agente> listaAgentes = (ArrayList<Agente>) dao.findNome3();
		
		return listaAgentes;
	}
	
	@GetMapping("/agentes4")
	public ArrayList<Agente> listarAgentes4(){
		ArrayList<Agente> listaAgentes = (ArrayList<Agente>) dao.findAll();
		
		return listaAgentes;
	}
	
	@PostMapping("/agentetransacao")
	public ResponseEntity<ArrayList<Agente>> login(@RequestBody Agente ag_financeiro) {
		ArrayList<Agente> listaTrans = (ArrayList<Agente>) dao.findTransacao(ag_financeiro.getIdAgente());
		if(!listaTrans.isEmpty()) {
			return ResponseEntity.ok(listaTrans);
		}else {
			return ResponseEntity.notFound().build();

		}
	}
}


