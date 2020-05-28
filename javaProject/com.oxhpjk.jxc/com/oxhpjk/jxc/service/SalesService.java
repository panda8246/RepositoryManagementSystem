package com.oxhpjk.jxc.service;

import java.util.List;

import com.oxhpjk.jxc.model.Sales;


public interface SalesService {
	/**
	 * 添加商品
	 */
	public boolean saveSales(Sales sales);

	/**
	 * 自动生成商品编号
	 */
	public String getSalesId();

	/**
	 * 查询商品信息
	 */
	public List<Sales> findSales(Sales sales);
	

	/**
	 * 修改商品信息
	 */
	public boolean updateSales(Sales sales);

	/**
	 * 删除商品
	 */
	public boolean updateSales(String id, Integer available);
}
