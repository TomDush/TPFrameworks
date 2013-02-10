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
 * Client de la librairie
 *
 * @author Thomas Duchatelle
 */
@SuppressWarnings("serial")
@Entity
public class Customer implements Serializable {

	/** Indentifiant d'un client */
	private Integer customerId;

	/** Prénom */
	private String firstname;

	/** Nom */
	private String lastname;

	/** Email */
	private String email;

	/** Livres empruntés */
	private Set<BookCopy> borrowedBooks = new HashSet<BookCopy>();

	public Customer() {
	}

	public Customer(String firstname, String lastname, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	@Column(nullable = false, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy = "borrower")
	public Set<BookCopy> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(Set<BookCopy> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstname=" + firstname + ", email=" + email + ", borrowedBooks size="
				+ borrowedBooks.size() + "]";
	}

}
