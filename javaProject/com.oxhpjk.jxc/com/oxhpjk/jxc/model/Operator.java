package com.oxhpjk.jxc.model;
/**
 * 操作员实体类
 * @author 22161
 *
 */

public class Operator {
	private   String username;
	private   String password;
	private   String name;
	private   String power;
	

	public Operator() {
		super();
	}
	
	public Operator(String username, String password, String name, String power) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.power = power;
	}
	

	public Operator(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return "Operator [username=" + username + ", password=" + password + ", name=" + name + ", power=" + power
				+ "]";
	}
	
	
}
