package net.yvesrocher.training.frameworks.dao;

import java.io.Serializable;
import java.util.List;

import net.yvesrocher.training.frameworks.dto.model.Customer;

public interface ICustomerDAO {

	Customer findById(Serializable id);

	void save(Customer customer);

	List<Customer> findAll();
}
