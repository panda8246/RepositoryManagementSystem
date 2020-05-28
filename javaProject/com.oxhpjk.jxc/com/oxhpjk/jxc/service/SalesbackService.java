package com.oxhpjk.jxc.service;

import java.util.List;

import com.oxhpjk.jxc.model.Salesback;

public interface SalesbackService {
	/**
	 * �����Ʒ
	 */
	public boolean saveSalesback(Salesback salesback);

	/**
	 * �Զ�������Ʒ���
	 */
	public String getSalesbackId();

	/**
	 * ��ѯ��Ʒ��Ϣ
	 */
	public List<Salesback> findSalesback(Salesback salesback);
	

	/**
	 * �޸���Ʒ��Ϣ
	 */
	public boolean updateSalesback(Salesback salesback);

	/**
	 * ɾ����Ʒ
	 */
	public boolean updateSalesback(String id, Integer available);
}
