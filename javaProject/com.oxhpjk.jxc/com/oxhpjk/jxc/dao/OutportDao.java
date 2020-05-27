package com.oxhpjk.jxc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oxhpjk.jxc.commom.Constants;
import com.oxhpjk.jxc.commom.ErrorManager;
import com.oxhpjk.jxc.model.Goods;
import com.oxhpjk.jxc.model.Inport;
import com.oxhpjk.jxc.model.Outport;

public class OutportDao implements BaseDao<Outport>{
	
	SqlManager sqlManager = null;

	public OutportDao() {
		sqlManager = SqlManager.createInstance();
		sqlManager.connectDB();// 获取数据库连接
	}

	@Override
	/*
	 *  添加/插入
	 * @see com.oxhpjk.jxc.dao.BaseDao#save(java.lang.Object)
	 */
	public boolean save(Outport outport) {
		// 编写sql语句
		String sql = "insert into t_outport values(?,?,?,?,?,?,?,?,?,?)";
		// 封装参数
		Object[] params = new Object[] {outport.getId(),outport.getNumber(),outport.getPrice(),outport.getCOMMENT(),outport.getProvider_id(),outport.getInporttime(),outport.getOperateperson(),outport.getSponsor(),outport.getPaytype(),outport.getGoods_id() };
		// 执行sql
		return sqlManager.executeUpdate(sql, params, Constants.PSTM_TYPE);
	}

	@Override
	public String getId() {
		// 获取最新的id
		String sql = "select MAX(id) id from t_outport";
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
			ErrorManager.printError("OutportDao getCustomerId()", e);
		}
		return id;
	}

	@Override
	public List<Outport> query(Outport outport) {
		List<Outport> list = null;
		String sql = null;
		Object[] params = null;
		if (outport == null) {// 没有参数
			// 编写sql
			sql = "select * from t_outport";
		}else if (outport.getInporttime() != null) {
			sql = "select * from t_outport where 0 like ? and 1 >= ? and 2 >= ? and 3 like ? and 4 like ? and 5 = ? and 6 like ? and 7 like ? and 8 like ? and 9 like ?";
			params = new Object[] {"%"+outport.getId()+"%",outport.getNumber(),outport.getPrice(),"%"+outport.getCOMMENT()+"%","%"+outport.getProvider_id()+"%",outport.getInporttime(),"%"+outport.getOperateperson()+"%","%"+outport.getSponsor()+"%","%"+outport.getPaytype()+"%","%"+outport.getGoods_id()+"%"};
		} else {
			sql = "select * from t_outport where 0 like ? and 1 >= ? and 2 >= ? and 3 like ? and 4 like ? and 6 like ? and 7 like ? and 8 like ? and 9 like ?";			
			params = new Object[] {"%"+outport.getId()+"%",outport.getNumber(),outport.getPrice(),"%"+outport.getCOMMENT()+"%","%"+outport.getProvider_id()+"%","%"+outport.getOperateperson()+"%","%"+outport.getSponsor()+"%","%"+outport.getPaytype()+"%","%"+outport.getGoods_id()+"%"};
			
		}
		// 执行sql
		ResultSet rs = sqlManager.executeQuery(sql, params, Constants.PSTM_TYPE);
		// 解析结果集
		if (rs != null) {
			list = new ArrayList<Outport>();
			try {
				while (rs.next()) {
					Outport _out = new Outport();
					_out.setId(rs.getString("id"));
					_out.setPrice(rs.getFloat("price"));
					_out.setCOMMENT(rs.getString("COMMENT"));
					_out.setProvider_id(rs.getString("provider_id"));
					_out.setInporttime(rs.getDate("inporttime"));
					_out.setOperateperson(rs.getString("operateperson"));
					_out.setSponsor(rs.getString("sponsor"));
					_out.setPaytype(rs.getString("paytype"));
					_out.setGoods_id(rs.getString("goods_id"));
					list.add(_out);
				}
			} catch (SQLException e) {
				ErrorManager.printError("OutportDao query()", e);
			}
		}
		return list;
	}

	@Override
	public boolean update(Outport outport) {
		if (outport != null) {
			String sql = "update t_outport set number=? and price=? and COMMENT=? and provider_id=? and inporttime=? and operateperson=? and sponsor=? and paytype=? and goods_id=? where id=?";
			Object[] params = new Object[] {outport.getNumber(),outport.getPrice(),outport.getCOMMENT(),outport.getProvider_id(),outport.getInporttime(),outport.getOperateperson(),outport.getSponsor(),outport.getPaytype(),outport.getGoods_id(),outport.getId()};
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