package com.oxhpjk.jxc.service;

import com.oxhpjk.jxc.modle.User;

public interface UserServive {
	
	/**
	 * 	��¼��֤
	 * @param user User����
	 * @return �Ƿ�ɹ���¼
	 */
	public boolean login(User user);
	
	/**
	 * 	ȡ�ö���ʵ��
	 * @return 
	 */
	public User getUser();
}
