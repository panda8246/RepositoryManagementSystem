package com.oxhpjk.jxc.service.impl;
/**
 * 客户实现
 * @author 22161
 *
 */

import java.util.List;

import com.oxhpjk.jxc.dao.CustomerDao;
import com.oxhpjk.jxc.model.Customer;
import com.oxhpjk.jxc.service.CustomerService;

/**
 * 客户业务实现类
 * 
 * @author FPF
 *
 */
public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao = null;

	/**
	 * 添加客户信息
	 * 
	 * @param customer
	 * @return
	 */
	@Override
	public boolean addCustomer(Customer customer) {
		customerDao = new CustomerDao();
		return customerDao.save(customer);
	}

	/**
	 * 动态生成客户编号
	 */
	@Override
	public String getCustomerId() {
		customerDao = new CustomerDao();
		return customerDao.getId();
	}

	/**
	 * 查询客户信息
	 * 
	 * @return
	 */
	@Override
	public List<Customer> findCustomers(Customer c) {
		customerDao = new CustomerDao();
		return customerDao.query(c);
	}

	/**
	 * 根据客户编号修改客户信息
	 * 
	 * @param customer
	 * @return
	 */
	@Override
	public boolean updateCustomer(Customer customer) {
		customerDao = new CustomerDao();
		return customerDao.update(customer);
	}
	
	/**
	 * 根据客户编号修改available
	 * @param id：客户编号
	 * @param available：0:表示删除，1表示找回
	 * @return
	 */
	@Override
	public boolean updateCustomer(String id,Integer available) {
		customerDao = new CustomerDao();
		return customerDao.update(id, available);
	}
}
