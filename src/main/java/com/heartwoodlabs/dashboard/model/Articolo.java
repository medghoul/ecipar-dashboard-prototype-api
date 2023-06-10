package com.heartwoodlabs.dashboard.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "articolo")
public class Articolo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(nullable = false)
	private BigDecimal prezzo;

	@Column(nullable = false)
	private Integer quantita;

	@ManyToOne
	@JoinColumn(name = "prodotto_id", nullable = false)
	private Prodotto prodotto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Articolo articolo = (Articolo) o;
		return Objects.equals(id, articolo.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
