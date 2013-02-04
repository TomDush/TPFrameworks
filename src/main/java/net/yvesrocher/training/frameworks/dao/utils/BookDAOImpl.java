package net.yvesrocher.training.frameworks.dao.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import net.yvesrocher.training.frameworks.dto.model.Book;

@Named
public class BookDAOImpl implements IBookDAO {

	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public Book findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<Book>(0);
	}

	@Override
	public String toString() {
		return "BookDAOImpl [findAll()=" + findAll() + "]";
	}


}
