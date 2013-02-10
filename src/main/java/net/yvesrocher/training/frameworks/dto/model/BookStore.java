package net.yvesrocher.training.frameworks.dto.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Bibliothèque
 *
 * @author Thomas Duchatelle
 */
@SuppressWarnings("serial")
@Entity
public class BookStore implements Serializable {

	/** Identifiant base de données de la bibliothèque */
	private Integer bookStoreId;

	/** Nom de la librairie */
	private String name;

	/** Ville où est présente la librairie */
	private String city;

	/** Exemplaire des livres */
	private Set<BookCopy> bookCopies = new HashSet<BookCopy>();

	public BookStore() {
	}

	public BookStore(String name, String city) {
		this.name = name;
		this.city = city;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getBookStoreId() {
		return bookStoreId;
	}

	public void setBookStoreId(Integer bookStoreId) {
		this.bookStoreId = bookStoreId;
	}

	@Column(nullable = false, unique = true)
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

	@OneToMany(mappedBy = "bookStore")
	public Set<BookCopy> getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(Set<BookCopy> bookCopies) {
		this.bookCopies = bookCopies;
	}

	@Override
	public String toString() {
		return "BookStore [bookStoreId=" + bookStoreId + ", name=" + name + ", bookCopies=" + bookCopies + "]";
	}

}
