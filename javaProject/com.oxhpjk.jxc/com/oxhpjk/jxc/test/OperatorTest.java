package com.oxhpjk.jxc.test;

import org.junit.Test;

import com.oxhpjk.jxc.commom.CommonFactory;
import com.oxhpjk.jxc.dao.OperatorDao;
import com.oxhpjk.jxc.model.Operator;
import com.oxhpjk.jxc.service.OperatorService;

/**
 * ���operator���еĲ���
 * @author 22161
 *
 */
public class OperatorTest {
	/**
	 * �����û�����������в�ѯ
	 *
	 */
	
	public void testLoginCheck() {
		OperatorService operatorService=CommonFactory.getOperatorService();
		boolean result=operatorService.loginCheck(new Operator("oxh","root"));
		if(result=true) {
			System.out.println("��¼�ɹ�");
			
		}
		else {
			System.out.println("��¼ʧ��");
		}
	}
	/**
	 * ͨ����¼����ѯ��������Ϣ
	 */
	@Test
	public void testGetOperator() {
		OperatorService operatorService=CommonFactory.getOperatorService();
		Operator o=operatorService.getOperator("root");
		System.out.println(o);
	}
	
	
	public void testUpdate() {
		OperatorService operatorService=CommonFactory.getOperatorService();
		Operator o=new Operator("root","123","jojo","0");
		System.out.println(operatorService.update(o));
	}
		
}
