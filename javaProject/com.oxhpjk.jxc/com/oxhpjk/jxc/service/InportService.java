package com.oxhpjk.jxc.service;

import java.util.List;

import com.oxhpjk.jxc.model.Inport;


public interface InportService {
	
	/**
	 * �����Ʒ
	 */
	public boolean saveInports(Inport inport);

	/**
	 * �Զ�������Ʒ���
	 */
	public String getInportsId();

	/**
	 * ��ѯ��Ʒ��Ϣ
	 */
	public List<Inport> findInports(Inport inport);
	

	/**
	 * �޸���Ʒ��Ϣ
	 */
	public boolean updateInports(Inport inport);

	/**
	 * ɾ����Ʒ
	 */
	public boolean updateInports(String id, Integer available);
}
