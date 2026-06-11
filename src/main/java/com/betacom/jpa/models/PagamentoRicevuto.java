package com.betacom.jpa.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "pagamenti_ricevuti")
public class PagamentoRicevuto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String descrizione;

	@Column(nullable = false)
	private Long prezzo;

	@Column(name = "data_pagamento", nullable = false)
	private LocalDate dataPagamento;

	@ManyToOne
	@JoinColumn(
			name = "abbonamento_id",
			foreignKey = @ForeignKey(name = "fk_pagamento_abbonamento")
	)
	private Abbonamento abbonamento;
}
