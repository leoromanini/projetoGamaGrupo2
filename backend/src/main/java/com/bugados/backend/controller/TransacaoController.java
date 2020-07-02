package com.bugados.backend.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bugados.backend.dao.TransacaoDAO;
import com.bugados.backend.model.Transacao;


@CrossOrigin(origins = "*")
@RestController
public class TransacaoController {
	@Autowired //injeção da dependência - não precisa implementar pois o framework cria
	private TransacaoDAO dao;
	
	@GetMapping("/transacoes")
	public ArrayList<Transacao> listarTudo(){
		ArrayList<Transacao> lista = (ArrayList<Transacao>) dao.findAll();
		
		return lista;
	}
	
	/*Enviar o JSON conforme abaixo
    {
        "agFinanceiro": 3
    }
	 */
	@PostMapping("/transacoesagente")
	public ResponseEntity<ArrayList<Transacao>> login(@RequestBody Transacao ag_financeiro) {
		ArrayList<Transacao> listaAg = (ArrayList<Transacao>) dao.findTransacao(ag_financeiro.getAgFinanceiro());
		if(!listaAg.isEmpty()) {
			return ResponseEntity.ok(listaAg);
		}else {
			return ResponseEntity.notFound().build();

		}
	}
}


