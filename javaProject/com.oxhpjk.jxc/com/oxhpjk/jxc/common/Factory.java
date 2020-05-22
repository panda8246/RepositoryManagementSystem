package com.oxhpjk.jxc.common;
/**
 * ����ģʽ�����ݷ��䴴����
 * @author pjk
 *
 */

import com.oxhpjk.jxc.service.ClientService;
import com.oxhpjk.jxc.service.UserServive;

public class Factory {
	
	/**
	 * ����ģʽ
	 */
	private static Factory instance;
	public static Factory getInstance() {
		if(instance == null) {
			instance = new Factory();
		}
		return instance;
	}
	
	
	/**
	 * 	����UserServiceʵ��
	 * @return
	 */
	public static UserServive getUserServive() {
		try {
			return (UserServive) Class.forName(Constants.USER_SERVICE_CLASS).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 *  ȡ��ClientServiceʵ��
	 * @return
	 */
	public static ClientService getClientService() {
		try {
			return (ClientService)Class.forName(Constants.CLIENT_SERVICE_CLASS).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
