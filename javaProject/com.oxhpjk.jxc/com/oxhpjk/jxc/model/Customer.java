package com.oxhpjk.jxc.model;
/**
 * �ͻ�ʵ���࣬��Ӧt_customer��
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
