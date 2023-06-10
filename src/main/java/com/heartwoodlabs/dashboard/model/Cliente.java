package com.heartwoodlabs.dashboard.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String nome, cognome;

	@Column(name = "codice_fiscale")
	private String codiceFiscale;

	@Column(name = "data_registrazione")
	private LocalDateTime dataRegistrazione;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public LocalDateTime getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(LocalDateTime dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Cliente cliente = (Cliente) o;
		return Objects.equals(id, cliente.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
