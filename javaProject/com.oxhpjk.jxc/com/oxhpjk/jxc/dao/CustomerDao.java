package com.oxhpjk.jxc.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oxhpjk.jxc.commom.Constants;
import com.oxhpjk.jxc.commom.ErrorManager;
import com.oxhpjk.jxc.model.Customer;


/**
 * �����ͻ���dao
 * 
 * @author FPF
 *
 */
public class CustomerDao implements BaseDao<Customer>{
	SqlManager sqlManager = null;

	public CustomerDao() {
		sqlManager = SqlManager.createInstance();
		sqlManager.connectDB();// ��ȡ���ݿ�����
	}

	
	/**
	 * ��ӿͻ���Ϣ
	 * 
	 * @param customer
	 * @return
	 */
	@Override
	public boolean save(Customer customer) {
		// ��дsql���
				String sql = "insert into t_customer values(?,?,?,?,?,?,?,?,?,?,?,?,1)";
				// ��װ����
				Object[] params = new Object[] { customer.getId(), customer.getCustomerName(), customer.getShorts(),
						customer.getAddress(), customer.getZip(), customer.getTelephone(), customer.getFax(),
						customer.getContacts(), customer.getPhone(), customer.getBank(), customer.getAccount(),
						customer.getMail() };
				// ִ��sql
				return sqlManager.executeUpdate(sql, params, Constants.PSTM_TYPE);
			}
	
	
	/**
	 * ���ɿͻ����
	 * 
	 * @return
	 */

	@Override
	public String getId() {
		// ��ȡ���µ�id
		String sql = "select MAX(id) id from t_customer";
		// ִ��sql
		ResultSet rs = sqlManager.executeQuery(sql, null, Constants.PSTM_TYPE);
		String id = "c1";
		try {
			if (rs != null && rs.next()) {
				String sid = rs.getString("id");// ��ȡǰһ�β����id
				if (sid != null) {
					String str = sid.substring(1);// ��ȡ����е�����
					id = "c" + (Integer.parseInt(str) + 1);
				}
			}
		} catch (SQLException e) {
			ErrorManager.printError("CustomerDao getCustomerId()", e);
		}
		return id;
	}


	
	/**
	 * ��ѯ�ͻ���Ϣ
	 * 
	 * @return
	 */
	@Override
	
public List<Customer> query(Customer c) {
		List<Customer> list = null;
		String sql = null;
		Object[] params = null;
		if (c == null) {// û�в���
			// ��дsql
			sql = "select * from t_customer where available=1";
		} else {// �в������ȴ��Ժ���չ
			//���ݿͻ�ID��ѯ
			if (c.getId() != null && !c.getId().equals("")) {
				sql = "select * from t_customer where id=? and available=1";
				params = new Object[1];
				params[0] = c.getId();
			}else if(c.getCustomerName()!=null && !c.getCustomerName().equals("")) {//���ݿͻ�ȫ�Ʋ�ѯ
				sql = "select * from t_customer where customer_name like ? and available=1";
				params = new Object[1];
				params[0] = "%"+c.getCustomerName()+"%";
			}else if(c.getShorts()!=null && !c.getShorts().equals("")) {//���ݿͻ���Ʋ�ѯ
				sql = "select * from t_customer where shorts like ? and available=1";
				params = new Object[1];
				params[0] = "%"+c.getShorts()+"%";
			}else if(c.getContacts()!=null && !c.getContacts().equals("")) {//������ϵ�˲�ѯ
				sql = "select * from t_customer where contacts like ? and available=1";
				params = new Object[1];
				params[0] = "%"+c.getContacts()+"%";
			}
		}
		// ִ��sql
		ResultSet rs = sqlManager.executeQuery(sql, params, Constants.PSTM_TYPE);
		// ���������
		if (rs != null) {
			list = new ArrayList<Customer>();
			try {
				while (rs.next()) {
					Customer cus = new Customer();
					cus.setId(rs.getString("id"));
					cus.setCustomerName(rs.getString("customer_name"));
					cus.setShorts(rs.getString("shorts"));
					cus.setAddress(rs.getString("address"));
					cus.setZip(rs.getString("zip"));
					cus.setTelephone(rs.getString("telephone"));
					cus.setFax(rs.getString("fax"));
					cus.setContacts(rs.getString("contacts"));
					cus.setPhone(rs.getString("contacts_tel"));
					cus.setBank(rs.getString("bank"));
					cus.setAccount(rs.getString("account"));
					cus.setMail(rs.getString("mail"));
					list.add(cus);
				}
			} catch (SQLException e) {
				ErrorManager.printError("CustomerDao findCustomers()", e);
			}
		}
		return list;
	}

	
	/**
	 * ���ݿͻ�����޸Ŀͻ���Ϣ
	 * 
	 * @param customer
	 * @return
	 */
	@Override
	public boolean update(Customer customer) {
	    //sql����д
			String sql ="update t_customer set customer_name=?,shorts=?,address=?," + 
					"zip=?,telephone=?,fax=?,contacts=?,contacts_tel=?," + 
					"bank=?,account=?,mail=? where id=?";
			//��װ����
			Object[] params = new Object[] {customer.getCustomerName(),customer.getShorts(),customer.getAddress(),
					customer.getZip(),customer.getTelephone(),customer.getFax(),customer.getContacts(),customer.getPhone(),
					customer.getBank(),customer.getAccount(),customer.getMail(),customer.getId()};
			//ִ��sql
			return sqlManager.executeUpdate(sql, params, Constants.PSTM_TYPE);
	}

	
	/**
	 * ���ݿͻ�����޸�available
	 * @param id���ͻ����
	 * @param available��0:��ʾɾ����1��ʾ�һ�
	 * @return
	 */
	@Override
	
public boolean update(String id, Integer available) {

		//sql����д
		String sql="update t_customer set available=? where id=?";
		//��װ����
		Object[] params = new Object[] {available!=null?available:1,id};
		//ִ��sql
		return sqlManager.executeUpdate(sql, params, Constants.PSTM_TYPE);
	}

}
	
	

