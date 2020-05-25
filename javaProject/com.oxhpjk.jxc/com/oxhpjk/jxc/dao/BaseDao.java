package com.oxhpjk.jxc.dao;

import java.util.List;

import com.oxhpjk.jxc.model.Customer;

public interface BaseDao<T> {
	/**
	 * �����Ϣ
	 * @param t
	 * @return
	 */
	public boolean save(T t);
	/**
	 * ��ȡ�Զ����ɵ�id
	 * @return
	 */
	public String getId();
	/**
	 * ��ѯ��Ϣ
	 * @param c
	 * @return
	 */
	public List<T> query(T t);
	/**
	 * ����id�޸���Ϣ
	 * @param t
	 * @return
	 */
	public boolean update(T t);
	/**
	 * ���ݱ���޸�available
	 * @param id
	 * @param available
	 * @return
	 */
	public boolean update(String id,Integer available);
}
