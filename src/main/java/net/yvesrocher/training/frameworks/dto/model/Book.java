package net.yvesrocher.training.frameworks.dto.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Référence d'un livre
 *
 * @author Thomas Duchatelle (duchatelle.thomas@gmail.com)
 */
public class Book implements Serializable {

	private static final long serialVersionUID = -712909801334685151L;

	private Integer bookId;

	private String title;

	private String description;

	private Date publication;

	private long pages;

	// private Author author;

	// private Set<BookStore> bookStores = new HashSet<BookStore>();

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
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

}
