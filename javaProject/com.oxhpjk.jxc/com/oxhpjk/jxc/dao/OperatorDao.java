package com.oxhpjk.jxc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.oxhpjk.jxc.commom.*;
import com.oxhpjk.jxc.model.Operator;

/**
 * ���t_operator�����CRUD
 * @author 22161
 *
 */
public class OperatorDao {
	SqlManager manager=null;
	
	public String getId() {
		// ��ȡ���µ�id
		String sql = "select MAX(id) id from t_operator";
		// ִ��sql
		ResultSet rs = manager.executeQuery(sql, null, Constants.PSTM_TYPE);
		String id = "op1";
		try {
			if (rs != null && rs.next()) {
				String sid = rs.getString("id");// ��ȡǰһ�β����id
				if (sid != null) {
					String str = sid.substring(2);// ��ȡ����е�����
					id = "op" + (Integer.parseInt(str) + 1);
				}
			}
		} catch (SQLException e) {
			ErrorManager.printError("OutportDao getCustomerId()", e);
		}
		return id;
	}
	
	public OperatorDao() {
		super();
		//ʵ����
		manager=SqlManager.createInstance();
		manager.connectDB();//��ȡ����
	}

	/**
	 * ��ѯ�û��������Ƿ���ȷ
	 * @param operator
	 * @return
	 */
	public boolean loginCheck(Operator operator) {
		boolean result=false;
		try {
			//��дsql���
			String sql="select * from t_operator WHERE username=? and password=?";
			//��װ����
			Object[] params =new  Object[] {operator.getUsername(),operator.getPassword()};
		
			//��ȡ�����
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
	 * ͨ���û�����ѯ��������Ϣ
	 * @param username
	 * @return
	 */

	public Operator getOperator(String username) {
		//��дsql���
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
	 * 	�޸����룬���֣�Ȩ��
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
