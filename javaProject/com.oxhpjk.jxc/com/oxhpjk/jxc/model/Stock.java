package com.oxhpjk.jxc.model;

public class Stock {
	String id;
	String goods_id;
	int number = 0;
	
	
	public Stock() {
		super();
	}
	public Stock(String id) {
		super();
		this.id = id;
	}
	public Stock(String id, String goods_id, int number) {
		super();
		this.id = id;
		this.goods_id = goods_id;
		this.number = number;
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
	public String getGoods_id() {
		if(goods_id == null) {
			return "";
		}
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
