package net.yvesrocher.training.frameworks.dto.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Référence d'un livre
 *
 * @author Thomas Duchatelle
 */
public class Book implements Serializable {

	private static final long serialVersionUID = -712909801334685151L;

	/** Identifiant internationnal du livre (<i>International Standard Book Number</i>) */
	private String isbn;

	/** Titre du livre */
	private String title;

	/** Description */
	private String description;

	/** Date de première publication */
	private Date publication;

	/** Nombre de pages */
	private long pages;

	// TODO gérer l'association vers l'auteur
	// private Author author;

	// TODO gérer l'association vers les librairies
	// private Set<BookStore> bookStores = new HashSet<BookStore>();

	public Book() {
	}

	public Book(String isbn, String title, String description, Date publication, long pages) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.publication = publication;
		this.pages = pages;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublication() {
		return publication;
	}

	public void setPublication(Date publication) {
		this.publication = publication;
	}

	public long getPages() {
		return pages;
	}

	public void setPages(long pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", publication=" + publication + ", pages=" + pages + "]";
	}

}
