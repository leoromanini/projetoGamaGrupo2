package com.bugados.backend.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bugados.backend.model.Transacao;



public interface TransacaoDAO extends CrudRepository<Transacao, Integer> {
	
	
	
    @Query("SELECT t FROM Transacao t WHERE t.agFinanceiro = :ag_Financeiro")
	public ArrayList<Transacao> findTransacao(int ag_Financeiro);

    @Query("select count(t.status)as contStatus, t.status from Transacao t where t.agFinanceiro = :ag_Financeiro group by t.status order by t.status")
   	public List<Object[]> findStatus(int ag_Financeiro);
    
}
