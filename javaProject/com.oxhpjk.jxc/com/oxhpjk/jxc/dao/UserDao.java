package com.oxhpjk.jxc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oxhpjk.jxc.common.Constants;
import com.oxhpjk.jxc.modle.User;

/**
 * 	对User进行数据库操作
 * @author 24349
 *
 */
public class UserDao {
	
	SqlManager manager;
	
	public UserDao() {
		manager = SqlManager.getInstance();
	}
	
	public boolean login(User user) {
		manager.connectDB();
		String sql = "select * from t_user where account = ? and password = ?";
		Object[] parms = new Object[] {user.getAccount(),user.getPassword()};
		//返回的结果
		ResultSet res = manager.excuteQuery(sql, parms, Constants.PSTM_TYPE);
		boolean result = false;
		try {
			while(res.next()) {
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//出现错误
		return result;
	}
		
}
