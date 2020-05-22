package com.oxhpjk.jxc.common;
/**
 * 工厂模式，根据反射创建类
 * @author pjk
 *
 */

import com.oxhpjk.jxc.service.ClientService;
import com.oxhpjk.jxc.service.UserServive;

public class Factory {
	
	/**
	 * 单例模式
	 */
	private static Factory instance;
	public static Factory getInstance() {
		if(instance == null) {
			instance = new Factory();
		}
		return instance;
	}
	
	
	/**
	 * 	创建UserService实例
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
	 *  取得ClientService实例
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
