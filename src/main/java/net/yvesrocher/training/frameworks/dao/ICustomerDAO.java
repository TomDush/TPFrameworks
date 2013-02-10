package net.yvesrocher.training.frameworks.dao;

import java.io.Serializable;

import net.yvesrocher.training.frameworks.dto.model.Customer;

public interface ICustomerDAO {

	Customer findById(Serializable id);

	void save(Customer customer);
}
