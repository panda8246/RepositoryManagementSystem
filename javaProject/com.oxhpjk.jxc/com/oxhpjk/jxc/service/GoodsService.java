package com.oxhpjk.jxc.service;

import java.util.List;

import com.oxhpjk.jxc.model.Goods;

public interface GoodsService {
	public boolean save(Goods g);
	
	public String getId();
	
	
	 public List<Goods> findGoods(Goods good);
}
