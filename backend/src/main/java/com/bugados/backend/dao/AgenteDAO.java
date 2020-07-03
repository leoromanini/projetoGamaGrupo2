package com.bugados.backend.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bugados.backend.model.Agente;




public interface AgenteDAO extends CrudRepository<Agente, Integer>{
	
    @Query("select a.nomeAgente, a.volumeTransacional from Agente a order by a.volumeTransacional desc")
   	public List<Object[]> findNome();

    @Query("select a from Agente a order by a.volumeTransacional desc")
   	public ArrayList<Agente> findNome2();	
   	
    @Query("select a from Agente a order by a.nomeAgente")
   	public ArrayList<Agente> findNome3();
    
    @Query("SELECT a FROM Agente a WHERE a.idAgente = :id_Agente")
	public ArrayList<Agente> findTransacao(int id_Agente);
}
