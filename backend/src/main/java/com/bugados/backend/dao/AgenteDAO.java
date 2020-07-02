package com.bugados.backend.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bugados.backend.model.Agente;



public interface AgenteDAO extends CrudRepository<Agente, Integer>{
	
    @Query("select a.nomeAgente from Agente a order by a.volumeTransacional desc")
   	public List<Object[]> findNome();
	
}
