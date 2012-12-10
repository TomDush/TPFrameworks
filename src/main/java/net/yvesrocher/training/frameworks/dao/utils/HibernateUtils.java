package net.yvesrocher.training.frameworks.dao.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utilitaires pour créer des sessions hibernate.
 *
 * <p>
 * Instancie le <i>Singleton</i> <code>SessionFactory</code> et fourni des <code>Session</code>.
 * </p>
 *
 * @author Thomas Duchatelle
 */
public class HibernateUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUtils.class);

	private static SessionFactory sessionFactory;

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();

		} catch (Throwable e) {
			LOGGER.error("Initial SessionFactory creation failed.", e);
			throw new RuntimeException(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		if(null == sessionFactory) {
			sessionFactory = buildSessionFactory();
		}
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
