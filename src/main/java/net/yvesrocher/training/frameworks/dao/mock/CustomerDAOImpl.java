package net.yvesrocher.training.frameworks.dao.mock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.yvesrocher.training.frameworks.dao.ICustomerDAO;
import net.yvesrocher.training.frameworks.dto.model.Customer;

public class CustomerDAOImpl implements ICustomerDAO {

	private Map<Integer, Customer> customers = new HashMap<Integer, Customer>();

	private int currentId = 0;

	@Override
	public Customer findById(Serializable id) {
		return customers.get(id);
	}

	@Override
	public void save(Customer customer) {
		if(customer.getCustomerId() == null) {
			customer.setCustomerId(currentId++);
		}

		customers.put(customer.getCustomerId(), customer);
	}

	@Override
	public List<Customer> findAll() {
		return new ArrayList<Customer>(customers.values());
	}

}
