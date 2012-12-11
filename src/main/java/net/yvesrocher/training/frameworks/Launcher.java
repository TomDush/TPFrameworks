package net.yvesrocher.training.frameworks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import net.yvesrocher.training.frameworks.dao.utils.HibernateUtils;
import net.yvesrocher.training.frameworks.dto.model.Book;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
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
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// Obtention d'une session
		Session session = sessionFactory.openSession();

		// Debut de la transaction
		session.beginTransaction();
		try {
			session.save(generateBook());

			List<Book> books = session.createQuery("FROM Book").list();
			LOGGER.info("Book présents : " + books);

			// throw new RuntimeException("Hahahaha SQL Error !");
			// Commit de la session si c'est OK
			session.getTransaction().commit();

		} catch (Exception e) {
			// On annule tout ce qui a ete fait si une erreur s'est produite
			if (session.getTransaction().isActive()) session.getTransaction().rollback();
			LOGGER.error("SQL Error.", e);

		} finally {
			session.close();
		}

		LOGGER.info("Done.");
	}

	private static Book generateBook() throws ParseException {
		return new Book("Le Temple Du Soleil", "Tintin - Tome 14", dateFormatter.parse("1946-04-26"), 62L);
	}

}
