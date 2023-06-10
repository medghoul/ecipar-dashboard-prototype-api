package com.heartwoodlabs.dashboard.dao;

import com.heartwoodlabs.dashboard.dto.VenditaClienteDto;
import com.heartwoodlabs.dashboard.dto.VenditaMensileDto;
import com.heartwoodlabs.dashboard.model.Vendita;

import java.util.List;

public class VenditaDao extends BaseDao {

	public List<VenditaMensileDto> venditeMensili(int year, int month) {
		//@formatter:off
		String query = "select new com.heartwoodlabs.dashboard.dto.VenditaMensileDto(sum(v.prezzo), day(v.data)) " +
				"from " + Vendita.class.getName() + " v " +
				"where year(v.data) = :year and month(v.data) = :month " +
				"group by day(v.data) " +
				"order by 2";
		//@formatter:on
		return entityManager.createQuery(query).setParameter("year", year).setParameter("month", month).getResultList();
	}

	public List<VenditaClienteDto> venditeClienti(int limit) {
		//@formatter:off
		String query = "select new com.heartwoodlabs.dashboard.dto.VenditaClienteDto(sum(v.prezzo), concat(c.nome, ' ', c.cognome)) " +
				"from " + Vendita.class.getName() + " v " +
				"join v.cliente c " +
				"group by 2 " +
				"order by 1 desc";
		//@formatter:on
		return entityManager.createQuery(query).setMaxResults(limit).getResultList();
	}
}
