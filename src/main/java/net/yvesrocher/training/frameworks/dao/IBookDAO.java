package net.yvesrocher.training.frameworks.dao;

import java.util.List;

import net.yvesrocher.training.frameworks.dto.model.Book;

public interface IBookDAO {

	/**
	 * Retrouve un livre à partir de son id (ISBN).
	 * @param isdn
	 * @return TODO
	 */
	Book findBookByIsbn(String isbn);

	/**
	 * Sauvegarde, ou mets à jour, un livre
	 * @param book
	 */
	void saveOrUpdate(Book book);

	/**
	 * Suppprime un livre
	 * @param book
	 */
	void delete(Book book);

	List<Book> findAll();

}
