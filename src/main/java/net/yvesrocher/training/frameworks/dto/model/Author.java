package net.yvesrocher.training.frameworks.dto.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Auteur de livres
 *
 * @author Thomas Duchatelle
 */
public class Author implements Serializable {

	private static final long serialVersionUID = 5548183857685016228L;

	private Integer authorId;

	private String firstname;

	private String lastname;

	private Set<Book> books = new HashSet<Book>();

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}
