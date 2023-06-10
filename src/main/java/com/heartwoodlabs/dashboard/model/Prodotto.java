package com.heartwoodlabs.dashboard.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "prodotto")
public class Prodotto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String nome;
	private BigDecimal prezzo;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Prodotto prodotto = (Prodotto) o;
		return Objects.equals(id, prodotto.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
