package com.oxhpjk.jxc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.oxhpjk.jxc.commom.*;


import com.oxhpjk.jxc.commom.Constants;
import com.oxhpjk.jxc.model.Operator;

/**
 * 针对t_operator表进行CRUD
 * @author 22161
 *
 */
public class OperatorDao {
	SqlManager manager=null;
	
	public OperatorDao() {
		super();
		//实例化
		manager=SqlManager.createInstance();
		manager.connectDB();//获取连接
	}

	/**
	 * 查询用户名密码是否正确
	 * @param operator
	 * @return
	 */
	public boolean loginCheck(Operator operator) {
		boolean result=false;
		try {
			//编写sql语句
			String sql="select * from t_operator WHERE username=? and password=?";
			//封装参数
			Object[] params =new  Object[] {operator.getUsername(),operator.getPassword()};
		
			//获取结果集
			ResultSet rs=manager.executeQuery(sql, params, Constants.PSTM_TYPE);
		   while (rs.next()) {
			   result=true;
			   }
		   manager.closeDB();
		   }
			catch (SQLException e) {
			ErrorManager.printError("OperatorDao loginChecr()",e);
		
		}	
		return result;
		
		
		
	}
	/**
	 * 通过用户名查询操作者信息
	 * @param username
	 * @return
	 */

	public Operator getOperator(String username) {
		//编写sql语句
		String sql="select * from t_operator where username=?";
		Object [] params=new Object[] {username};
		ResultSet rs =manager.executeQuery(sql, params, Constants.PSTM_TYPE);
		Operator operator=null;
	    try {
			if(rs!=null) {
				while (rs.next()){
					operator=new Operator(rs.getString("username"),rs.getString("password"),rs.getString("name"),rs.getString("power"));
					
				}
			}
		} catch (SQLException e) {
			ErrorManager.printError("OperatorDao getOperator()", e);
		}
		return operator;
	}
	
	
	/**
	 * 	修改密码，名字，权限
	 * @param opreator
	 * @return
	 */
	public boolean update(Operator opreator) {
		String password = opreator.getPassword();
		String name = opreator.getName();
		String power = opreator.getPower();
		String username = opreator.getUsername();
		String sql = "update t_operator set password=?,name=?,power=? where username=?";
		Object[] params = new Object[] {password,name,password,username};
		SqlManager sqlManager = SqlManager.createInstance();
		return sqlManager.executeUpdate(sql, params, Constants.PSTM_TYPE);
	}

	
}
