package com.oxhpjk.jxc.dao;

import java.util.List;

import com.oxhpjk.jxc.model.Customer;

public interface BaseDao<T> {
	/**
	 * 添加信息
	 * @param t
	 * @return
	 */
	public boolean save(T t);
	/**
	 * 获取自动生成的id
	 * @return
	 */
	public String getId();
	/**
	 * 查询信息
	 * @param c
	 * @return
	 */
	public List<T> query(T t);
	/**
	 * 根据id修改信息
	 * @param t
	 * @return
	 */
	public boolean update(T t);
	/**
	 * 根据编号修改available
	 * @param id
	 * @param available
	 * @return
	 */
	public boolean update(String id,Integer available);
}
