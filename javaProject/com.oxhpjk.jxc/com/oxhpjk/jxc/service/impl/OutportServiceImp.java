package com.oxhpjk.jxc.service.impl;

import java.util.List;

import com.oxhpjk.jxc.dao.OutportDao;
import com.oxhpjk.jxc.model.Outport;
import com.oxhpjk.jxc.service.OutportService;

public class OutportServiceImp implements OutportService{

	@Override
	public boolean saveOutports(Outport outport) {
		OutportDao outportDao = new OutportDao();
		return outportDao.save(outport);
	}

	@Override
	public String getOutportsId() {
		OutportDao outportDao = new OutportDao();
		return outportDao.getId();
	}

	@Override
	public List<Outport> findOutports(Outport outport) {
		OutportDao outportDao = new OutportDao();
		return outportDao.query(outport);
	}

	@Override
	public boolean updateOutports(Outport outport) {
		OutportDao outportDao = new OutportDao();
		return outportDao.update(outport);
	}

	@Override
	public boolean updateOutports(String id, Integer available) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
