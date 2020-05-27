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
 * ���ݿ���ʹ����࣬�������ݿ�ĵײ������������Ϣ��SqlConfig.properties�ļ���
 * @author FPF
 *
 */
public class SqlManager {
	private static SqlManager manager = null;// ��̬��Ա������֧�ֵ���ģʽ
	private PropertyResourceBundle bundle = null;// ������Դ�ļ�
	private static String jdbcDrive = null;// JDBC��������
	private String DBhost = "";// ���ݿ�������ַ
	private String DBname = "";// ���ݿ���
	private String DBport = "";// ���ݿ�˿�
	private String DBuser = "";// ���ݿ��û���
	private String DBpassword = "";// ���ݿ�����
	private String strcon;// �����ַ���

	private Connection conn = null;// ���Ӷ���
	private PreparedStatement pstm = null;// Ԥ����ӿ�
	private CallableStatement cstm = null;// ���̺����ӿ�
    /**
     * ˽�й��캯��������ʵ����
     */
	private SqlManager() {
		try {
			//��ȡ�����ļ�
			bundle = new PropertyResourceBundle(SqlManager.class.getResourceAsStream("SqlConfig.properties"));
			this.DBhost = getString("DBhost");//��ȡ������
			this.DBname = getString("DBname");//��ȡ�û���
			this.DBport = getString("DBport");//��ȡ�˿ں�
			this.DBuser = getString("DBuser");//��ȡ�û���
			this.DBpassword = getString("DBpassword");//��ȡ����
			String database_type =getString("database-type");//��ȡ���ݿ�����
			if(database_type !=null) {// ������Ͳ�Ϊ��
				if(database_type.toLowerCase().equals("mysql")) {//����mysql���ݿ����������������ַ�
					jdbcDrive = "com.mysql.cj.jdbc.Driver";
					strcon ="jdbc:mysql://"+DBhost+":"+DBport+"/"+DBname;
				}else if(database_type.toLowerCase().equals("oracle")) {//����oracle���ݿ����������������ַ�
					jdbcDrive = "oracle.jdbc.driver.OracleDriver";
					strcon ="jdbc:oracle:thin:@"+DBhost+":"+DBport+":"+DBname;
				}else if(database_type.toLowerCase().equals("sqlserver2005")) {//����sqlserver2005���ݿ����������������ַ�
					jdbcDrive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
					strcon ="jdbc:sqlserver://"+DBhost+":"+DBport+";databaseName="+DBname;
				}
			}
		} catch (Exception e) {
			ErrorManager.printError("SqlManager ���췽��", e);
		}
	}
	/**
	 * ��ȡ�����ļ��е�ֵ
	 * @param key�������ļ��е�key
	 * @return��key��Ӧ��value
	 */
	private String getString(String key) {
		return this.bundle.getString(key);
	}
	/**
	 * ����ģʽ��ȡʵ��
	 * @return
	 */
	public static SqlManager createInstance() {
		if(manager==null) {
			manager = new SqlManager();
			//��ʼ��֮���...
			manager.initDB();
		}
		return manager;
	}
	/**
	 * ��ʼ�����Ӳ�������ָ����DBtype����
	 */
	public void initDB() {
		try {
			Class.forName(jdbcDrive);
		} catch (Exception e) {
			ErrorManager.printError("SqlManager initDB()", e);
		}
		System.out.println("�ɹ����������࣡");
	}
	/**
	 * �������ݿ�
	 */
    public void connectDB() {
    	try {
			conn= DriverManager.getConnection(strcon, DBuser, DBpassword);//��ȡ����
			conn.setAutoCommit(false);//����Ϊ���Զ��ύ����
		} catch (SQLException e) {
			if(e.getErrorCode()==0) {
				JOptionPane.showMessageDialog(null, "���ݿ�δ���������������Ƿ���ȷ��","����",JOptionPane.WARNING_MESSAGE);
			}
			if(e.getErrorCode()==1045) {
				JOptionPane.showMessageDialog(null, "���ݿ����Ӵ��������û����������Ƿ���ȷ��","����",JOptionPane.WARNING_MESSAGE);
			}
			if(e.getErrorCode()==1049) {
				JOptionPane.showMessageDialog(null, "���ݿ����ƴ����������ݿ������Ƿ���ȷ��","����",JOptionPane.WARNING_MESSAGE);
			}
			ErrorManager.printError("SqlManager connectDB()", e);
			return;
		}
    	System.out.println("�ɹ����ӵ����ݿ⣡");
    }
    /**
     * �ر����ݿ�
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
    	System.out.println("�ɹ��ر����ݿ⣡");
    }
    /**
     * ����PrepareStatement������sql����еĲ���
     * @param sql��sql���
     * @param params�������б�
     */
    private void setPrepareStatementParams(String sql,Object[] params) {
    	try {
			pstm = conn.prepareStatement(sql);//��ȡԤ�������
			if(params!=null) {
				for (int i = 0; i < params.length; i++) {//���������б�������
					pstm.setObject(i+1, params[i]);//�����Ǵ�1��ʼ
				}
			}
		} catch (SQLException e) {
			ErrorManager.printError("SqlManager setPrepareStatementParams()", e);
		}
    }
    /**
     * ����CallableStatement������sql����еĲ���
     * @param sql
     * @param params
     */
    private void setCallableStatementParams(String sql,Object[] params) {
    	try {
			cstm = conn.prepareCall(sql);//��ȡCallableStatement
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
     * ִ�в�ѯ
     * @param sql��sql���
     * @param params�������б�
     * @param type��sql������ͣ�Constants.PSTM_TYPE��Constants.CALL_TYPE
     * @return
     */
    public ResultSet executeQuery(String sql,Object[] params,int type) {
    	ResultSet rs = null;
    	try {
			switch (type) {
			case Constants.PSTM_TYPE://Ԥ����
				manager.setPrepareStatementParams(sql, params);
				rs = pstm.executeQuery();
				break;
			case Constants.CALL_TYPE://���̺���
				manager.setCallableStatementParams(sql, params);
				rs = cstm.executeQuery();
				break;
			default:
				throw new Exception("�����ڸ�ѡ��");
			}
		} catch (Exception e) {
			ErrorManager.printError("SqlManager executeQuery()", e);
		}
    	return rs;
    }
    /**
     * �������ݿ����
     * @param sql��sql���
     * @param params�������б�
     * @param type��sql������ͣ�Constants.PSTM_TYPE��Constants.CALL_TYPE
     * @return
     */
    public boolean executeUpdate(String sql,Object[] params,int type) {
    	boolean result = false;//Ĭ����ʧ��
    	try {
			switch (type) {
			case Constants.PSTM_TYPE://��ͳ��Ԥ����
				manager.setPrepareStatementParams(sql, params);//������
				pstm.executeUpdate();//ִ�и���
				manager.commitChange();//�ύ����
				result = true;//�ɹ�
				break;
			case Constants.CALL_TYPE://���ù��̺���
				manager.setCallableStatementParams(sql, params);
				cstm.executeUpdate();//ִ�и���
				manager.commitChange();//�ύ����
				result = true;
				break;
			default:
				throw new Exception("�����ڸ�ѡ�");
			}
		} catch (Exception e) {
			ErrorManager.printError("SqlManager executeUpdate()", e);
		}
    	return result;
    }
    /**
     * �ύ���ݵ����ݿ�
     * @throws SQLException
     */
    private void commitChange() throws SQLException{
    	try {
			conn.commit();
			System.out.println("�����ύ�ɹ���");
		} catch (SQLException e) {
			ErrorManager.printError("SqlManager commitChange()", e);
		}
    }
    
    
    
}