package net.yvesrocher.training.frameworks.dto.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Client de la librairie
 *
 * @author Thomas Duchatelle
 */
public class Customer implements Serializable {

	private static final long serialVersionUID = -8183377620543222179L;

	private Integer customerId;

	private String name;

	private String email;

	/** Livres empruntés */
	private Set<BookCopy> borrowedBooks = new HashSet<BookCopy>();

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<BookCopy> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(Set<BookCopy> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}
}
