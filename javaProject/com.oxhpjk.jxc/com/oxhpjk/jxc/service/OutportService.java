package com.oxhpjk.jxc.service;

import java.util.List;

import com.oxhpjk.jxc.model.Inport;
import com.oxhpjk.jxc.model.Outport;


public interface OutportService {
	
	/**
	 * �����Ʒ
	 */
	public boolean saveOutports(Outport outport);

	/**
	 * �Զ�������Ʒ���
	 */
	public String getOutportsId();

	/**
	 * ��ѯ��Ʒ��Ϣ
	 */
	public List<Outport> findOutports(Outport outport);
	

	/**
	 * �޸���Ʒ��Ϣ
	 */
	public boolean updateOutports(Outport outport);

	/**
	 * ɾ����Ʒ
	 */
	public boolean updateOutports(String id, Integer available);
}
