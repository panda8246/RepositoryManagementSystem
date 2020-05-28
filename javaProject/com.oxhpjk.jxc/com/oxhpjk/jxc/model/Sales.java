package com.oxhpjk.jxc.model;

import java.util.Date;

/**
 * 	����
 * @author 24349
 *
 */

public class Sales {
	String id;
	int number = 0;
	float price = 0;
	String COMMENT;
	String customer_id;
	Date salestime;
	String operateperson;
	String sponsor;
	String paytype;
	String goods_id;
	
	
	
	public Sales(String id) {
		super();
		this.id = id;
	}
	public Sales(String id, int number, float price, String cOMMENT, String customer_id, Date salestime,
			String operateperson, String sponsor, String paytype, String goods_id) {
		super();
		this.id = id;
		this.number = number;
		this.price = price;
		COMMENT = cOMMENT;
		this.customer_id = customer_id;
		this.salestime = salestime;
		this.operateperson = operateperson;
		this.sponsor = sponsor;
		this.paytype = paytype;
		this.goods_id = goods_id;
	}
	public Sales() {
		super();
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCOMMENT() {
		if(COMMENT == null) {
			return "";
		}
		return COMMENT;
	}
	public void setCOMMENT(String cOMMENT) {
		COMMENT = cOMMENT;
	}
	public String getCustomer_id() {
		if(customer_id == null) {
			return "";
		}
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public Date getSalestime() {
		return salestime;
	}
	public void setSalestime(Date salestime) {
		this.salestime = salestime;
	}
	public String getOperateperson() {
		if(operateperson == null) {
			return "";
		}
		return operateperson;
	}
	public void setOperateperson(String operateperson) {
		this.operateperson = operateperson;
	}
	public String getSponsor() {
		if(sponsor == null) {
			return "";
		}
		return sponsor;
	}
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	public String getPaytype() {
		if(paytype == null) {
			return "";
		}
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public String getGoods_id() {
		if(goods_id == null) {
			return "";
		}
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	
	
}
