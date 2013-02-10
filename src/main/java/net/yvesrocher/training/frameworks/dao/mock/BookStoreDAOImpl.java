package net.yvesrocher.training.frameworks.dao.mock;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import net.yvesrocher.training.frameworks.dao.IBookStoreDAO;
import net.yvesrocher.training.frameworks.dto.model.BookCopy;
import net.yvesrocher.training.frameworks.dto.model.BookStore;

public class BookStoreDAOImpl implements IBookStoreDAO {

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
	}

	@Override
	public BookCopy findBookCopyById(Serializable id) {
		return copies.get(id);
	}

	@Override
	public synchronized String generateNewCode() {
		return "copycode_" + codeCount++;
	}

}
