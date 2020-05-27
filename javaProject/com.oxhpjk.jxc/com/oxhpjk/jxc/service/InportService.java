package com.oxhpjk.jxc.service;

import java.util.List;

import com.oxhpjk.jxc.model.Inport;


public interface InportService {
	
	/**
	 * 添加商品
	 */
	public boolean saveInports(Inport inport);

	/**
	 * 自动生成商品编号
	 */
	public String getInportsId();

	/**
	 * 查询商品信息
	 */
	public List<Inport> findInports(Inport inport);
	

	/**
	 * 修改商品信息
	 */
	public boolean updateInports(Inport inport);

	/**
	 * 删除商品
	 */
	public boolean updateInports(String id, Integer available);
}
