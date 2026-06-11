package com.betacom.jpa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.input.AbbonamentoReq;
import com.betacom.jpa.dto.output.ResponseDTO;
import com.betacom.jpa.services.interfaces.IAbbonamentoServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/abbonamento")
public class AbbonamentoController {

	private final IAbbonamentoServices abbS;

	@PostMapping("create")
	public ResponseEntity<ResponseDTO> create(@RequestBody(required = true) AbbonamentoReq req) {
		ResponseDTO r = new ResponseDTO();
		HttpStatus status = HttpStatus.OK;
		try {
			abbS.create(req);
			r.setMsg("created...");
		} catch (Exception e) {
			r.setMsg(e.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
	}

	@PutMapping("update")
	public ResponseEntity<ResponseDTO> update(@RequestBody(required = true) AbbonamentoReq req) {
		ResponseDTO r = new ResponseDTO();
		HttpStatus status = HttpStatus.OK;
		try {
			abbS.update(req);
			r.setMsg("updated...");
		} catch (Exception e) {
			r.setMsg(e.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
	}

	@GetMapping("getAbbonamentoById")
	public ResponseEntity<Object> getAbbonamentoById(@RequestParam(required = true) Integer id) {
		Object r = new Object();
		HttpStatus status = HttpStatus.OK;
		try {
			r = abbS.getAbbonamentoById(id);
		} catch (Exception e) {
			r = e.getMessage();
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
	}

	@PostMapping("addAttivita")
	public ResponseEntity<ResponseDTO> addAttivita(@RequestBody(required = true) AbbonamentoReq req) {
		ResponseDTO r = new ResponseDTO();
		HttpStatus status = HttpStatus.OK;
		try {
			abbS.createAbbonamentoAttivita(req);
			r.setMsg("created...");
		} catch (Exception e) {
			r.setMsg(e.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
	}

	@DeleteMapping("deleteAttivita/{id}/{attivitaID}")
	public ResponseEntity<ResponseDTO> deleteAttivita(
			@PathVariable(required = true) Integer id,
			@PathVariable(required = true) Integer attivitaID) {
		ResponseDTO r = new ResponseDTO();
		HttpStatus status = HttpStatus.OK;
		try {
			abbS.deleteAbbonamentoAttivita(id, attivitaID);
			r.setMsg("deleted...");
		} catch (Exception e) {
			r.setMsg(e.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
	}

	@GetMapping("buildRicevuta")
	public ResponseEntity<Object> buildRicevuta(@RequestParam(required = true) Integer id) {
		Object r = new Object();
		HttpStatus status = HttpStatus.OK;
		try {
			r = abbS.buildRicevuta(id);
		} catch (Exception e) {
			r = e.getMessage();
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
	}

	@DeleteMapping("delete/{id}/{socioId}")
	public ResponseEntity<ResponseDTO> delete(
			@PathVariable(required = true) Integer id,
			@PathVariable(required = true) Integer socioId) {
		ResponseDTO r = new ResponseDTO();
		HttpStatus status = HttpStatus.OK;
		try {
			abbS.delete(id, socioId);
			r.setMsg("deleted...");
		} catch (Exception e) {
			r.setMsg(e.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
	}
}
