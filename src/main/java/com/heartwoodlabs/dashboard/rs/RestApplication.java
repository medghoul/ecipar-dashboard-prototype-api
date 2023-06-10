package com.heartwoodlabs.dashboard.rs;

import com.heartwoodlabs.dashboard.dao.BaseDao;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ApplicationPath("/api")
public class RestApplication extends Application {
	private static final Logger log=LogManager.getLogger(RestApplication.class);

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(ChartResource.class);
		classes.add(JacksonConfiguration.class);
		classes.add(HeadersFilter.class);

		log.info("Configurazione dell'applicazione REST con le classi");
		for (Class<?> aClass:classes){
			log.info(aClass.getName());
		}

		BaseDao.initFactory();

		return classes;
	}
}
