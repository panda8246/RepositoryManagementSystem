package com.oxhpjk.jxc.service;

import java.util.List;

import com.oxhpjk.jxc.model.Customer;

/**
 * 客户业务接口
 * 
 * @author FPF
 *
 */
public interface CustomerService {
	/**
	 * 添加客户信息
	 * 
	 * @param customer
	 * @return
	 */
	public  boolean addCustomer(Customer customer) ;
		

	/**
	 * 生成客户编号
	 * 
	 * @return
	 */
	public String getCustomerId();

	/**
	 * 查询客户信息
	 * 
	 * @return
	 */
	public List<Customer> findCustomers(Customer c);

	/**
	 * 根据客户编号修改客户信息
	 * 
	 * @param customer
	 * @return
	 */
	public boolean updateCustomer(Customer customer);

	/**
 	 * 根据客户编号修改available
 	 * @param id：客户编号
 	 * @param available：0:表示删除，1表示找回
 	 * @return
 	 */
 	public boolean updateCustomer(String id,Integer available);
}

