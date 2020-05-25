package com.oxhpjk.jxc.model;
/**
 * 供应商实体类（对应的是t_provider）
 * 
 * @author FPF
 *
 */
public class Provider extends Person {
	public Provider() {
		super();
	}

	public Provider(String id, String providerName, String shorts, String address, String zip, String telephone,
			String fax, String contacts, String phone, String bank, String account, String mail, int available) {
		super(id, providerName, shorts, address, zip, telephone, fax, contacts, phone, bank, account, mail, available);
	}
}

