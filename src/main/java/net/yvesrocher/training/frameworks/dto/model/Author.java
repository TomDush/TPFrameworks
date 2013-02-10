package net.yvesrocher.training.frameworks.dto.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Auteur de livres
 *
 * @author Thomas Duchatelle
 */
@Entity
public class Author implements Serializable {

	private static final long serialVersionUID = 5548183857685016228L;

	/** Identifiant BDD */
	private Integer authorId;

	/** Prénom */
	private String firstname;

	/** Nom */
	private String lastname;

	/** Livre dont il est l'auteur principal */
	private Set<Book> books = new HashSet<Book>();

	public Author() {
	}

	public Author(final String firstname, final String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(final Integer authorId) {
		this.authorId = authorId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(final String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(final String lastname) {
		this.lastname = lastname;
	}

	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(final Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstname=" + firstname + ", lastname=" + lastname + ", books size=" + books.size()
				+ "]";
	}
}
