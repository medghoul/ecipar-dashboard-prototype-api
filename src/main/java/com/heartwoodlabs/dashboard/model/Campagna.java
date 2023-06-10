package com.heartwoodlabs.dashboard.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "campagna")
public class Campagna {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String nome;

	@Column(nullable = false)
	private BigDecimal prezzo;

	@Column(nullable = false)
	private LocalDateTime data;

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

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Campagna vendita = (Campagna) o;
		return Objects.equals(id, vendita.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
