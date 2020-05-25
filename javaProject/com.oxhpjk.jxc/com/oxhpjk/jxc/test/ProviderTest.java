package com.oxhpjk.jxc.test;

import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import com.oxhpjk.jxc.commom.CommonFactory;
import com.oxhpjk.jxc.commom.Constants;
import com.oxhpjk.jxc.model.Customer;
import com.oxhpjk.jxc.model.Provider;
import com.oxhpjk.jxc.service.CustomerService;
import com.oxhpjk.jxc.service.ProviderService;

public class ProviderTest {
	ProviderService service  = null;
	 /**
	  * ÿ����ִ��@Test����֮ǰ������ִ��һ��
	  */
	 @Before
	 public void init() {
		  service = CommonFactory.getProviderService();
	 }

	/**
	 * ��ӿͻ���Ϣ
	 */
	@Test
	public void testAddProvider() { 
	   Provider p = new Provider(service.getProviderId(), "����Ͱ����޹�˾", "����Ͱ�", "���ݰ���Ͱ��ܲ�", "888888",
			   "123456789", "000-000-000", "����", "13852015201", "��������", "42111111111", "mayun@520.com", 1);
	   boolean result = service.addProvider(p);
	   if(result==true) {
		   System.out.println("��Ӧ����Ϣ��ӳɹ���");
	   }else {
		   System.out.println("��Ӧ�����ʧ�ܣ�");
	   }
	}
	/**
	 * ��̬���ɿͻ����
	 */
	@Test
	public void testGetProviderId() {
		String id = service.getProviderId();
		System.out.println(id);
	}
	
	/**
	 * ��ѯ�ͻ���Ϣ
	 */
	@Test
	public void testFindProvider(){
		Provider c = new Provider();
		c.setContacts("�ŷ�");
		List<Provider> list = service.findProvider(c);
//		
		Vector<Provider> v = new Vector<Provider>();
		for (Provider customer : list) {
			v.add(customer);
		}
		System.out.println(v);
	}
	
	/**
	 * ���ݿͻ���Ų�ѯ�ͻ���Ϣ
	 */
	@Test
	public void testFindProvider2(){
		Provider customer = new Provider();
		customer.setId("PD1001");
		List<Provider> list = service.findProvider(customer);
		System.out.println(list.size()+","+list);
	}
	/**
	 * �޸Ŀͻ���Ϣ
	 */
	@Test
	public void testUpdateProvider() { 
	  Provider customer = new Provider("PD007", "����Ͱ����޹�˾", "����Ͱ�", "���ݰ���Ͱ��ܲ�", "888888",
			   "123456789", "000-000-000", "����", "13852015201", "��������", "42111111111", "mayun@520.com", 1);
	   boolean result = service.updateProvider(customer);
	   if(result==true) {
		   System.out.println("��Ӧ����Ϣ�޸ĳɹ���");
	   }else {
		   System.out.println("��Ӧ����Ϣ�޸�ʧ�ܣ�");
	   }
	}
	
	/**
	 * ���ݿͻ�����޸�available
	 */
	@Test
	public void testUpdateProvider1() {
		boolean result = service.updateProvider("PD006", 1);
		   if(result==true) {
			   System.out.println("��Ӧ����Ϣɾ��/�һسɹ���");
		   }else {
			   System.out.println("��Ӧ����Ϣɾ��/�һ�ʧ�ܣ�");
		   }
	}


}
