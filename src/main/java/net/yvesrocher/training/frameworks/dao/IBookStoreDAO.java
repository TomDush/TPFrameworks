package net.yvesrocher.training.frameworks.dao;

import java.io.Serializable;

import net.yvesrocher.training.frameworks.dto.model.BookCopy;
import net.yvesrocher.training.frameworks.dto.model.BookStore;

public interface IBookStoreDAO {

	/**
	 * Recherche par id BDD.
	 * @param id
	 * @return
	 */
	BookStore findById(Serializable id);

	/**
	 * Rencherche par nom
	 * @param name
	 * @return
	 */
	BookStore findByName(String name);

	/**
	 * Sauvegarde
	 * @param bookStore
	 */
	void save(BookStore bookStore);

	/**
	 * Retrouve un exemplaire à partir de son code
	 * @param id
	 * @return TODO
	 */
	BookCopy findBookCopyById(Serializable id);

	/**
	 * Génère un nouveau code d'exemplaire
	 * @return
	 */
	String generateNewCode();
}
