package net.yvesrocher.training.frameworks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

		// TODO Ecrire le code de mapping

		LOGGER.info("Done.");
	}

	private static List<Book> generateBooks() throws ParseException {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("Le Temple Du Soleil", "Les Aventures de Tintin - Tome 14", dateFormatter.parse("1946-04-26"), 62L));
		books.add(new Book("Tintin au Congo", "Les Aventures de Tintin - Tome 2", dateFormatter.parse("1930-06-05"), 62L));
		books.add(new Book("On a marché sur la Lune", "Les Aventures de Tintin - Tome 17", dateFormatter.parse("1954-03-30"), 62L));

		books.add(new Book("La Magicienne trahie", "Thorgal - Tome 1", dateFormatter.parse("1980-01-01"), 46L));
		books.add(new Book("L'Enfant des étoiles", "Thorgal - Tome 17", dateFormatter.parse("1984-09-01"), 46L));
		books.add(new Book("La Cité du dieu perdu", "Thorgal - Tome 17", dateFormatter.parse("1987-10-01"), 46L));

		books.add(new Book("Le Rouge Et Le Noir", "Bon courage...", dateFormatter.parse("1987-10-01"), 46L));
		books.add(new Book("L'Histoire Sans Fin", "Vous aussi, plongez dans le monde de Fantasia", dateFormatter.parse("1979-01-01"), 46L));

		return books;
	}

	private static Book generateBook() throws ParseException {
		return generateBooks().get(0);
	}

}
