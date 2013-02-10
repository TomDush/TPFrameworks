package net.yvesrocher.training.frameworks.dto.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Exemplaire d'un livre.
 *
 * <p>
 * Si on veut vraiment aller plus loin, la librairie n'a pas de {@link Book}, mais des <b>exemplaires de livres</b>. Ces mêmes exemplaires qui peuvent être prétés à
 * des {@link Customer}.
 * </p>
 *
 * @author Thomas Duchatelle
 */
@Entity
public class BookCopy implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Référence de l'exemplaire (code barre sur le côté par exemple)
	 */
	private String code;

	/**
	 * Livre dont il est la copie
	 */
	private Book book;

	/**
	 * Librairie dans laquelle l'exemplaire se trouve.
	 */
	private BookStore bookStore;

	/**
	 * Client qui l'a emprunté (ou null si disponible).
	 */
	private Customer borrower;

	public BookCopy() {
	}

	public BookCopy(String code, Book book) {
		this.code = code;
		this.book = book;
	}

	@Id
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/** Aucune cascade définie */
	@ManyToOne(optional = false)
	@JoinColumn(name = "book_id")
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	/** Aucune cascade définie */
	@ManyToOne(optional = false)
	@JoinColumn(name = "bookstore_id")
	public BookStore getBookStore() {
		return bookStore;
	}

	public void setBookStore(BookStore bookStore) {
		this.bookStore = bookStore;
	}

	@ManyToOne(optional = true)
	@JoinColumn(name = "customer_id")
	public Customer getBorrower() {
		return borrower;
	}

	public void setBorrower(Customer borrower) {
		this.borrower = borrower;
	}

	@Override
	public String toString() {
		return "BookCopy [code=" + code + ", book=" + book + ", borrower=" + borrower + "]";
	}
}
