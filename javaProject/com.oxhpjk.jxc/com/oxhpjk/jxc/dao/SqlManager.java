package com.oxhpjk.jxc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;

import com.oxhpjk.jxc.common.Constants;

/**
 * 执行数据库的各种操作
 * @author 24349
 *
 */

public class SqlManager {
	
	private String DBtype;
	private String DBhost;
	private String DBname;
	private String DBport;
	private String DBuser;
	private String DBpassword;
	private String DBdriver;
	
	private String _url;
	
	private PropertyResourceBundle bundle;
	private Connection con;
	private PreparedStatement pstm = null;// 预处理接口
	private CallableStatement cstm = null;// 过程函数接口
	
	/**
	 * 单例模式
	 */
	private static SqlManager instance;
	public static SqlManager getInstance() {
		if(instance == null) {
			instance = new SqlManager();
			instance.iniDataBase();
		}
		return instance;
	}
	
	
	/**
	 * 	配置数据库驱动
	 */
	private void iniDataBase() {
		try {
			Class.forName(DBdriver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("成功加载数据库驱动。");
	}
	

	
	/**
	 * 初始化SqlManager
	 */
	private SqlManager() {
		try {
			this.bundle = new PropertyResourceBundle(SqlManager.class.getResourceAsStream("DBconfig.propertise"));
			this.DBtype = getString("Database-type");
			this.DBhost = getString("DBhost");
			this.DBname = getString("DBname");
			this.DBport = getString("DBport");
			this.DBuser = getString("DBuser");
			this.DBpassword = getString("DBpassword");
			this.DBdriver = getString("DBdriver");
			this._url = "jdbc:mysql://"+DBhost+":"+DBport+"/"+DBname;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getString(String str) {
		return bundle.getString(str);
	}
	
	
	/**
	 * 	连接数据库
	 */
	public void connectDB() {
		try {
			con = DriverManager.getConnection(_url, DBuser, DBpassword);
			/**
			 * 	事务自动提交选项。如果为true则修改自动提交，为false事，需要手动commit
			 */
			con.setAutoCommit(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 	关闭连接
	 */
	public void closeConnect() {
		try {
			if(con != null) {
				con.close();
			}
			con = null;
			pstm = null;
			cstm = null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 	执行数据库查询操作
	 * @param sql	SQL语句
	 * @param parms		替换参数
	 * @param type		SQL语句类型
	 * @return	
	 */
	public ResultSet excuteQuery(String sql,Object[] parms,int type) {
		ResultSet res = null; //查询结果
		
		switch (type) {
		case Constants.PSTM_TYPE:
			setPrepareStatementParams(sql, parms);
			try {
				res = pstm.executeQuery();		//执行sql语句
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case Constants.CALL_TYPE:
			setCallableStatementParams(sql, parms);
			try {
				res = cstm.executeQuery();		//执行sql语句
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			//异常处理，没有找到对应的处理方式
			break;
		}
		return res;
	}
	
	
	/**
	 * 	执行数据库跟新操作
	 * @param sql	SQL语句
	 * @param parms		替换参数
	 * @param type		SQL语句类型
	 * @return	
	 */
	public boolean excuteUpdate(String sql,Object[] parms,int type) {
		boolean res = false;
		
		switch (type) {
		case Constants.PSTM_TYPE:
			setPrepareStatementParams(sql, parms);
			try {
				pstm.executeUpdate();		//执行sql语句
				instance.commit();
				res = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case Constants.CALL_TYPE:
			setCallableStatementParams(sql, parms);
			try {
				cstm.executeUpdate();		//执行sql语句
				instance.commit();				
				res = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			//异常处理，没有找到对应的处理方式
			break;
		}
		return res;
	}
	
	
	private void commit() {
		try {
			con.commit();
			System.out.println("提交成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 	设置PrepareStatement对象的参数（用于替换SQL中）
	 */
	private void setPrepareStatementParams(String sql,Object[] parms) {
		try {
			pstm = con.prepareStatement(sql);
			if(parms != null && parms.length > 0) {
				for(int i = 0;i<parms.length;i++) {
					pstm.setObject(i+1, parms[i]);		//pstm中参数从1开始
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 	设置CallableStatement对象的参数（用于替换SQL中）
	 */
	private void setCallableStatementParams(String sql,Object[] parms) {
		try {
			cstm = con.prepareCall(sql);
			if(parms.length > 0) {
				for(int i = 0;i<parms.length;i++) {
					cstm.setObject(i+1, parms[i]);		//cstm中参数从1开始
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
