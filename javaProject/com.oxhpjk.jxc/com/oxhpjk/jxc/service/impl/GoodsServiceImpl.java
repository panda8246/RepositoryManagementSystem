package com.oxhpjk.jxc.service.impl;

import java.util.List;

import com.oxhpjk.jxc.dao.GoodsDao;
import com.oxhpjk.jxc.model.Goods;
import com.oxhpjk.jxc.service.GoodsService;

public class GoodsServiceImpl implements GoodsService{
    private GoodsDao goodsDao;
    
    
	@Override
	public boolean save(Goods g) {
		goodsDao=new GoodsDao();
		return goodsDao.save(g);
	}
	@Override
	public String getId() {
		goodsDao=new GoodsDao();
		return goodsDao.getId();
	}
	@Override
	public List<Goods> findGoods(Goods good) {
		goodsDao=new GoodsDao();
		return goodsDao.query(good);  
	}
  
}
