package com.oxhpjk.jxc.test;

import org.junit.Test;

import com.oxhpjk.jxc.common.Factory;
import com.oxhpjk.jxc.modle.User;
import com.oxhpjk.jxc.service.UserServive;

public class LoginTest {
	
	
	@Test
	public void testLoginCheck() {
		UserServive userServive = Factory.getUserServive();
		boolean result = userServive.login(new User("adim", "123"));
		if(result) {
			System.out.println("��¼�ɹ���");
		}else {
			System.out.println("��¼ʧ�ܣ�");
		}
	}
}
