package com.heartwoodlabs.dashboard.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "vendita")
public class Vendita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(nullable = false)
	private BigDecimal prezzo;

	@Column(nullable = false)
	private LocalDateTime data;

	@ManyToMany
	@JoinTable(name = "vendita_articolo", joinColumns = @JoinColumn(name = "vendita_id"), inverseJoinColumns = @JoinColumn(name = "articolo_id"))
	private List<Articolo> articoli = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

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

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public List<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(List<Articolo> articoli) {
		this.articoli = articoli;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Vendita vendita = (Vendita) o;
		return Objects.equals(id, vendita.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
