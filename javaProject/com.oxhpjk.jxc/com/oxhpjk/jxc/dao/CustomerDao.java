package com.oxhpjk.jxc.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oxhpjk.jxc.commom.Constants;
import com.oxhpjk.jxc.commom.ErrorManager;
import com.oxhpjk.jxc.model.Customer;


/**
 * 操作客户的dao
 * 
 * @author FPF
 *
 */
public class CustomerDao implements BaseDao<Customer>{
	SqlManager sqlManager = null;

	public CustomerDao() {
		sqlManager = SqlManager.createInstance();
		sqlManager.connectDB();// 获取数据库连接
	}

	
	/**
	 * 添加客户信息
	 * 
	 * @param customer
	 * @return
	 */
	@Override
	public boolean save(Customer customer) {
		// 编写sql语句
				String sql = "insert into t_customer values(?,?,?,?,?,?,?,?,?,?,?,?,1)";
				// 封装参数
				Object[] params = new Object[] { customer.getId(), customer.getCustomerName(), customer.getShorts(),
						customer.getAddress(), customer.getZip(), customer.getTelephone(), customer.getFax(),
						customer.getContacts(), customer.getPhone(), customer.getBank(), customer.getAccount(),
						customer.getMail() };
				// 执行sql
				return sqlManager.executeUpdate(sql, params, Constants.PSTM_TYPE);
			}
	
	
	/**
	 * 生成客户编号
	 * 
	 * @return
	 */

	@Override
	public String getId() {
		// 获取最新的id
		String sql = "select MAX(id) id from t_customer";
		// 执行sql
		ResultSet rs = sqlManager.executeQuery(sql, null, Constants.PSTM_TYPE);
		String id = "c1";
		try {
			if (rs != null && rs.next()) {
				String sid = rs.getString("id");// 获取前一次插入的id
				if (sid != null) {
					String str = sid.substring(1);// 截取编号中的数字
					id = "c" + (Integer.parseInt(str) + 1);
				}
			}
		} catch (SQLException e) {
			ErrorManager.printError("CustomerDao getCustomerId()", e);
		}
		return id;
	}


	
	/**
	 * 查询客户信息
	 * 
	 * @return
	 */
	@Override
	
public List<Customer> query(Customer c) {
		List<Customer> list = null;
		String sql = null;
		Object[] params = null;
		if (c == null) {// 没有参数
			// 编写sql
			sql = "select * from t_customer where available=1";
		} else {// 有参数，等待以后扩展
			//根据客户ID查询
			if (c.getId() != null && !c.getId().equals("")) {
				sql = "select * from t_customer where id=? and available=1";
				params = new Object[1];
				params[0] = c.getId();
			}else if(c.getCustomerName()!=null && !c.getCustomerName().equals("")) {//根据客户全称查询
				sql = "select * from t_customer where customer_name like ? and available=1";
				params = new Object[1];
				params[0] = "%"+c.getCustomerName()+"%";
			}else if(c.getShorts()!=null && !c.getShorts().equals("")) {//根据客户简称查询
				sql = "select * from t_customer where shorts like ? and available=1";
				params = new Object[1];
				params[0] = "%"+c.getShorts()+"%";
			}else if(c.getContacts()!=null && !c.getContacts().equals("")) {//根据联系人查询
				sql = "select * from t_customer where contacts like ? and available=1";
				params = new Object[1];
				params[0] = "%"+c.getContacts()+"%";
			}
		}
		// 执行sql
		ResultSet rs = sqlManager.executeQuery(sql, params, Constants.PSTM_TYPE);
		// 解析结果集
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
	 * 根据客户编号修改客户信息
	 * 
	 * @param customer
	 * @return
	 */
	@Override
	public boolean update(Customer customer) {
	    //sql语句编写
			String sql ="update t_customer set customer_name=?,shorts=?,address=?," + 
					"zip=?,telephone=?,fax=?,contacts=?,contacts_tel=?," + 
					"bank=?,account=?,mail=? where id=?";
			//封装参数
			Object[] params = new Object[] {customer.getCustomerName(),customer.getShorts(),customer.getAddress(),
					customer.getZip(),customer.getTelephone(),customer.getFax(),customer.getContacts(),customer.getPhone(),
					customer.getBank(),customer.getAccount(),customer.getMail(),customer.getId()};
			//执行sql
			return sqlManager.executeUpdate(sql, params, Constants.PSTM_TYPE);
	}

	
	/**
	 * 根据客户编号修改available
	 * @param id：客户编号
	 * @param available：0:表示删除，1表示找回
	 * @return
	 */
	@Override
	
public boolean update(String id, Integer available) {

		//sql语句编写
		String sql="update t_customer set available=? where id=?";
		//封装参数
		Object[] params = new Object[] {available!=null?available:1,id};
		//执行sql
		return sqlManager.executeUpdate(sql, params, Constants.PSTM_TYPE);
	}

}
	
	

