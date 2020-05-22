package com.oxhpjk.jxc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oxhpjk.jxc.common.Constants;
import com.oxhpjk.jxc.modle.Client;

public class ClientDao {
	
	SqlManager manager;
	
	public ClientDao() {
		manager = SqlManager.getInstance();
		manager.connectDB();
	}
	
	
	/**
	 * 返回所有客户信息
	 * @return
	 */
	public List<Client> getAllClient() {
		String sql = "select * from t_client";
		ResultSet res = manager.excuteQuery(sql, null, Constants.PSTM_TYPE);
		List<Client> list = new ArrayList<Client>();
		try {
			if(res != null) {
				while(res.next()) {
					Client client = new Client();
					client.setId(res.getString("id"));
					client.setName(res.getString("name"));
					client.setAddress(res.getString("address"));
					client.setZip(res.getString("zip"));
					client.setEmail(res.getString("email"));
					client.setPhone_number(res.getString("phone_number"));
					client.setContact(res.getString("contact"));
					client.setContact_phone_number(res.getString("contact_phone_number"));
					client.setBank(res.getString("bank"));
					client.setBank_account(res.getString("bank_account"));
					client.setRemark(Integer.parseInt(res.getString("remark")));
					list.add(client);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	/**
	 * 	全模糊查询客户 
	 * @param client
	 * @return
	 */
	public List<Client> findClients(Client client){
		List<Client> list = new ArrayList<Client>();
		String sql = "select * from t_client where id like ? and name like ? and address like ? and zip like ? and email like ? and phone_number like ? and contact like ? and contact_phone_number like ? and bank like ? and bank_account like ? ";

		String[] _p = new String[10];
		_p[0] = "%" + client.getId() + "%";
		_p[1] = "%" + client.getName() + "%";
		_p[2] = "%" + client.getAddress() + "%";
		_p[3] = "%" + client.getZip() + "%";
		_p[4] = "%" + client.getEmail() + "%";
		_p[5] = "%" + client.getPhone_number() + "%";
		_p[6] = "%" + client.getContact() + "%";
		_p[7] = "%" + client.getContact_phone_number() + "%";
		_p[8] = "%" + client.getBank() + "%";
		_p[9] = "%" + client.getBank_account() + "%";
		Object[] parms = new Object[] {_p[0],_p[1],_p[2],_p[3],_p[4],_p[5],_p[6],_p[7],_p[8],_p[9]};
		SqlManager sqlManager = SqlManager.getInstance();
		ResultSet res = sqlManager.excuteQuery(sql, parms, Constants.PSTM_TYPE);
		try {
			if(res != null) {
				while(res.next()) {
					Client _client = new Client();
					_client.setId(res.getString("id"));
					_client.setName(res.getString("name"));
					_client.setAddress(res.getString("address"));
					_client.setZip(res.getString("zip"));
					_client.setEmail(res.getString("email"));
					_client.setPhone_number(res.getString("phone_number"));
					_client.setContact(res.getString("contact"));
					_client.setContact_phone_number(res.getString("contact_phone_number"));
					_client.setBank(res.getString("bank"));
					_client.setBank_account(res.getString("bank_account"));
					_client.setRemark(Integer.parseInt(res.getString("remark")));
					list.add(_client);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
