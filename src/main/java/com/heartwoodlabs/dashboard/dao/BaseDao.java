package com.heartwoodlabs.dashboard.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BaseDao {
	protected static final Logger log=LogManager.getLogger(BaseDao.class);
	private static EntityManagerFactory factory;
	protected EntityManager entityManager;

	BaseDao() {
		entityManager = factory.createEntityManager();
	}

	public void close() {
		entityManager.close();
	}

	public <T> T get(Class<T> entityClass, Long id) {
		return entityManager.find(entityClass, id);
	}

	public <T> List<T> getAll(Class<T> entityClass) {
		String query = "select e from " + entityClass.getName() + " e";
		return entityManager.createQuery(query, entityClass).getResultList();
	}

	public void save(Object entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			log.error("Errore nel salvataggio",e);
			if (entityManager.getTransaction().isActive() || entityManager.getTransaction().getRollbackOnly()) {
				entityManager.getTransaction().rollback();
			}
		}
	}

	public void remove(Object entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			log.error("Errore nella cancellazione",e);
			if (entityManager.getTransaction().isActive() || entityManager.getTransaction().getRollbackOnly()) {
				entityManager.getTransaction().rollback();
			}
		}
	}

	public static void initFactory() {
		log.info("Inizializzazione di JPA in corso...");
		factory = Persistence.createEntityManagerFactory("DefaultPersistenceUnit");
		log.info("Inizializzazione di JPA terminata");
	}

	public static void shutdownFactory() {
		if (factory != null && factory.isOpen()) {
			factory.close();
		}
	}
}
