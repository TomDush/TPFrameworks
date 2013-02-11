package net.yvesrocher.training.frameworks.dao;

import java.io.Serializable;
import java.util.List;

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
	 * Liste les tous
	 * @return
	 */
	List<BookStore> findAll();
}
