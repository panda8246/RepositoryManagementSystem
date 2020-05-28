package com.oxhpjk.jxc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oxhpjk.jxc.commom.Constants;
import com.oxhpjk.jxc.commom.ErrorManager;
import com.oxhpjk.jxc.model.Customer;
import com.oxhpjk.jxc.model.Goods;

public class GoodsDao implements BaseDao<Goods> {
	SqlManager sqlManager = null;

	public GoodsDao() {
		sqlManager = SqlManager.createInstance();
		sqlManager.connectDB();// 获取数据库连接
	}

	@Override
	/*
	 *  添加/插入
	 * @see com.oxhpjk.jxc.dao.BaseDao#save(java.lang.Object)
	 */
	public boolean save(Goods g) {
		// 编写sql语句
		String sql = "insert into t_goods values(?,?,?,?,?,?,?,?,?,?,?,1)";
		// 封装参数
		Object[] params = new Object[] { g.getId(), g.getGoodsname(), g.getShorts(), g.getProductplace(), g.getSize(),
				g.getPackages(), g.getProductcode(), g.getPromitcode(), g.getPrice(), g.getMemo(), g.getProviderId() };
		// 执行sql
		return sqlManager.executeUpdate(sql, params, Constants.PSTM_TYPE);
	}

	@Override
	public String getId() {
		// 获取最新的id
		String sql = "select MAX(id) id from t_goods";
		// 执行sql
		ResultSet rs = sqlManager.executeQuery(sql, null, Constants.PSTM_TYPE);
		String id = "g1";
		try {
			if (rs != null && rs.next()) {
				String sid = rs.getString("id");// 获取前一次插入的id
				if (sid != null) {
					String str = sid.substring(1);// 截取编号中的数字
					id = "g" + (Integer.parseInt(str) + 1);
				}
			}
		} catch (SQLException e) {
			ErrorManager.printError("GoodsDao getCustomerId()", e);
		}
		return id;
	}

	@Override
	public List<Goods> query(Goods g) {
		List<Goods> list = null;
		String sql = null;
		Object[] params = null;
		if (g == null) {// 没有参数
			// 编写sql
			sql = "select * from t_goods where available=1";
		} else {// 有参数，等待以后扩展
			// 根据商品ID查询
			if (g.getId() != null && !g.getId().equals("")) {
				sql = "select * from t_goods where id=? and available=1";
				params = new Object[1];
				params[0] = g.getId();
			} else if (g.getGoodsname() != null && !g.getGoodsname().equals("")) {// 根据商品全称查询
				sql = "select * from t_goods where goodsname like ? and available=1";
				params = new Object[1];
				params[0] = "%" + g.getGoodsname() + "%";
			} else if (g.getShorts() != null && !g.getShorts().equals("")) {// 根据客户简称查询
				sql = "select * from t_goods where shorts like ? and available=1";
				params = new Object[1];
				params[0] = "%" + g.getShorts() + "%";
			}
		}
		// 执行sql
		ResultSet rs = sqlManager.executeQuery(sql, params, Constants.PSTM_TYPE);
		// 解析结果集
		if (rs != null) {
			list = new ArrayList<Goods>();
			try {
				while (rs.next()) {
					Goods cus = new Goods();
					cus.setId(rs.getString("id"));
					cus.setGoodsname(rs.getString("goodsname"));
					cus.setShorts(rs.getString("shorts"));
					cus.setProductplace(rs.getString("productplace"));
					cus.setSize(rs.getString("size"));
					cus.setPackages(rs.getString("package"));
					cus.setProductcode(rs.getString("productcode"));
					cus.setPromitcode(rs.getString("promitcode"));
					cus.setPrice(rs.getFloat("price"));
					cus.setMemo(rs.getString("memo"));
					cus.setProviderId(rs.getString("provider_id"));
					list.add(cus);
				}
			} catch (SQLException e) {
				ErrorManager.printError("GoodsDao query()", e);
			}
		}
		return list;
	}

	@Override
	public boolean update(Goods g) {
		if (g != null) {
			String sql = "update t_goods set goodsname=?,shorts=?,productplace=?,size=?,package=?,productcode=?,"
					+ "promitcode=?,price=?,memo=?,provider_id=? where id=?";
			Object[] params = new Object[] { g.getGoodsname(), g.getShorts(), g.getProductplace(), g.getSize(),
					g.getPackages(), g.getProductcode(), g.getPromitcode(), g.getPrice(), g.getMemo(),
					g.getProviderId(), g.getId() };
			return sqlManager.executeUpdate(sql, params, Constants.PSTM_TYPE);
		}
		return false;
	}

	@Override
	public boolean update(String id, Integer available) {
		String sql = "update t_goods set available=? where id=?";
		Object[] params = new Object[] { available, id };
		return sqlManager.executeUpdate(sql, params, Constants.PSTM_TYPE);
	
	}

}
