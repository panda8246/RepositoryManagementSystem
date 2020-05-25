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
 * ִ�����ݿ�ĸ��ֲ���
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
	private PreparedStatement pstm = null;// Ԥ����ӿ�
	private CallableStatement cstm = null;// ���̺����ӿ�
	
	/**
	 * ����ģʽ
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
	 * 	�������ݿ�����
	 */
	private void iniDataBase() {
		try {
			Class.forName(DBdriver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("�ɹ��������ݿ�������");
	}
	

	
	/**
	 * ��ʼ��SqlManager
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
	 * 	�������ݿ�
	 */
	public void connectDB() {
		try {
			con = DriverManager.getConnection(_url, DBuser, DBpassword);
			/**
			 * 	�����Զ��ύѡ����Ϊtrue���޸��Զ��ύ��Ϊfalse�£���Ҫ�ֶ�commit
			 */
			con.setAutoCommit(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 	�ر�����
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
	 * 	ִ�����ݿ��ѯ����
	 * @param sql	SQL���
	 * @param parms		�滻����
	 * @param type		SQL�������
	 * @return	
	 */
	public ResultSet excuteQuery(String sql,Object[] parms,int type) {
		ResultSet res = null; //��ѯ���
		
		switch (type) {
		case Constants.PSTM_TYPE:
			setPrepareStatementParams(sql, parms);
			try {
				res = pstm.executeQuery();		//ִ��sql���
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case Constants.CALL_TYPE:
			setCallableStatementParams(sql, parms);
			try {
				res = cstm.executeQuery();		//ִ��sql���
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			//�쳣����û���ҵ���Ӧ�Ĵ���ʽ
			break;
		}
		return res;
	}
	
	
	/**
	 * 	ִ�����ݿ���²���
	 * @param sql	SQL���
	 * @param parms		�滻����
	 * @param type		SQL�������
	 * @return	
	 */
	public boolean excuteUpdate(String sql,Object[] parms,int type) {
		boolean res = false;
		
		switch (type) {
		case Constants.PSTM_TYPE:
			setPrepareStatementParams(sql, parms);
			try {
				pstm.executeUpdate();		//ִ��sql���
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
				cstm.executeUpdate();		//ִ��sql���
				instance.commit();				
				res = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			//�쳣����û���ҵ���Ӧ�Ĵ���ʽ
			break;
		}
		return res;
	}
	
	
	private void commit() {
		try {
			con.commit();
			System.out.println("�ύ�ɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 	����PrepareStatement����Ĳ����������滻SQL�У�
	 */
	private void setPrepareStatementParams(String sql,Object[] parms) {
		try {
			pstm = con.prepareStatement(sql);
			if(parms != null && parms.length > 0) {
				for(int i = 0;i<parms.length;i++) {
					pstm.setObject(i+1, parms[i]);		//pstm�в�����1��ʼ
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 	����CallableStatement����Ĳ����������滻SQL�У�
	 */
	private void setCallableStatementParams(String sql,Object[] parms) {
		try {
			cstm = con.prepareCall(sql);
			if(parms.length > 0) {
				for(int i = 0;i<parms.length;i++) {
					cstm.setObject(i+1, parms[i]);		//cstm�в�����1��ʼ
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
