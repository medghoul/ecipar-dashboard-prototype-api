package com.heartwoodlabs.dashboard.dto;

public class ArticoloDto {
	private Long quantita;
	private String nome;

	public ArticoloDto(Long quantita, String nome) {
		this.quantita = quantita;
		this.nome = nome;
	}

	public Long getQuantita() {
		return quantita;
	}

	public String getNome() {
		return nome;
	}
}
