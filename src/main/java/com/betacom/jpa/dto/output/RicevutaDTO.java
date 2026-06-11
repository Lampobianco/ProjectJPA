package com.betacom.jpa.dto.output;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class RicevutaDTO {

	private String nome;
	private String cognome;
	private LocalDate dataPagamento;
	private Long totale;
	private List<PagamentoRicevutoDTO> riga;
}
