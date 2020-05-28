package com.oxhpjk.jxc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oxhpjk.jxc.commom.Constants;
import com.oxhpjk.jxc.commom.ErrorManager;
import com.oxhpjk.jxc.model.Sales;
import com.oxhpjk.jxc.model.Salesback;

public class SalesbackDao implements BaseDao<Salesback> {
	SqlManager sqlManager = null;

	public SalesbackDao() {
		sqlManager = SqlManager.createInstance();
		sqlManager.connectDB();// ��ȡ���ݿ�����
	}

	@Override
	public boolean save(Salesback salesback) {
		// ��дsql���
		String sql = "insert into t_salesback values(?,?,?,?,?,?,?,?,?,?)";
		// ��װ����
		Object[] params = new Object[] { salesback.getId(), salesback.getNumber(), salesback.getPrice(),
				salesback.getCOMMENT(), salesback.getCustomer_id(), salesback.getSalestime(),
				salesback.getOperateperson(), salesback.getSponsor(), salesback.getPaytype(), salesback.getGoods_id() };
		// ִ��sql
		return sqlManager.executeUpdate(sql, params, Constants.PSTM_TYPE);
	}

	@Override
	public String getId() {
		// ��ȡ���µ�id
		String sql = "select MAX(id) id from t_salesback";
		// ִ��sql
		ResultSet rs = sqlManager.executeQuery(sql, null, Constants.PSTM_TYPE);
		String id = "sc1";
		try {
			if (rs != null && rs.next()) {
				String sid = rs.getString("id");// ��ȡǰһ�β����id
				if (sid != null) {
					String str = sid.substring(2);// ��ȡ����е�����
					id = "sc" + (Integer.parseInt(str) + 1);
				}
			}
		} catch (SQLException e) {
			ErrorManager.printError("SalesbackDao getCustomerId()", e);
		}
		return id;

	}

	@Override
	public List<Salesback> query(Salesback salesback) {
		List<Salesback> list = null;
		String sql = null;
		Object[] params = null;
		if (salesback == null) {// û�в���
			// ��дsql
			sql = "select * from t_salesback";
		} else if (salesback.getSalestime() != null) {
			sql = "select * from t_salesback where 0 like ? and 1 >= ? and 2 >= ? and 3 like ? and 4 like ? and 5 = ? and 6 like ? and 7 like ? and 8 like ? and 9 like ?";
			params = new Object[] { "%" + salesback.getId() + "%", salesback.getNumber(), salesback.getPrice(),
					"%" + salesback.getCOMMENT() + "%", "%" + salesback.getCustomer_id() + "%", salesback.getSalestime(),
					"%" + salesback.getOperateperson() + "%", "%" + salesback.getSponsor() + "%",
					"%" + salesback.getPaytype() + "%", "%" + salesback.getGoods_id() + "%" };
		} else {
			sql = "select * from t_salesback where 0 like ? and 1 >= ? and 2 >= ? and 3 like ? and 4 like ? and 6 like ? and 7 like ? and 8 like ? and 9 like ?";
			params = new Object[] { "%" + salesback.getId() + "%", salesback.getNumber(), salesback.getPrice(),
					"%" + salesback.getCOMMENT() + "%", "%" + salesback.getCustomer_id() + "%",
					"%" + salesback.getOperateperson() + "%", "%" + salesback.getSponsor() + "%",
					"%" + salesback.getPaytype() + "%", "%" + salesback.getGoods_id() + "%" };
		}
		// ִ��sql
		ResultSet rs = sqlManager.executeQuery(sql, params, Constants.PSTM_TYPE);
		// ���������
		if (rs != null) {
			list = new ArrayList<Salesback>();
			try {
				while (rs.next()) {
					Salesback _sal = new Salesback();
					_sal.setId(rs.getString("id"));
					_sal.setPrice(rs.getFloat("price"));
					_sal.setCOMMENT(rs.getString("COMMENT"));
					_sal.setCustomer_id(rs.getString("customer_id"));
					_sal.setSalestime(rs.getDate("salestime"));
					_sal.setOperateperson(rs.getString("operateperson"));
					_sal.setSponsor(rs.getString("sponsor"));
					_sal.setPaytype(rs.getString("paytype"));
					_sal.setGoods_id(rs.getString("goods_id"));
					list.add(_sal);
				}
			} catch (SQLException e) {
				ErrorManager.printError("SalesDao query()", e);
			}
		}
		return list;
	}

	@Override
	public boolean update(Salesback sales) {
		if (sales != null) {
			String sql = "update t_salesback set number=? and price=? and COMMENT=? and customer_id=? and salestime=? and operateperson=? and sponsor=? and paytype=? and goods_id=? where id=?";
			Object[] params = new Object[] { sales.getNumber(), sales.getPrice(), sales.getCOMMENT(),
					sales.getCustomer_id(), sales.getSalestime(), sales.getOperateperson(), sales.getSponsor(),
					sales.getPaytype(), sales.getGoods_id(), sales.getId() };
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
