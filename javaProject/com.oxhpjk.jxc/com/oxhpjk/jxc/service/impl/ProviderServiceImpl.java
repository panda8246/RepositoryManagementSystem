package com.oxhpjk.jxc.service.impl;

import java.util.List;

import com.oxhpjk.jxc.dao.CustomerDao;
import com.oxhpjk.jxc.dao.BaseDao;
import com.oxhpjk.jxc.dao.ProviderDao;
import com.oxhpjk.jxc.model.Person;
import com.oxhpjk.jxc.model.Provider;
import com.oxhpjk.jxc.service.ProviderService;

public class ProviderServiceImpl implements ProviderService{
	private BaseDao<Provider> providerDao;

	@Override
	public boolean addProvider(Provider provider) {
		providerDao=new ProviderDao();
		return providerDao.save(provider);
	}
	@Override
	public String getProviderId() {
		providerDao=new ProviderDao();
		return providerDao.getId();
	}

	@Override
	public List<Provider> findProvider(Provider p) {
		providerDao=new ProviderDao();
		return providerDao.query(p);
	}

	@Override
	public boolean updateProvider(Provider p) {
		providerDao=new ProviderDao();
		return providerDao.update(p);
	}

	@Override
	public boolean updateProvider(String id, Integer available) {
		providerDao=new ProviderDao();
		return providerDao.update(id, available);
	}

}
