package com.oxhpjk.jxc.modle;
/**
 * 用户
 * @author pjk
 *
 */
public class User {
	
	private String account;
	private String password;
	private String name;
	private int access_level;		//权限等级： 0为最高级用户管理员
	
	public User() {}
		
	public User(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public User(String account, String password, String name, int access_level) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
		this.access_level = access_level;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public int getAccess_level() {
		return access_level;
	}

	public void setAccess_level(int access_level) {
		this.access_level = access_level;
	}
	
	
}
