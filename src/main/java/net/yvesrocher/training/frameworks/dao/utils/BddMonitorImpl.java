package net.yvesrocher.training.frameworks.dao.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import net.yvesrocher.training.frameworks.dao.IBookDAO;
import net.yvesrocher.training.frameworks.dao.IBookStoreDAO;
import net.yvesrocher.training.frameworks.dao.ICustomerDAO;
import net.yvesrocher.training.frameworks.dto.model.Author;
import net.yvesrocher.training.frameworks.dto.model.Book;
import net.yvesrocher.training.frameworks.dto.model.BookCopy;
import net.yvesrocher.training.frameworks.dto.model.BookStore;
import net.yvesrocher.training.frameworks.dto.model.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BddMonitorImpl implements IBddMonitor {

	private static final Logger LOGGER = LoggerFactory.getLogger(BddMonitorImpl.class);

	private static DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

	@Inject
	private IBookDAO bookDAO;

	@Inject
	private IBookStoreDAO bookStoreDAO;

	@Inject
	private ICustomerDAO customerDAO;

	/**
	 * Remarque : PostContruct indique la méthode à appeler dès que le bean est instancié et que toutes ses dépendances sont prêtes.
	 *
	 * @throws ParseException
	 */
	@PostConstruct
	public void initDatabase() throws ParseException {
		LOGGER.info("Initialize database ...");

		// ** livres
		List<Book> books = generateBooks();
		addAuthorToBook(books);

		for (Book b : books) {
			bookDAO.saveOrUpdate(b);
		}

		// ** Librairies + copies
		List<BookStore> bookStores = generateBookStores();
		addCopies(bookStores, books);
		for (BookStore store : bookStores) {
			bookStoreDAO.save(store);
		}

		// ** Clients
		customerDAO.save(new Customer("Tony", "Stark", "ironman@stark.com"));
		customerDAO.save(new Customer("Hulk", "", "hulk@avengers.com"));
		customerDAO.save(new Customer("Yves", "Rocher", "yver.rocher@yrnet.com"));
	}

	@Override
	public void printAll() {
		LOGGER.info("Customers :");
		for (Customer c : customerDAO.findAll()) {
			LOGGER.info("\t- {}", c);
		}

		LOGGER.info("Books :");
		for (Book b : bookDAO.findAll()) {
			LOGGER.info("\t- {}", b);
		}

		LOGGER.info("BookStores :");
		for (BookStore s : bookStoreDAO.findAll()) {
			LOGGER.info("\t- {}", s);
			for (BookCopy c : s.getBookCopies()) {
				LOGGER.info("\t\t. {}", c);
			}
		}

	}

	private static void addCopies(List<BookStore> bookStores, List<Book> books) {
		int code = 0;

		int i = 0;
		for (Book b : books) {
			if (i < 4) bookStores.get(0).addCopy(new BookCopy("copy_" + code++, b));
			if (i % 2 == 0) bookStores.get(1).addCopy(new BookCopy("copy_" + code++, b));
			bookStores.get(2).addCopy(new BookCopy("copy_" + code++, b));

			i++;
		}
	}

	/**
	 * Génère une liste de livres
	 *
	 * @return
	 * @throws ParseException
	 */
	private static List<Book> generateBooks() throws ParseException {
		List<Book> books = new ArrayList<Book>(8);
		books.add(new Book("9780828850780", "Le Temple Du Soleil", "Les Aventures de Tintin - Tome 14", dateFormatter.parse("1946-04-26"), 62L));
		books.add(new Book("9780785955757", "Tintin au Congo", "Les Aventures de Tintin - Tome 2", dateFormatter.parse("1930-06-05"), 62L));
		books.add(new Book("9780828850537", "On a marché sur la Lune", "Les Aventures de Tintin - Tome 17", dateFormatter.parse("1954-03-30"), 62L));

		books.add(new Book("2-8036-0358-6", "La Magicienne trahie", "Thorgal - Tome 1", dateFormatter.parse("1980-01-01"), 46L));
		books.add(new Book("2-8036-0448-5", "L'Enfant des étoiles", "Thorgal - Tome 17", dateFormatter.parse("1984-09-01"), 46L));
		books.add(new Book("2-8036-0639-9", "La Cité du dieu perdu", "Thorgal - Tome 17", dateFormatter.parse("1987-10-01"), 46L));

		books.add(new Book("978-2-07-041239", "Le Rouge Et Le Noir", "Bon courage...", dateFormatter.parse("1930-11-01"), 830L));
		books.add(new Book("978-2876770725", "L'Histoire Sans Fin", "Vous aussi, plongez dans le monde de Fantasia", dateFormatter.parse("1979-01-01"), 535L));

		return books;
	}

	private static List<BookStore> generateBookStores() {
		List<BookStore> stores = new ArrayList<BookStore>(3);
		stores.add(new BookStore("Dialogues", "Brest"));
		stores.add(new BookStore("Blaizot", "Paris"));
		stores.add(new BookStore("Skylight", "Los Feliz"));

		return stores;
	}

	/**
	 * Génère une liste d'auteur et l'associe avec les livres générés par {@link #generateBooks()}
	 *
	 * @param books
	 * @return
	 */
	private static List<Author> addAuthorToBook(List<Book> books) {
		List<Author> authors = new ArrayList<Author>();
		authors.add(new Author("Hergé", null));
		authors.add(new Author("Jean", "Van Hamme"));
		authors.add(new Author("Stendhal", ""));
		authors.add(new Author("Michael", "Ende"));

		if (books.size() >= 8) {
			books.get(0).setAuthor(authors.get(0));
			books.get(1).setAuthor(authors.get(0));
			books.get(2).setAuthor(authors.get(0));

			books.get(3).setAuthor(authors.get(1));
			books.get(4).setAuthor(authors.get(1));
			books.get(5).setAuthor(authors.get(1));

			books.get(6).setAuthor(authors.get(2));

			books.get(7).setAuthor(authors.get(3));
		}

		return authors;
	}
}
