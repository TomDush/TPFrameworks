package net.yvesrocher.training.frameworks.dao.mock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.yvesrocher.training.frameworks.dao.IBookCopy;
import net.yvesrocher.training.frameworks.dao.IBookStoreDAO;
import net.yvesrocher.training.frameworks.dto.model.BookCopy;
import net.yvesrocher.training.frameworks.dto.model.BookStore;
import net.yvesrocher.training.frameworks.exceptions.DAOException;

import org.apache.commons.lang3.StringUtils;

public class BookStoreDAOImpl implements IBookStoreDAO, IBookCopy {

	/** Librairies indéxée par leur nom (et non leur id !! */
	private static Map<String, BookStore> stores = new HashMap<String, BookStore>();

	private static Map<String, BookCopy> copies = new HashMap<String, BookCopy>();

	private static int codeCount = 0;

	@Override
	public BookStore findById(Serializable id) {
		if (null == id) return null;

		for (BookStore s : stores.values()) {
			if (id.equals(s.getBookStoreId())) return s;
		}
		return null;
	}

	@Override
	public BookStore findByName(String name) {
		return stores.get(name);
	}

	@Override
	public void save(BookStore bookStore) {
		stores.put(bookStore.getName(), bookStore);

		// Sauvegarde des dépendances
		for (BookCopy c : bookStore.getBookCopies()) {
			saveCopy(c);
		}
	}

	private void saveCopy(BookCopy copy) {
		if (StringUtils.isBlank(copy.getCode())) {
			throw new DAOException("BookCopy.code must not be null : " + copy);
		}
		copies.put(copy.getCode(), copy);
	}

	@Override
	public BookCopy findBookCopyByCode(Serializable id) {
		return copies.get(id);
	}

	@Override
	public synchronized String generateNewCode() {
		return "copycode_" + codeCount++;
	}

	@Override
	public List<BookStore> findAll() {
		return new ArrayList<BookStore>(stores.values());
	}

}
