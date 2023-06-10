package com.heartwoodlabs.dashboard.dto;

import java.math.BigDecimal;

public class VenditaMensileDto {
	private BigDecimal totale;
	private Integer giorno;

	public VenditaMensileDto(BigDecimal totale, Integer giorno) {
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
