package net.yvesrocher.training.frameworks.dto.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Bibliothèque
 *
 * @author Thomas Duchatelle
 */
public class BookStore implements Serializable {

	private static final long serialVersionUID = 2249977395919228178L;

	/** Nom de la librairie */
	private String name;

	/** Ville où est présente la librairie */
	private String city;

	/** Liste des références disponibles (A COMMENTER POUR LA PARTIE ALLER PLUS LOIN) */
	private Set<Book> books = new HashSet<Book>();

	/** Exemplaire des livres */
	// private Set<BookCopy> bookCopies = new HashSet<BookCopy>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}
