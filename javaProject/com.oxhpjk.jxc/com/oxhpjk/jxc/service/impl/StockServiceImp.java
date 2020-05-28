package com.oxhpjk.jxc.service.impl;

import java.util.List;

import com.oxhpjk.jxc.dao.StockDao;
import com.oxhpjk.jxc.model.Stock;
import com.oxhpjk.jxc.service.StockService;

public class StockServiceImp implements StockService{

	@Override
	public boolean saveStock(Stock stock) {
		StockDao stockDao = new StockDao();
		return stockDao.save(stock);
	}

	@Override
	public String getStockId() {
		StockDao stockDao = new StockDao();
		return stockDao.getId();
	}

	@Override
	public List<Stock> findStock(Stock stock) {
		StockDao stockDao = new StockDao();
		return stockDao.query(stock);
	}

	@Override
	public boolean updateStock(Stock stock) {
		StockDao stockDao = new StockDao();
		return stockDao.update(stock);
	}

	@Override
	public boolean updateStock(String id, Integer available) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
