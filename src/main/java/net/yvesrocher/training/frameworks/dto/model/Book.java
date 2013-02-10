package net.yvesrocher.training.frameworks.dto.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Référence d'un livre
 *
 * @author Thomas Duchatelle
 */
@Entity
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

	/** Auteur principal du livre */
	private Author author;

	public Book() {
	}

	public Book(final String isbn, final String title, final String description, final Date publication, final long pages) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.publication = publication;
		this.pages = pages;
	}

	@Id
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(final String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Date getPublication() {
		return publication;
	}

	public void setPublication(final Date publication) {
		this.publication = publication;
	}

	public long getPages() {
		return pages;
	}

	public void setPages(final long pages) {
		this.pages = pages;
	}

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
	@JoinColumn(name = "author_id")
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(final Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", publication=" + publication + ", pages=" + pages + ", author=" + author + "]";
	}

}
