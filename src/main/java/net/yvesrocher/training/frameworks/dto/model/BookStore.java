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

	private String name;

	private String city;

	private Set<Book> books = new HashSet<Book>();

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
