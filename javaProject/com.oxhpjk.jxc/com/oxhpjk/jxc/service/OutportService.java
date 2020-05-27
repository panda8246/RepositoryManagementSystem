package com.oxhpjk.jxc.service;

import java.util.List;

import com.oxhpjk.jxc.model.Inport;
import com.oxhpjk.jxc.model.Outport;


public interface OutportService {
	
	/**
	 * 添加商品
	 */
	public boolean saveOutports(Outport outport);

	/**
	 * 自动生成商品编号
	 */
	public String getOutportsId();

	/**
	 * 查询商品信息
	 */
	public List<Outport> findOutports(Outport outport);
	

	/**
	 * 修改商品信息
	 */
	public boolean updateOutports(Outport outport);

	/**
	 * 删除商品
	 */
	public boolean updateOutports(String id, Integer available);
}
