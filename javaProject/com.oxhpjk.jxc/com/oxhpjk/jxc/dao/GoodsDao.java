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
		sqlManager.connectDB();// ��ȡ���ݿ�����
	}

	@Override
	/*
	 *  ���/����
	 * @see com.oxhpjk.jxc.dao.BaseDao#save(java.lang.Object)
	 */
	public boolean save(Goods g) {
		// ��дsql���
		String sql = "insert into t_goods values(?,?,?,?,?,?,?,?,?,?,?,1)";
		// ��װ����
		Object[] params = new Object[] { g.getId(), g.getGoodsname(), g.getShorts(), g.getProductplace(), g.getSize(),
				g.getPackages(), g.getProductcode(), g.getPromitcode(), g.getPrice(), g.getMemo(), g.getProviderId() };
		// ִ��sql
		return sqlManager.executeUpdate(sql, params, Constants.PSTM_TYPE);
	}

	@Override
	public String getId() {
		// ��ȡ���µ�id
		String sql = "select MAX(id) id from t_goods";
		// ִ��sql
		ResultSet rs = sqlManager.executeQuery(sql, null, Constants.PSTM_TYPE);
		String id = "g1";
		try {
			if (rs != null && rs.next()) {
				String sid = rs.getString("id");// ��ȡǰһ�β����id
				if (sid != null) {
					String str = sid.substring(1);// ��ȡ����е�����
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
		if (g == null) {// û�в���
			// ��дsql
			sql = "select * from t_goods where available=1";
		} else {// �в������ȴ��Ժ���չ
			// ������ƷID��ѯ
			if (g.getId() != null && !g.getId().equals("")) {
				sql = "select * from t_goods where id=? and available=1";
				params = new Object[1];
				params[0] = g.getId();
			} else if (g.getGoodsname() != null && !g.getGoodsname().equals("")) {// ������Ʒȫ�Ʋ�ѯ
				sql = "select * from t_goods where goodsname like ? and available=1";
				params = new Object[1];
				params[0] = "%" + g.getGoodsname() + "%";
			} else if (g.getShorts() != null && !g.getShorts().equals("")) {// ���ݿͻ���Ʋ�ѯ
				sql = "select * from t_goods where shorts like ? and available=1";
				params = new Object[1];
				params[0] = "%" + g.getShorts() + "%";
			}
		}
		// ִ��sql
		ResultSet rs = sqlManager.executeQuery(sql, params, Constants.PSTM_TYPE);
		// ���������
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
