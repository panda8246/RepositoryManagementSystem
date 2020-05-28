package com.oxhpjk.jxc.service;

import java.util.List;

import com.oxhpjk.jxc.model.Sales;


public interface SalesService {
	/**
	 * �����Ʒ
	 */
	public boolean saveSales(Sales sales);

	/**
	 * �Զ�������Ʒ���
	 */
	public String getSalesId();

	/**
	 * ��ѯ��Ʒ��Ϣ
	 */
	public List<Sales> findSales(Sales sales);
	

	/**
	 * �޸���Ʒ��Ϣ
	 */
	public boolean updateSales(Sales sales);

	/**
	 * ɾ����Ʒ
	 */
	public boolean updateSales(String id, Integer available);
}
