package com.oxhpjk.jxc.service;

import java.util.List;

import com.oxhpjk.jxc.model.Stock;

public interface StockService {
	/**
	 * �����Ʒ
	 */
	public boolean saveStock(Stock stock);

	/**
	 * �Զ�������Ʒ���
	 */
	public String getStockId();

	/**
	 * ��ѯ��Ʒ��Ϣ
	 */
	public List<Stock> findStock(Stock stock);
	

	/**
	 * �޸���Ʒ��Ϣ
	 */
	public boolean updateStock(Stock stock);

	/**
	 * ɾ����Ʒ
	 */
	public boolean updateStock(String id, Integer available);
}
