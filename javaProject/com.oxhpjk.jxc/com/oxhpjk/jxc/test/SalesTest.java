package com.oxhpjk.jxc.test;

import java.util.List;

import org.junit.Test;

import com.oxhpjk.jxc.commom.CommonFactory;
import com.oxhpjk.jxc.model.Sales;
import com.oxhpjk.jxc.service.SalesService;

public class SalesTest {
	
	@Test
	public void testSales() {
		Sales sales = new Sales();
		SalesService salesService = CommonFactory.getSalesService();
		List<Sales> list = salesService.findSales(sales);
		System.out.println(list.get(0).getOperateperson());
	}
}
