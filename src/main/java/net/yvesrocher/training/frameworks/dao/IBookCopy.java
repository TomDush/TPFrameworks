package net.yvesrocher.training.frameworks.dao;

import java.io.Serializable;

import net.yvesrocher.training.frameworks.dto.model.BookCopy;

/**
 * DAO pour accéder aux exemplaire de livres
 *
 * @author Thomas Duchatelle
 */
public interface IBookCopy {

	/**
	 * Retrouve un exemplaire à partir de son code
	 *
	 * @param id
	 * @return Exemplaire ou null si non trouvé.
	 */
	BookCopy findBookCopyByCode(Serializable id);

	/**
	 * Génère un nouveau code d'exemplaire
	 *
	 * @return
	 */
	String generateNewCode();
}
