package com.oxhpjk.jxc.service.impl;
/**
 * �ͻ�ʵ��
 * @author 22161
 *
 */

import java.util.List;

import com.oxhpjk.jxc.dao.CustomerDao;
import com.oxhpjk.jxc.model.Customer;
import com.oxhpjk.jxc.service.CustomerService;

/**
 * �ͻ�ҵ��ʵ����
 * 
 * @author FPF
 *
 */
public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao = null;

	/**
	 * ��ӿͻ���Ϣ
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
	 * ��̬���ɿͻ����
	 */
	@Override
	public String getCustomerId() {
		customerDao = new CustomerDao();
		return customerDao.getId();
	}

	/**
	 * ��ѯ�ͻ���Ϣ
	 * 
	 * @return
	 */
	@Override
	public List<Customer> findCustomers(Customer c) {
		customerDao = new CustomerDao();
		return customerDao.query(c);
	}

	/**
	 * ���ݿͻ�����޸Ŀͻ���Ϣ
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
	 * ���ݿͻ�����޸�available
	 * @param id���ͻ����
	 * @param available��0:��ʾɾ����1��ʾ�һ�
	 * @return
	 */
	@Override
	public boolean updateCustomer(String id,Integer available) {
		customerDao = new CustomerDao();
		return customerDao.update(id, available);
	}
}
