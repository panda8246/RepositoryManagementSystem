package com.oxhpjk.jxc.model;

/**
 * 	³ö¿â
 */

import java.util.Date;

public class Outport {


	String id;
	int number = 0;
	float price = 0;
	String COMMENT;
	String provider_id;
	Date inporttime;
	String operateperson;
	String sponsor;
	String paytype;
	String goods_id;
	
	public Outport() {
		
	}
	
	public Outport(String id) {
		super();
		this.id = id;
	}
	
	
	public Outport(String id, int number, float price, String cOMMENT, String provider_id, Date inporttime,
			String operateperson, String sponsor, String paytype, String goods_id) {
		super();
		this.id = id;
		this.number = number;
		this.price = price;
		COMMENT = cOMMENT;
		this.provider_id = provider_id;
		this.inporttime = inporttime;
		this.operateperson = operateperson;
		this.sponsor = sponsor;
		this.paytype = paytype;
		this.goods_id = goods_id;
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
	public String getProvider_id() {
		if(provider_id == null) {
			return "";
		}
		return provider_id;
	}
	public void setProvider_id(String provider_id) {
		this.provider_id = provider_id;
	}
	public Date getInporttime() {
		return inporttime;
	}
	public void setInporttime(Date inporttime) {
		this.inporttime = inporttime;
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
