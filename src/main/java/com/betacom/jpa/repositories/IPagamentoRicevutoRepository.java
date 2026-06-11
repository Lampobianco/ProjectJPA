package com.betacom.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.models.PagamentoRicevuto;

@Repository
public interface IPagamentoRicevutoRepository extends JpaRepository<PagamentoRicevuto, Integer> {
	List<PagamentoRicevuto> findByAbbonamentoId(Integer abbonamentoId);
}
