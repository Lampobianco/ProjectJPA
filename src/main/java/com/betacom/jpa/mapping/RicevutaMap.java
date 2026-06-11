package com.betacom.jpa.mapping;

import java.util.List;

import com.betacom.jpa.dto.output.PagamentoRicevutoDTO;
import com.betacom.jpa.dto.output.RicevutaDTO;
import com.betacom.jpa.models.PagamentoRicevuto;

public class RicevutaMap {

	public static RicevutaDTO buildRicevutaDTO(List<PagamentoRicevuto> pagamenti) {
		if (pagamenti.isEmpty())
			return null;
		PagamentoRicevuto primo = pagamenti.get(0);
		Long totale = pagamenti.stream()
				.mapToLong(p -> p.getPrezzo())
				.sum();
		List<PagamentoRicevutoDTO> righe = pagamenti.stream()
				.map(p -> PagamentoRicevutoDTO.builder()
						.descrizione(p.getDescrizione())
						.prezzo(p.getPrezzo())
						.dataPagamento(p.getDataPagamento())
						.build())
				.toList();
		return RicevutaDTO.builder()
				.nome(primo.getAbbonamento().getSocio().getNome())
				.cognome(primo.getAbbonamento().getSocio().getCognome())
				.dataPagamento(primo.getDataPagamento())
				.totale(totale)
				.riga(righe)
				.build();
	}
}
