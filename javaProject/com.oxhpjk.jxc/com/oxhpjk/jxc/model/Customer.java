package com.oxhpjk.jxc.model;
/**
 * 客户实体类，对应t_customer表
 * 
 * @author FPF
 *
 */
public class Customer extends Person{

	public Customer() {
		super();
	}

	public Customer(String id, String customerName, String shorts, String address, String zip, String telephone,
			String fax, String contacts, String phone, String bank, String account, String mail, int available) {
		super(id, customerName, shorts, address, zip, telephone, fax, contacts, phone, bank, account, mail, available);
	}


}
