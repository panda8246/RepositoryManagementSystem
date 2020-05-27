package com.oxhpjk.jxc.model;

import com.oxhpjk.jxc.commom.ValidationManager;

/**
 * ��ȡ��Ӧ�̺Ϳͻ��Ĺ�����Ϣ
 * @author 
 *
 */
public class Person {
	private String id;// ���
	private String customerName;// �ͻ�ȫ��
	private String shorts;// �ͻ����
	private String address;// �ͻ���ַ
	private String zip;// �ͻ��ʱ�
	private String telephone;// �ͻ��绰
	private String fax;// ����
	private String contacts;// ��ϵ��
	private String phone;// ��ϵ�˵绰
	private String bank;// ��������
	private String account;// �����˻�
	private String mail;// ����
	private int available;// �Ƿ���ã�1�����ã�0������
	
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
	 * ���ؼ�����
	 * @param columnNumber
	 * @return
	 */
    public Object getValue(Integer columnNumber) {
    	switch (columnNumber) {
		case 0://���
			  return ValidationManager.changeNull(getId());
		case 1://����
			  return ValidationManager.changeNull(getCustomerName());
		case 2://���
			  return ValidationManager.changeNull(getShorts());
		case 3://��ַ
			  return ValidationManager.changeNull(getAddress());
		case 4://�ʱ�
			  return ValidationManager.changeNull(getZip());
		case 5://�绰
			  return ValidationManager.changeNull(getTelephone());
		case 6://����
			  return ValidationManager.changeNull(getFax());
		case 7://��ϵ��
			  return ValidationManager.changeNull(getContacts());
		case 8://��ϵ�绰
			  return ValidationManager.changeNull(getPhone());
		case 9://��������
			  return ValidationManager.changeNull(getBank());
		case 10://�����˻�
			  return ValidationManager.changeNull(getAccount());
		case 11://����
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

