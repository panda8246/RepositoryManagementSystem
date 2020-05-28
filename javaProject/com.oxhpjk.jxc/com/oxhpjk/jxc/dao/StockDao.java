package com.oxhpjk.jxc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oxhpjk.jxc.commom.Constants;
import com.oxhpjk.jxc.commom.ErrorManager;
import com.oxhpjk.jxc.model.Inport;
import com.oxhpjk.jxc.model.Stock;
import com.sun.org.apache.regexp.internal.recompile;

public class StockDao implements BaseDao<Stock>{

	SqlManager sqlManager = null;

	public StockDao() {
		sqlManager = SqlManager.createInstance();
		sqlManager.connectDB();// 获取数据库连接
	}

	@Override
	/*
	 *  添加/插入
	 * @see com.oxhpjk.jxc.dao.BaseDao#save(java.lang.Object)
	 */
	public boolean save(Stock stock) {
		// 编写sql语句
		String sql = "insert into t_stock values(?,?,?)";
		// 封装参数
		Object[] params = new Object[] {stock.getId(),stock.getGoods_id(),stock.getNumber()};
		// 执行sql
		return sqlManager.executeUpdate(sql, params, Constants.PSTM_TYPE);
	}

	@Override
	public String getId() {
		// 获取最新的id
		String sql = "select MAX(id) id from t_stock";
		// 执行sql
		ResultSet rs = sqlManager.executeQuery(sql, null, Constants.PSTM_TYPE);
		
		String id = "st1";
		try {
			if (rs != null && rs.next()) {
				String sid = rs.getString("id");// 获取前一次插入的id
				if (sid != null) {
					String str = sid.substring(2);// 截取编号中的数字
					id = "st" + (Integer.parseInt(str) + 1);
				}
			}
		} catch (SQLException e) {
			ErrorManager.printError("GoodsDao getCustomerId()", e);
		}
		return id;
	}

	@Override
	public List<Stock> query(Stock stock) {
		List<Stock> list = null;
		String sql = null;
		Object[] params = null;
		if (stock == null) {// 没有参数
			// 编写sql
			sql = "select * from t_stock";
		}else {
			sql = "select * from t_stock where id like ? and goods_id like ? and number >= ?";
			params = new Object[] {"%"+stock.getId()+"%","%"+stock.getGoods_id()+"%",stock.getNumber()};
		}
		// 执行sql
		ResultSet rs = sqlManager.executeQuery(sql, params, Constants.PSTM_TYPE);
		// 解析结果集
		if (rs != null) {
			list = new ArrayList<Stock>();
			try {
				while (rs.next()) {
					Stock _st = new Stock();
					_st.setId(rs.getString("id"));
					_st.setGoods_id(rs.getString("goods_id"));
					_st.setNumber(rs.getInt("number"));
					list.add(_st);
				}
			} catch (SQLException e) {
				ErrorManager.printError("stockDao query()", e);
			}
		}
		return list;
	}

	@Override
	public boolean update(Stock stock) {
		if (stock != null) {
			String sql = "update t_stock set goods_id=? , number=? where id=?";
			Object[] params = new Object[] {stock.getGoods_id(),stock.getNumber(),stock.getId()};
			return sqlManager.executeUpdate(sql, params, Constants.PSTM_TYPE);
		}
		return false;
	}

	@Override
	public boolean update(String id, Integer available) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
