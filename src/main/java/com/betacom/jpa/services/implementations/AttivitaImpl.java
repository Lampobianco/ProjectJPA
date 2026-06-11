package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.input.AttivitaReq;
import com.betacom.jpa.dto.output.AttivitaDTO;
import com.betacom.jpa.mapping.AttivitaMap;
import com.betacom.jpa.models.Attivita;
import com.betacom.jpa.repositories.IAttivitaRepository;
import com.betacom.jpa.services.interfaces.IAttivitaServices;

import exceptions.AcademyException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class AttivitaImpl implements IAttivitaServices {

	private final IAttivitaRepository repA;

	@Transactional
	@Override
	public void create(AttivitaReq req) throws Exception {
		log.debug("create {}", req);
		if (req.getDescrizione() == null)
			throw new AcademyException("Descrizione non caricata");
		if (req.getPrezzo() == null)
			throw new AcademyException("Prezzo non caricato");
		Attivita a = new Attivita();
		a.setDescrizione(req.getDescrizione());
		a.setPrezzo(req.getPrezzo());
		repA.save(a);
	}

	@Transactional
	@Override
	public void update(AttivitaReq req) throws Exception {
		log.debug("update {}", req);
		Attivita a = repA.findById(req.getId())
				.orElseThrow(() -> new AcademyException("Attivita non trovata"));
		if (req.getDescrizione() != null)
			a.setDescrizione(req.getDescrizione());
		if (req.getPrezzo() != null)
			a.setPrezzo(req.getPrezzo());
		repA.save(a);
	}

	@Transactional
	@Override
	public void delete(Integer id) throws Exception {
		log.debug("delete {}", id);
		Attivita a = repA.findById(id)
				.orElseThrow(() -> new AcademyException("Attivita non trovata"));
		repA.delete(a);
	}


@Override
	public List<AttivitaDTO> list() throws Exception {
		log.debug("list");
		return AttivitaMap.buildAttivitaDTOList(repA.findAll());
	}

	@Override
	public AttivitaDTO getById(Integer id) throws Exception {
		log.debug("getById {}", id);
		Attivita a = repA.findById(id)
				.orElseThrow(() -> new AcademyException("Attivita non trovata"));
		return AttivitaMap.buildAttivitaDTO(a);
	}

}
