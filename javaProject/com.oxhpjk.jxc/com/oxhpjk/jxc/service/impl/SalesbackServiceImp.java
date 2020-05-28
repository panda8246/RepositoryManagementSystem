package com.oxhpjk.jxc.service.impl;

import java.util.List;

import com.oxhpjk.jxc.dao.SalesbackDao;
import com.oxhpjk.jxc.model.Salesback;
import com.oxhpjk.jxc.service.SalesbackService;

public class SalesbackServiceImp implements SalesbackService{

	@Override
	public boolean saveSalesback(Salesback salesback) {
		SalesbackDao salesbackDao = new SalesbackDao();
		return salesbackDao.save(salesback);
	}

	@Override
	public String getSalesbackId() {
		SalesbackDao salesbackDao = new SalesbackDao();
		return salesbackDao.getId();
	}

	@Override
	public List<Salesback> findSalesback(Salesback salesback) {
		SalesbackDao salesbackDao = new SalesbackDao();
		return salesbackDao.query(salesback);
	}

	@Override
	public boolean updateSalesback(Salesback salesback) {
		SalesbackDao salesbackDao = new SalesbackDao();
		return salesbackDao.update(salesback);
	}

	@Override
	public boolean updateSalesback(String id, Integer available) {
		// TODO Auto-generated method stub
		return false;
	}

}
