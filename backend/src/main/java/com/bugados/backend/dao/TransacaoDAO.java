package com.bugados.backend.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bugados.backend.model.ListaStatus;
import com.bugados.backend.model.Transacao;


public interface TransacaoDAO extends CrudRepository<Transacao, Integer> {
	
	
	
    @Query("SELECT t FROM Transacao t WHERE t.agFinanceiro = :ag_Financeiro")
	public ArrayList<Transacao> findTransacao(int ag_Financeiro);

    @Query("select count(t.status), t.status from Transacao t where t.agFinanceiro = :ag_Financeiro group by t.status")
   	public ArrayList<ListaStatus> findStatus(int ag_Financeiro);
    
}
