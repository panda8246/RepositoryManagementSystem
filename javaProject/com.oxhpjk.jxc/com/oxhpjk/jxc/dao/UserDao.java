package com.oxhpjk.jxc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oxhpjk.jxc.common.Constants;
import com.oxhpjk.jxc.modle.User;

/**
 * 	��User�������ݿ����
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
		//���صĽ��
		ResultSet res = manager.excuteQuery(sql, parms, Constants.PSTM_TYPE);
		boolean result = false;
		try {
			while(res.next()) {
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//���ִ���
		return result;
	}
		
}
