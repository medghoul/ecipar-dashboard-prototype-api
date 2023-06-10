package com.heartwoodlabs.dashboard.dto;

import java.math.BigDecimal;

public class VenditaClienteDto {
	private BigDecimal totale;
	private String cliente;

	public VenditaClienteDto(BigDecimal totale, String cliente) {
		this.totale = totale;
		this.cliente = cliente;
	}

	public BigDecimal getTotale() {
		return totale;
	}

	public String getCliente() {
		return cliente;
	}
}
