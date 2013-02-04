package net.yvesrocher.training.frameworks.dao.utils;

import java.io.Serializable;
import java.util.List;

import net.yvesrocher.training.frameworks.dto.model.Book;

public interface IBookDAO {

	void save(Book book);

	Book findById(Serializable id);

	void delete(Book book);

	List<Book> findAll();
}
