package com.betacom.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.models.Socio;

@Repository
public interface ISocioRepository extends JpaRepository<Socio, Integer>{
	Boolean existsByCodiceFiscale(String codiceFiscale);

	List<Socio> searchByCognome(@Param("cognome") String cognome);

	List<Socio> findByCognomeLike(String cognome);
	List<Socio> findByCognomeStartingWith(String cognome);

	@Query(name = "socio.selectByAttivita")
	List<Socio> selectByAttivita(@Param("id") Integer id);

	@Query(name = "socio.search")
	List<Socio> search(@Param("nome") String nome, @Param("cognome") String cognome, @Param("attivitaId") Integer attivitaId);
}
