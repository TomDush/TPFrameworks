package net.yvesrocher.training.frameworks.dao.mock;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import net.yvesrocher.training.frameworks.dao.ICustomerDAO;
import net.yvesrocher.training.frameworks.dto.model.Customer;

public class CustomerDAOImpl implements ICustomerDAO {

	private Map<Integer, Customer> customers = new HashMap<Integer, Customer>();

	@Override
	public Customer findById(Serializable id) {
		return customers.get(id);
	}

	@Override
	public void save(Customer customer) {
		customers.put(customer.getCustomerId(), customer);
	}

}
