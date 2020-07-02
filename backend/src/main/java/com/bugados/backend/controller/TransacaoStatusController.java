package com.bugados.backend.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bugados.backend.dao.TransacaoStatusDAO;
import com.bugados.backend.model.Transacao;
import com.bugados.backend.model.TransacaoStatus;

@CrossOrigin(origins = "*")
@RestController
public class TransacaoStatusController {

	@Autowired //injeção da dependência - não precisa implementar pois o framework cria
	private TransacaoStatusDAO dao;
	

}
