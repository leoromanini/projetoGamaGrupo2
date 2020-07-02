package com.bugados.backend.dao;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bugados.backend.model.Transacao;
import com.bugados.backend.model.TransacaoStatus;

public interface TransacaoStatusDAO extends CrudRepository<Transacao, Integer> {

	
    @Query("select count(t.status)as contStatus, t.status from Transacao t where t.agFinanceiro = :ag_Financeiro group by t.status")
   	public ArrayList<TransacaoStatus> findStatus(int ag_Financeiro);
}
