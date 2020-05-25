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
 * 客户管理的测试
 * @author 22161
 *
 */
public class CustomerTest {
	 CustomerService service  = null;
	 /**
	  * 每次在执行@Test方法之前，都会执行一次
	  */
	 @Before
	 public void init() {
		  service = CommonFactory.getCustomerService();
	 }

	/**
	 * 添加客户信息
	 */
	@Test
	public void testAddCustomer() { 
	   Customer customer = new Customer("CT0006", "阿里巴巴有限公司", "阿里巴巴", "杭州阿里巴巴总部", "888888",
			   "123456789", "000-000-000", "马云", "13852015201", "招商银行", "42111111111", "mayun@520.com", 1);
	   boolean result = service.addCustomer(customer);
	   if(result==true) {
		   System.out.println("客户信息添加成功！");
	   }else {
		   System.out.println("客户信息添加失败！");
	   }
	}
	/**
	 * 动态生成客户编号
	 */
	@Test
	public void testGetCustomerId() {
		String id = service.getCustomerId();
		System.out.println(id);
	}
	
	/**
	 * 查询客户信息
	 */
	@Test
	public void testFindCustomers(){
		Customer c = new Customer();
		c.setContacts("张飞");
		List<Customer> list = service.findCustomers(null);
//		
		Vector<Customer> v = new Vector<Customer>();
		for (Customer customer : list) {
			v.add(customer);
		}
		System.out.println(v);
	}
	
	/**
	 * 根据客户编号查询客户信息
	 */
	@Test
	public void testFindCustomers2(){
		Customer customer = new Customer();
		customer.setId("CT1002");
		List<Customer> list = service.findCustomers(customer);
		System.out.println(list.size()+","+list);
	}
	/**
	 * 修改客户信息
	 */
	@Test
	public void testUpdateCustomer() { 
	   Customer customer = new Customer("CT006", "阿里巴巴有限公司", "阿里巴巴", "杭州阿里巴巴总部", "888888",
			   "123456789", "000-000-000", "马云", "13852015201", "招商银行", "42111111111", "mayun@520.com", 1);
	   boolean result = service.updateCustomer(customer);
	   if(result==true) {
		   System.out.println("客户信息修改成功！");
	   }else {
		   System.out.println("客户信息修改失败！");
	   }
	}
	
	/**
	 * 根据客户编号修改available
	 */
	@Test
	public void testUpdateCustomer1() {
		boolean result = service.updateCustomer("CT1001", Constants.DATA_FIND);
		   if(result==true) {
			   System.out.println("客户信息删除/找回成功！");
		   }else {
			   System.out.println("客户信息删除/找回失败！");
		   }
	}


}

