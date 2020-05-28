package com.oxhpjk.jxc.service;

import java.util.List;

import com.oxhpjk.jxc.model.Salesback;

public interface SalesbackService {
	/**
	 * 添加商品
	 */
	public boolean saveSalesback(Salesback salesback);

	/**
	 * 自动生成商品编号
	 */
	public String getSalesbackId();

	/**
	 * 查询商品信息
	 */
	public List<Salesback> findSalesback(Salesback salesback);
	

	/**
	 * 修改商品信息
	 */
	public boolean updateSalesback(Salesback salesback);

	/**
	 * 删除商品
	 */
	public boolean updateSalesback(String id, Integer available);
}
