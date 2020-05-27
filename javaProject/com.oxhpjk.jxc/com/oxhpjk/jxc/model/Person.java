package com.oxhpjk.jxc.model;

import com.oxhpjk.jxc.commom.ValidationManager;

/**
 * 提取供应商和客户的公共信息
 * @author 
 *
 */
public class Person {
	private String id;// 编号
	private String customerName;// 客户全称
	private String shorts;// 客户简称
	private String address;// 客户地址
	private String zip;// 客户邮编
	private String telephone;// 客户电话
	private String fax;// 传真
	private String contacts;// 联系人
	private String phone;// 联系人电话
	private String bank;// 开户银行
	private String account;// 银行账户
	private String mail;// 邮箱
	private int available;// 是否可用，1，可用，0不可用
	
	public Person() {
		super();
	}

	public Person(String id, String customerName, String shorts, String address, String zip, String telephone,
			String fax, String contacts, String phone, String bank, String account, String mail, int available) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.shorts = shorts;
		this.address = address;
		this.zip = zip;
		this.telephone = telephone;
		this.fax = fax;
		this.contacts = contacts;
		this.phone = phone;
		this.bank = bank;
		this.account = account;
		this.mail = mail;
		this.available = available;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getShorts() {
		return shorts;
	}

	public void setShorts(String shorts) {
		this.shorts = shorts;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}
	/**
	 * 表格控件调用
	 * @param columnNumber
	 * @return
	 */
    public Object getValue(Integer columnNumber) {
    	switch (columnNumber) {
		case 0://编号
			  return ValidationManager.changeNull(getId());
		case 1://名字
			  return ValidationManager.changeNull(getCustomerName());
		case 2://简称
			  return ValidationManager.changeNull(getShorts());
		case 3://地址
			  return ValidationManager.changeNull(getAddress());
		case 4://邮编
			  return ValidationManager.changeNull(getZip());
		case 5://电话
			  return ValidationManager.changeNull(getTelephone());
		case 6://传真
			  return ValidationManager.changeNull(getFax());
		case 7://联系人
			  return ValidationManager.changeNull(getContacts());
		case 8://联系电话
			  return ValidationManager.changeNull(getPhone());
		case 9://开户银行
			  return ValidationManager.changeNull(getBank());
		case 10://银行账户
			  return ValidationManager.changeNull(getAccount());
		case 11://邮箱
			  return ValidationManager.changeNull(getMail());
		default:
			return "";
			
		}
    }

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", shorts=" + shorts + ", address=" + address
				+ ", zip=" + zip + ", telephone=" + telephone + ", fax=" + fax + ", contacts=" + contacts + ", phone="
				+ phone + ", bank=" + bank + ", account=" + account + ", mail=" + mail + ", available=" + available
				+ "]";
	}

}

