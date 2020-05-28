package com.oxhpjk.jxc.service;

import java.util.List;

import com.oxhpjk.jxc.model.Stock;

public interface StockService {
	/**
	 * 添加商品
	 */
	public boolean saveStock(Stock stock);

	/**
	 * 自动生成商品编号
	 */
	public String getStockId();

	/**
	 * 查询商品信息
	 */
	public List<Stock> findStock(Stock stock);
	

	/**
	 * 修改商品信息
	 */
	public boolean updateStock(Stock stock);

	/**
	 * 删除商品
	 */
	public boolean updateStock(String id, Integer available);
}
