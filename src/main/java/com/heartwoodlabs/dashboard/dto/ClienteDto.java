package com.heartwoodlabs.dashboard.dto;

public class ClienteDto {
	private String nome, cognome;
	private String codiceFiscale;
	private String dataRegistrazione;

	public ClienteDto(String nome, String cognome, String codiceFiscale, String dataRegistrazione) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.dataRegistrazione = dataRegistrazione;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public String getDataRegistrazione() {
		return dataRegistrazione;
	}
}
