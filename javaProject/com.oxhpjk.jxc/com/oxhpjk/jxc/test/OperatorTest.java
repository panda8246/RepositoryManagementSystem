package com.oxhpjk.jxc.test;

import org.junit.Test;

import com.oxhpjk.jxc.commom.CommonFactory;
import com.oxhpjk.jxc.dao.OperatorDao;
import com.oxhpjk.jxc.model.Operator;
import com.oxhpjk.jxc.service.OperatorService;

/**
 * 针对operator进行的测试
 * @author 22161
 *
 */
public class OperatorTest {
	/**
	 * 根据用户名和密码进行查询
	 *
	 */
	@Test
	public void testLoginCheck() {
		OperatorService operatorService=CommonFactory.getOperatorService();
		boolean result=operatorService.loginCheck(new Operator("oxh","root"));
		if(result=true) {
			System.out.println("登录成功");
			
		}
		else {
			System.out.println("登录失败");
		}
	}
	/**
	 * 通过登录名查询操作者信息
	 */
	@Test
	public void testGetOperator() {
		OperatorService operatorService=CommonFactory.getOperatorService();
		Operator o=operatorService.getOperator("oxh");
		System.out.println(o);
	}
		
}
