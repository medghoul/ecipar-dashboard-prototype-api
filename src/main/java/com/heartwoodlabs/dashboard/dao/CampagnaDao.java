package com.heartwoodlabs.dashboard.dao;

import com.heartwoodlabs.dashboard.dto.CostoMensileDto;
import com.heartwoodlabs.dashboard.dto.VenditaMensileDto;
import com.heartwoodlabs.dashboard.model.Campagna;
import com.heartwoodlabs.dashboard.model.Vendita;

import java.util.List;

public class CampagnaDao extends BaseDao {

	public List<CostoMensileDto> costiMensili(int year, int month) {
		//@formatter:off
		String query = "select new com.heartwoodlabs.dashboard.dto.CostoMensileDto(sum(v.prezzo), day(v.data)) " +
				"from " + Campagna.class.getName() + " v " +
				"where year(v.data) = :year and month(v.data) = :month " +
				"group by day(v.data) " +
				"order by 2";
		//@formatter:on
		return entityManager.createQuery(query).setParameter("year", year).setParameter("month", month).getResultList();
	}
}
