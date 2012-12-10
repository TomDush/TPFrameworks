package net.yvesrocher.training.frameworks.dto.model;

import java.io.Serializable;

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
	 * Client qui l'a emprunté.
	 */
	private Customer borrower;

	public BookCopy() {
	}

	public BookCopy(String code, Book book) {
		this.code = code;
		this.book = book;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Customer getBorrower() {
		return borrower;
	}

	public void setBorrower(Customer borrower) {
		this.borrower = borrower;
	}
}
