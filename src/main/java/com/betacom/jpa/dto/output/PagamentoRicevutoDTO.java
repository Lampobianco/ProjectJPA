package com.betacom.jpa.dto.output;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class PagamentoRicevutoDTO {

	private String descrizione;
	private Long prezzo;
	private LocalDate dataPagamento;
}
