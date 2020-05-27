package com.oxhpjk.jxc.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;

import javax.swing.JOptionPane;

import com.oxhpjk.jxc.commom.Constants;
import com.oxhpjk.jxc.commom.ErrorManager;
/**
 * 数据库访问工具类，进行数据库的底层操作，配置信息在SqlConfig.properties文件中
 * @author FPF
 *
 */
public class SqlManager {
	private static SqlManager manager = null;// 静态成员变量，支持单例模式
	private PropertyResourceBundle bundle = null;// 配置资源文件
	private static String jdbcDrive = null;// JDBC驱动类型
	private String DBhost = "";// 数据库主机地址
	private String DBname = "";// 数据库名
	private String DBport = "";// 数据库端口
	private String DBuser = "";// 数据库用户名
	private String DBpassword = "";// 数据库密码
	private String strcon;// 连接字符串

	private Connection conn = null;// 连接对象
	private PreparedStatement pstm = null;// 预处理接口
	private CallableStatement cstm = null;// 过程函数接口
    /**
     * 私有构造函数，不可实例化
     */
	private SqlManager() {
		try {
			//读取配置文件
			bundle = new PropertyResourceBundle(SqlManager.class.getResourceAsStream("SqlConfig.properties"));
			this.DBhost = getString("DBhost");//读取主机名
			this.DBname = getString("DBname");//读取用户名
			this.DBport = getString("DBport");//读取端口号
			this.DBuser = getString("DBuser");//读取用户名
			this.DBpassword = getString("DBpassword");//读取密码
			String database_type =getString("database-type");//读取数据库类型
			if(database_type !=null) {// 如果类型不为空
				if(database_type.toLowerCase().equals("mysql")) {//设置mysql数据库的驱动程序和连接字符
					jdbcDrive = "com.mysql.cj.jdbc.Driver";
					strcon ="jdbc:mysql://"+DBhost+":"+DBport+"/"+DBname;
				}else if(database_type.toLowerCase().equals("oracle")) {//设置oracle数据库的驱动程序和连接字符
					jdbcDrive = "oracle.jdbc.driver.OracleDriver";
					strcon ="jdbc:oracle:thin:@"+DBhost+":"+DBport+":"+DBname;
				}else if(database_type.toLowerCase().equals("sqlserver2005")) {//设置sqlserver2005数据库的驱动程序和连接字符
					jdbcDrive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
					strcon ="jdbc:sqlserver://"+DBhost+":"+DBport+";databaseName="+DBname;
				}
			}
		} catch (Exception e) {
			ErrorManager.printError("SqlManager 构造方法", e);
		}
	}
	/**
	 * 读取配置文件中的值
	 * @param key：配置文件中的key
	 * @return：key对应的value
	 */
	private String getString(String key) {
		return this.bundle.getString(key);
	}
	/**
	 * 单例模式获取实例
	 * @return
	 */
	public static SqlManager createInstance() {
		if(manager==null) {
			manager = new SqlManager();
			//初始化之类的...
			manager.initDB();
		}
		return manager;
	}
	/**
	 * 初始化连接参数，由指定的DBtype生成
	 */
	public void initDB() {
		try {
			Class.forName(jdbcDrive);
		} catch (Exception e) {
			ErrorManager.printError("SqlManager initDB()", e);
		}
		System.out.println("成功加载驱动类！");
	}
	/**
	 * 连接数据库
	 */
    public void connectDB() {
    	try {
			conn= DriverManager.getConnection(strcon, DBuser, DBpassword);//获取连接
			conn.setAutoCommit(false);//设置为非自动提交事务
		} catch (SQLException e) {
			if(e.getErrorCode()==0) {
				JOptionPane.showMessageDialog(null, "数据库未启动，请检查配置是否正确！","警告",JOptionPane.WARNING_MESSAGE);
			}
			if(e.getErrorCode()==1045) {
				JOptionPane.showMessageDialog(null, "数据库连接错误，请检查用户名和密码是否正确！","警告",JOptionPane.WARNING_MESSAGE);
			}
			if(e.getErrorCode()==1049) {
				JOptionPane.showMessageDialog(null, "数据库名称错误，请检查数据库名称是否正确！","警告",JOptionPane.WARNING_MESSAGE);
			}
			ErrorManager.printError("SqlManager connectDB()", e);
			return;
		}
    	System.out.println("成功连接到数据库！");
    }
    /**
     * 关闭数据库
     */
    public void closeDB() {
    	try {
			if(pstm!=null) {
				pstm.close();
			}
			if(cstm!=null) {
				cstm.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (Exception e) {
			ErrorManager.printError("SqlManager closeDB()", e);
		} finally {
			pstm = null;
			cstm = null;
			conn = null;
		}
    	System.out.println("成功关闭数据库！");
    }
    /**
     * 设置PrepareStatement对象中sql语句中的参数
     * @param sql：sql语句
     * @param params：参数列表
     */
    private void setPrepareStatementParams(String sql,Object[] params) {
    	try {
			pstm = conn.prepareStatement(sql);//获取预处理对象
			if(params!=null) {
				for (int i = 0; i < params.length; i++) {//遍历参数列表填充参数
					pstm.setObject(i+1, params[i]);//索引是从1开始
				}
			}
		} catch (SQLException e) {
			ErrorManager.printError("SqlManager setPrepareStatementParams()", e);
		}
    }
    /**
     * 设置CallableStatement对象中sql语句中的参数
     * @param sql
     * @param params
     */
    private void setCallableStatementParams(String sql,Object[] params) {
    	try {
			cstm = conn.prepareCall(sql);//获取CallableStatement
			if(params != null) {
				for (int i = 0; i < params.length; i++) {
					cstm.setObject(i+1, params[i]);
				}
			}
		} catch (SQLException e) {
			ErrorManager.printError("SqlManager setCallableStatementParams()", e);
		}
    }
    /**
     * 执行查询
     * @param sql：sql语句
     * @param params：参数列表
     * @param type：sql语句类型：Constants.PSTM_TYPE，Constants.CALL_TYPE
     * @return
     */
    public ResultSet executeQuery(String sql,Object[] params,int type) {
    	ResultSet rs = null;
    	try {
			switch (type) {
			case Constants.PSTM_TYPE://预处理
				manager.setPrepareStatementParams(sql, params);
				rs = pstm.executeQuery();
				break;
			case Constants.CALL_TYPE://过程函数
				manager.setCallableStatementParams(sql, params);
				rs = cstm.executeQuery();
				break;
			default:
				throw new Exception("不存在该选项");
			}
		} catch (Exception e) {
			ErrorManager.printError("SqlManager executeQuery()", e);
		}
    	return rs;
    }
    /**
     * 更新数据库操作
     * @param sql：sql语句
     * @param params：参数列表
     * @param type：sql语句类型：Constants.PSTM_TYPE，Constants.CALL_TYPE
     * @return
     */
    public boolean executeUpdate(String sql,Object[] params,int type) {
    	boolean result = false;//默认是失败
    	try {
			switch (type) {
			case Constants.PSTM_TYPE://传统的预处理
				manager.setPrepareStatementParams(sql, params);//填充参数
				pstm.executeUpdate();//执行更新
				manager.commitChange();//提交事务
				result = true;//成功
				break;
			case Constants.CALL_TYPE://调用过程函数
				manager.setCallableStatementParams(sql, params);
				cstm.executeUpdate();//执行更新
				manager.commitChange();//提交事务
				result = true;
				break;
			default:
				throw new Exception("不存在该选项！");
			}
		} catch (Exception e) {
			ErrorManager.printError("SqlManager executeUpdate()", e);
		}
    	return result;
    }
    /**
     * 提交数据到数据库
     * @throws SQLException
     */
    private void commitChange() throws SQLException{
    	try {
			conn.commit();
			System.out.println("数据提交成功！");
		} catch (SQLException e) {
			ErrorManager.printError("SqlManager commitChange()", e);
		}
    }
    
    
    
}