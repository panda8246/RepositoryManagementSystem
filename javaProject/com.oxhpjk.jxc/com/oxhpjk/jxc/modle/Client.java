package com.oxhpjk.jxc.modle;
/**
 * 客户实体类
 * @author pjk
 *
 */


public class Client {
	
	private String id;
	private String name;
	private String address;
	private String zip;
	private String email;
	private String phone_number;
	private String contact;
	private String contact_phone_number;
	private String bank;
	private String bank_account;
	private int remark;
	
	
	public Client(String id, String name, String address, String zip, String email, String phone_number, String contact,
			String contact_phone_number, String bank, String bank_account, int remark) {
		//super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.zip = zip;
		this.email = email;
		this.phone_number = phone_number;
		this.contact = contact;
		this.contact_phone_number = contact_phone_number;
		this.bank = bank;
		this.bank_account = bank_account;
		this.remark = remark;
	}


	public Client() {}
	
	public Client(String id) {
		super();
		this.id = id;
	}
	
	
	public String getId() {
		if(id == null) {
			return "";
		}
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		if(name == null) {
			return "";
		}
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		if(address == null) {
			return "";
		}
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		if(zip == null) {
			return "";
		}
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getEmail() {
		if(email == null) {
			return "";
		}
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		if(phone_number == null) {
			return "";
		}
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getContact() {
		if(contact == null) {
			return "";
		}
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getContact_phone_number() {
		if(contact_phone_number == null) {
			return "";
		}
		return contact_phone_number;
	}
	public void setContact_phone_number(String contact_phone_number) {
		this.contact_phone_number = contact_phone_number;
	}
	public String getBank() {
		if(bank == null) {
			return "";
		}
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getBank_account() {
		if(bank_account == null) {
			return "";
		}
		return bank_account;
	}
	public void setBank_account(String bank_account) {
		this.bank_account = bank_account;
	}
	public int getRemark() {
		return remark;
	}
	public void setRemark(int remark) {
		this.remark = remark;
	}
	
}
