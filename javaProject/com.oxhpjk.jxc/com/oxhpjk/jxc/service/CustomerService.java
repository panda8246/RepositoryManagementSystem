package com.oxhpjk.jxc.service;

import java.util.List;

import com.oxhpjk.jxc.model.Customer;

/**
 * �ͻ�ҵ��ӿ�
 * 
 * @author FPF
 *
 */
public interface CustomerService {
	/**
	 * ��ӿͻ���Ϣ
	 * 
	 * @param customer
	 * @return
	 */
	public  boolean addCustomer(Customer customer) ;
		

	/**
	 * ���ɿͻ����
	 * 
	 * @return
	 */
	public String getCustomerId();

	/**
	 * ��ѯ�ͻ���Ϣ
	 * 
	 * @return
	 */
	public List<Customer> findCustomers(Customer c);

	/**
	 * ���ݿͻ�����޸Ŀͻ���Ϣ
	 * 
	 * @param customer
	 * @return
	 */
	public boolean updateCustomer(Customer customer);

	/**
 	 * ���ݿͻ�����޸�available
 	 * @param id���ͻ����
 	 * @param available��0:��ʾɾ����1��ʾ�һ�
 	 * @return
 	 */
 	public boolean updateCustomer(String id,Integer available);
}

