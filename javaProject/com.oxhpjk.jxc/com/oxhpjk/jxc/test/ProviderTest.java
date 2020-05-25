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
	  * 每次在执行@Test方法之前，都会执行一次
	  */
	 @Before
	 public void init() {
		  service = CommonFactory.getProviderService();
	 }

	/**
	 * 添加客户信息
	 */
	@Test
	public void testAddProvider() { 
	   Provider p = new Provider(service.getProviderId(), "阿里巴巴有限公司", "阿里巴巴", "杭州阿里巴巴总部", "888888",
			   "123456789", "000-000-000", "马云", "13852015201", "招商银行", "42111111111", "mayun@520.com", 1);
	   boolean result = service.addProvider(p);
	   if(result==true) {
		   System.out.println("供应商信息添加成功！");
	   }else {
		   System.out.println("供应商添加失败！");
	   }
	}
	/**
	 * 动态生成客户编号
	 */
	@Test
	public void testGetProviderId() {
		String id = service.getProviderId();
		System.out.println(id);
	}
	
	/**
	 * 查询客户信息
	 */
	@Test
	public void testFindProvider(){
		Provider c = new Provider();
		c.setContacts("张飞");
		List<Provider> list = service.findProvider(c);
//		
		Vector<Provider> v = new Vector<Provider>();
		for (Provider customer : list) {
			v.add(customer);
		}
		System.out.println(v);
	}
	
	/**
	 * 根据客户编号查询客户信息
	 */
	@Test
	public void testFindProvider2(){
		Provider customer = new Provider();
		customer.setId("PD1001");
		List<Provider> list = service.findProvider(customer);
		System.out.println(list.size()+","+list);
	}
	/**
	 * 修改客户信息
	 */
	@Test
	public void testUpdateProvider() { 
	  Provider customer = new Provider("PD007", "阿里巴巴有限公司", "阿里巴巴", "杭州阿里巴巴总部", "888888",
			   "123456789", "000-000-000", "马云", "13852015201", "招商银行", "42111111111", "mayun@520.com", 1);
	   boolean result = service.updateProvider(customer);
	   if(result==true) {
		   System.out.println("供应商信息修改成功！");
	   }else {
		   System.out.println("供应商信息修改失败！");
	   }
	}
	
	/**
	 * 根据客户编号修改available
	 */
	@Test
	public void testUpdateProvider1() {
		boolean result = service.updateProvider("PD006", 1);
		   if(result==true) {
			   System.out.println("供应商信息删除/找回成功！");
		   }else {
			   System.out.println("供应商信息删除/找回失败！");
		   }
	}


}
