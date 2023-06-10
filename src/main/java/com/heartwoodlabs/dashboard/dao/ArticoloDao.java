package com.heartwoodlabs.dashboard.dao;

import com.heartwoodlabs.dashboard.dto.ArticoloDto;
import com.heartwoodlabs.dashboard.model.Articolo;

import java.util.List;

public class ArticoloDao extends BaseDao {

	public List<ArticoloDto> articoliPiuVenduti(int limit) {
		//@formatter:off
		String query = "select new com.heartwoodlabs.dashboard.dto.ArticoloDto(sum(a.quantita), p.nome) " +
				"from " + Articolo.class.getName() + " a " +
				"join a.prodotto as p " +
				"group by p.nome " +
				"order by 1 desc, 2 ";
		//@formatter:on
		return entityManager.createQuery(query).setMaxResults(limit).getResultList();
	}
}
