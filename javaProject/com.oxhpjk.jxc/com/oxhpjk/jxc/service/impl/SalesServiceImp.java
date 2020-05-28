package com.oxhpjk.jxc.service.impl;

import java.util.List;

import com.oxhpjk.jxc.dao.SalesDao;
import com.oxhpjk.jxc.model.Sales;
import com.oxhpjk.jxc.service.SalesService;

public class SalesServiceImp implements SalesService{

	@Override
	public boolean saveSales(Sales sales) {
		SalesDao salesDao = new SalesDao();
		return salesDao.save(sales);
	}

	@Override
	public String getSalesId() {
		SalesDao salesDao = new SalesDao();
		return salesDao.getId();
	}

	@Override
	public List<Sales> findSales(Sales sales) {
		SalesDao salesDao = new SalesDao();
		return salesDao.query(sales);
	}

	@Override
	public boolean updateSales(Sales sales) {
		SalesDao salesDao = new SalesDao();
		return salesDao.update(sales);
	}

	@Override
	public boolean updateSales(String id, Integer available) {
		// TODO Auto-generated method stub
		return false;
	}
	
}	
