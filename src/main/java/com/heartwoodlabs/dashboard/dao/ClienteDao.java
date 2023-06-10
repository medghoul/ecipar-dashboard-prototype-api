package com.heartwoodlabs.dashboard.dao;

import com.heartwoodlabs.dashboard.model.Cliente;

import java.util.List;

public class ClienteDao extends BaseDao {
	public List<Cliente> getAll(int limit) {
		String query = "select c from " + Cliente.class.getName() + " c order by c.dataRegistrazione, c.cognome";
		return entityManager.createQuery(query, Cliente.class).setMaxResults(limit).getResultList();
	}
}
