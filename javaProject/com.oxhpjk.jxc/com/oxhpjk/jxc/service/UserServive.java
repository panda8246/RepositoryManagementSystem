package com.oxhpjk.jxc.service;

import com.oxhpjk.jxc.modle.User;

public interface UserServive {
	
	/**
	 * 	登录验证
	 * @param user User对象
	 * @return 是否成功登录
	 */
	public boolean login(User user);
	
	/**
	 * 	取得对象实例
	 * @return 
	 */
	public User getUser();
}
