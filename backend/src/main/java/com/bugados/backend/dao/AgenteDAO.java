package com.bugados.backend.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bugados.backend.model.Agente;

public interface AgenteDAO extends CrudRepository<Agente, Integer>{

	public List<Agente> findTop10ByVolumeTransacional();
	
}
