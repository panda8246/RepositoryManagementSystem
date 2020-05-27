package com.oxhpjk.jxc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oxhpjk.jxc.commom.Constants;
import com.oxhpjk.jxc.commom.ErrorManager;
import com.oxhpjk.jxc.model.Goods;
import com.oxhpjk.jxc.model.Inport;

public class InportDao implements BaseDao<Inport>{
	
	SqlManager sqlManager = null;

	public InportDao() {
		sqlManager = SqlManager.createInstance();
		sqlManager.connectDB();// 获取数据库连接
	}

	@Override
	/*
	 *  添加/插入
	 * @see com.oxhpjk.jxc.dao.BaseDao#save(java.lang.Object)
	 */
	public boolean save(Inport inport) {
		// 编写sql语句
		String sql = "insert into t_inport values(?,?,?,?,?,?,?,?,?,?)";
		// 封装参数
		Object[] params = new Object[] {inport.getId(),inport.getNumber(),inport.getPrice(),inport.getCOMMENT(),inport.getProvider_id(),inport.getInporttime(),inport.getOperateperson(),inport.getSponsor(),inport.getPaytype(),inport.getGoods_id() };
		// 执行sql
		return sqlManager.executeUpdate(sql, params, Constants.PSTM_TYPE);
	}

	@Override
	public String getId() {
		// 获取最新的id
		String sql = "select MAX(id) id from t_inport";
		// 执行sql
		ResultSet rs = sqlManager.executeQuery(sql, null, Constants.PSTM_TYPE);
		String id = "GT1000001";
		try {
			if (rs != null && rs.next()) {
				String sid = rs.getString("id");// 获取前一次插入的id
				if (sid != null) {
					String str = sid.substring(2);// 截取编号中的数字
					id = "GT" + (Integer.parseInt(str) + 1);
				}
			}
		} catch (SQLException e) {
			ErrorManager.printError("GoodsDao getCustomerId()", e);
		}
		return id;
	}

	@Override
	public List<Inport> query(Inport inport) {
		List<Inport> list = null;
		String sql = null;
		Object[] params = null;
		if (inport == null) {// 没有参数
			// 编写sql
			sql = "select * from t_inport";
		}else if (inport.getInporttime() != null) {
			sql = "select * from t_inport where 0 like ? and 1 >= ? and 2 >= ? and 3 like ? and 4 like ? and 5 = ? and 6 like ? and 7 like ? and 8 like ? and 9 like ?";
			params = new Object[] {"%"+inport.getId()+"%",inport.getNumber(),inport.getPrice(),"%"+inport.getCOMMENT()+"%","%"+inport.getProvider_id()+"%",inport.getInporttime(),"%"+inport.getOperateperson()+"%","%"+inport.getSponsor()+"%","%"+inport.getPaytype()+"%","%"+inport.getGoods_id()+"%"};
		} else {
			sql = "select * from t_inport where 0 like ? and 1 >= ? and 2 >= ? and 3 like ? and 4 like ? and 6 like ? and 7 like ? and 8 like ? and 9 like ?";			
			params = new Object[] {"%"+inport.getId()+"%",inport.getNumber(),inport.getPrice(),"%"+inport.getCOMMENT()+"%","%"+inport.getProvider_id()+"%","%"+inport.getOperateperson()+"%","%"+inport.getSponsor()+"%","%"+inport.getPaytype()+"%","%"+inport.getGoods_id()+"%"};
			
		}
		// 执行sql
		ResultSet rs = sqlManager.executeQuery(sql, params, Constants.PSTM_TYPE);
		// 解析结果集
		if (rs != null) {
			list = new ArrayList<Inport>();
			try {
				while (rs.next()) {
					Inport _ins = new Inport();
					_ins.setId(rs.getString("id"));
					_ins.setPrice(rs.getFloat("price"));
					_ins.setCOMMENT(rs.getString("COMMENT"));
					_ins.setProvider_id(rs.getString("provider_id"));
					_ins.setInporttime(rs.getDate("inporttime"));
					_ins.setOperateperson(rs.getString("operateperson"));
					_ins.setSponsor(rs.getString("sponsor"));
					_ins.setPaytype(rs.getString("paytype"));
					_ins.setGoods_id(rs.getString("goods_id"));
					list.add(_ins);
				}
			} catch (SQLException e) {
				ErrorManager.printError("GoodsDao query()", e);
			}
		}
		return list;
	}

	@Override
	public boolean update(Inport inport) {
		if (inport != null) {
			String sql = "update t_inport set number=? and price=? and COMMENT=? and provider_id=? and inporttime=? and operateperson=? and sponsor=? and paytype=? and goods_id=? where id=?";
			Object[] params = new Object[] {inport.getNumber(),inport.getPrice(),inport.getCOMMENT(),inport.getProvider_id(),inport.getInporttime(),inport.getOperateperson(),inport.getSponsor(),inport.getPaytype(),inport.getGoods_id(),inport.getId()};
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
