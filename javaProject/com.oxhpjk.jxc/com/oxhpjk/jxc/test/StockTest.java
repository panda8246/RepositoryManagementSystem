package com.oxhpjk.jxc.test;

import org.junit.Test;

import com.oxhpjk.jxc.commom.CommonFactory;
import com.oxhpjk.jxc.model.Stock;
import com.oxhpjk.jxc.service.StockService;

public class StockTest {
	
	@Test
	public void stock() {
		StockService stockService = CommonFactory.getStockService();
		Stock stock = new Stock("st1","JOJO",222);
		System.out.println(stockService.updateStock(stock));
	}
}
