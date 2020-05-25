package com.oxhpjk.jxc.service;

import java.util.List;

import com.oxhpjk.jxc.model.Customer;
import com.oxhpjk.jxc.model.Provider;

public interface ProviderService {
	/**
	 * ��ӿͻ���Ϣ
	 * 
	 * @param provider
	 * @return
	 */
	public  boolean addProvider(Provider provider) ;
		

	/**
	 * ���ɿͻ����
	 * 
	 * @return
	 */
	public String getProviderId();

	/**
	 * ��ѯ�ͻ���Ϣ
	 * 
	 * @return
	 */
	public List<Provider> findProvider(Provider p);

	/**
	 * ���ݿͻ�����޸Ŀͻ���Ϣ
	 * 
	 * @param customer
	 * @return
	 */
	public boolean updateProvider(Provider p);

	/**
 	 * ���ݿͻ�����޸�available
 	 * @param id���ͻ����
 	 * @param available��0:��ʾɾ����1��ʾ�һ�
 	 * @return
 	 */
 	public boolean updateProvider(String id,Integer available);

}
