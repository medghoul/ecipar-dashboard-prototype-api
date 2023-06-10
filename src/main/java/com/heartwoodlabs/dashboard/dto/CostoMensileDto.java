package com.heartwoodlabs.dashboard.dto;

import java.math.BigDecimal;

public class CostoMensileDto {
	private BigDecimal totale;
	private Integer giorno;

	public CostoMensileDto(BigDecimal totale, Integer giorno) {
		this.totale = totale;
		this.giorno = giorno;
	}

	public BigDecimal getTotale() {
		return totale;
	}

	public Integer getGiorno() {
		return giorno;
	}
}
