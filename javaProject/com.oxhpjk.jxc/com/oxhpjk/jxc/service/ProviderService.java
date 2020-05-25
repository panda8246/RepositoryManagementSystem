package com.oxhpjk.jxc.service;

import java.util.List;

import com.oxhpjk.jxc.model.Customer;
import com.oxhpjk.jxc.model.Provider;

public interface ProviderService {
	/**
	 * 添加客户信息
	 * 
	 * @param provider
	 * @return
	 */
	public  boolean addProvider(Provider provider) ;
		

	/**
	 * 生成客户编号
	 * 
	 * @return
	 */
	public String getProviderId();

	/**
	 * 查询客户信息
	 * 
	 * @return
	 */
	public List<Provider> findProvider(Provider p);

	/**
	 * 根据客户编号修改客户信息
	 * 
	 * @param customer
	 * @return
	 */
	public boolean updateProvider(Provider p);

	/**
 	 * 根据客户编号修改available
 	 * @param id：客户编号
 	 * @param available：0:表示删除，1表示找回
 	 * @return
 	 */
 	public boolean updateProvider(String id,Integer available);

}
