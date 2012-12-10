package net.yvesrocher.training.frameworks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import net.yvesrocher.training.frameworks.dao.utils.HibernateUtils;
import net.yvesrocher.training.frameworks.dto.model.Book;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe de lancement de l'application...
 *
 * @author Thomas Duchatelle
 */
public class Launcher {

	private static final Logger LOGGER = LoggerFactory.getLogger(Launcher.class);

	private static DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// TODO Ecrire le code ici...

		LOGGER.info("Done.");
	}

	private static Book generateBook() throws ParseException {
		return new Book("Le Temple Du Soleil", "Tintin - Tome 14", dateFormatter.parse("1946-04-26"), 62L);
	}

}
