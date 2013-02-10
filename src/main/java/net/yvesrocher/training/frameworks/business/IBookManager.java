package net.yvesrocher.training.frameworks.business;

import java.util.List;

import net.yvesrocher.training.frameworks.dto.model.Book;
import net.yvesrocher.training.frameworks.dto.model.BookCopy;
import net.yvesrocher.training.frameworks.exceptions.BorrowingException;

/**
 * Point d'entrée de la couche métier du référentiel bouquins.
 *
 */
public interface IBookManager {

	/**
	 * Ajoute une nouvelle référence dans une librairie
	 * @param bookstoreName Nom de la librairie
	 * @param book Livre à ajouter (peut déjà être connu du système)
	 * @param number Nombre d'exemplaire à ajouter
	 */
	List<BookCopy> insertReference(String bookstoreName, Book book, int number);

	/**
	 * Emprunt d'un exemplaire par un client
	 * @param customerId Identifiant du client
	 * @param bookcopyCode Code de l'exemplaire
	 */
	void borrowBook(int customerId, String bookcopyCode) throws BorrowingException;
}
