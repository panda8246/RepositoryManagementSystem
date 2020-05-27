package com.oxhpjk.jxc.service.impl;

import java.util.List;

import com.oxhpjk.jxc.dao.InportDao;
import com.oxhpjk.jxc.model.Inport;
import com.oxhpjk.jxc.service.InportService;

public class InportServiceImp implements InportService{

	@Override
	public boolean saveInports(Inport inport) {
		InportDao inportDao = new InportDao();
		return inportDao.save(inport);
	}

	@Override
	public String getInportsId() {
		InportDao inportDao = new InportDao();
		return inportDao.getId();
	}

	@Override
	public List<Inport> findInports(Inport inport) {
		InportDao inportDao = new InportDao();
		return inportDao.query(inport);
	}

	@Override
	public boolean updateInports(Inport inport) {
		InportDao inportDao = new InportDao();
		return inportDao.update(inport);
	}

	@Override
	public boolean updateInports(String id, Integer available) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
