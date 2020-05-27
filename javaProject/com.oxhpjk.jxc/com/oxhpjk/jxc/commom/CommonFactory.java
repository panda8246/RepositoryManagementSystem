package com.oxhpjk.jxc.commom;
/**
 * �����࣬��������ҵ����Ķ���
 * @author FPF
 *
 */

import com.oxhpjk.jxc.service.CustomerService;
import com.oxhpjk.jxc.service.GoodsService;
import com.oxhpjk.jxc.service.InportService;
import com.oxhpjk.jxc.service.OperatorService;
import com.oxhpjk.jxc.service.OutportService;
import com.oxhpjk.jxc.service.ProviderService;

public class CommonFactory {
	/**
	 * ��ȡ������ʵ��
	 *������
	 * 
	 */
	public static OperatorService getOperatorService()  {
		try {
			return (OperatorService) Class.forName(Constants.OPERATOR_SERVICE_CLASS).newInstance();
		} catch (Exception e) {
			ErrorManager.printError("CommonFactory getOperatorService", e);
			
		
	}
		return null;
	}
	
		/**
		 * ��ȡ������ʵ��
		 *�ͻ�
		 * 
		 */
		public static CustomerService getCustomerService()  {
			try {
				return (CustomerService) Class.forName(Constants.CUSTOMER_SERVICE_CLASS).newInstance();
			} catch (Exception e) {
				ErrorManager.printError("CommonFactory getCustomerService", e);
				
			
		}
			return null;
		}
		public static ProviderService getProviderService()  {
			try {
				return (ProviderService) Class.forName(Constants.PROVIDER_SERVICE_CLASS).newInstance();
			} catch (Exception e) {
				ErrorManager.printError("CommonFactory getProviderService()", e);
				
			
		}
			return null;
		}
		public static GoodsService getGoodsService()  {
			try {
				return (GoodsService) Class.forName(Constants.GOODS_SERVICE_CLASS).newInstance();
			} catch (Exception e) {
				ErrorManager.printError("CommonFactory getGoodsService()", e);
				
			
		}
			return null;
		}
		
		public static InportService getInportService() {
			try {
				return (InportService) Class.forName(Constants.INPORT_SERVICE_CLASS).newInstance();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null;
		}
		
		public static OutportService getOutportService() {
			try {
				return (OutportService) Class.forName(Constants.OUTPORT_SERVICE_CLASS).newInstance();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null;
		}
}
    
    

