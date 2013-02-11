package net.yvesrocher.training.frameworks.dao.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.yvesrocher.training.frameworks.dao.IBookDAO;
import net.yvesrocher.training.frameworks.dto.model.Book;
import net.yvesrocher.training.frameworks.exceptions.DAOException;

public class BookDAOImpl implements IBookDAO {

	private static Map<String, Book> books = new HashMap<String, Book>();

	@Override
	public Book findBookByIsbn(String isbn) {
		return books.get(isbn);
	}

	@Override
	public void saveOrUpdate(Book book) {
		Book existing = findBookByIsbn(book.getIsbn());
		if (null != existing && existing != book) {
			// si ce n'est pas la même instance, il y a un bug !
			throw new DAOException("Book with isbn '" + book.getIsbn() + "' already exist");
		}

		books.put(book.getIsbn(), book);

	}

	@Override
	public void delete(Book book) {
		books.remove(book.getIsbn());
	}

	@Override
	public List<Book> findAll() {
		return new ArrayList<Book>(books.values());
	}

}
