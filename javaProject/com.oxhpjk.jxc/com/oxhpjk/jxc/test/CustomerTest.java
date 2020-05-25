package com.oxhpjk.jxc.test;

import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import com.oxhpjk.jxc.commom.CommonFactory;
import com.oxhpjk.jxc.commom.Constants;
import com.oxhpjk.jxc.dao.CustomerDao;
import com.oxhpjk.jxc.model.Customer;
import com.oxhpjk.jxc.service.CustomerService;

/**
 * �ͻ�����Ĳ���
 * @author 22161
 *
 */
public class CustomerTest {
	 CustomerService service  = null;
	 /**
	  * ÿ����ִ��@Test����֮ǰ������ִ��һ��
	  */
	 @Before
	 public void init() {
		  service = CommonFactory.getCustomerService();
	 }

	/**
	 * ��ӿͻ���Ϣ
	 */
	@Test
	public void testAddCustomer() { 
	   Customer customer = new Customer("CT0006", "����Ͱ����޹�˾", "����Ͱ�", "���ݰ���Ͱ��ܲ�", "888888",
			   "123456789", "000-000-000", "����", "13852015201", "��������", "42111111111", "mayun@520.com", 1);
	   boolean result = service.addCustomer(customer);
	   if(result==true) {
		   System.out.println("�ͻ���Ϣ��ӳɹ���");
	   }else {
		   System.out.println("�ͻ���Ϣ���ʧ�ܣ�");
	   }
	}
	/**
	 * ��̬���ɿͻ����
	 */
	@Test
	public void testGetCustomerId() {
		String id = service.getCustomerId();
		System.out.println(id);
	}
	
	/**
	 * ��ѯ�ͻ���Ϣ
	 */
	@Test
	public void testFindCustomers(){
		Customer c = new Customer();
		c.setContacts("�ŷ�");
		List<Customer> list = service.findCustomers(null);
//		
		Vector<Customer> v = new Vector<Customer>();
		for (Customer customer : list) {
			v.add(customer);
		}
		System.out.println(v);
	}
	
	/**
	 * ���ݿͻ���Ų�ѯ�ͻ���Ϣ
	 */
	@Test
	public void testFindCustomers2(){
		Customer customer = new Customer();
		customer.setId("CT1002");
		List<Customer> list = service.findCustomers(customer);
		System.out.println(list.size()+","+list);
	}
	/**
	 * �޸Ŀͻ���Ϣ
	 */
	@Test
	public void testUpdateCustomer() { 
	   Customer customer = new Customer("CT006", "����Ͱ����޹�˾", "����Ͱ�", "���ݰ���Ͱ��ܲ�", "888888",
			   "123456789", "000-000-000", "����", "13852015201", "��������", "42111111111", "mayun@520.com", 1);
	   boolean result = service.updateCustomer(customer);
	   if(result==true) {
		   System.out.println("�ͻ���Ϣ�޸ĳɹ���");
	   }else {
		   System.out.println("�ͻ���Ϣ�޸�ʧ�ܣ�");
	   }
	}
	
	/**
	 * ���ݿͻ�����޸�available
	 */
	@Test
	public void testUpdateCustomer1() {
		boolean result = service.updateCustomer("CT1001", Constants.DATA_FIND);
		   if(result==true) {
			   System.out.println("�ͻ���Ϣɾ��/�һسɹ���");
		   }else {
			   System.out.println("�ͻ���Ϣɾ��/�һ�ʧ�ܣ�");
		   }
	}


}

