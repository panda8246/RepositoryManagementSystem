package com.oxhpjk.jxc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAction {
	/**
	 * ��ת���ͻ��������
	 * @return
	 */
	public static ActionListener clickCustomerInfoManger() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CustomerInternalFrame customerInternalFrame=new CustomerInternalFrame();
				MainFrame.getMainFrame().getContentPane().add(customerInternalFrame);
				customerInternalFrame.setVisible(true);
			}
		};
	}
	/**
	 * ��ת����Ӧ�̹������
	 * @return
	 */
	public static ActionListener clickProviderInfoManger() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProviderInternalFrame InternalFrame=new ProviderInternalFrame();
				MainFrame.getMainFrame().getContentPane().add(InternalFrame);
				InternalFrame.setVisible(true);
			}
		};
	}
	/**
	 * ��ת����Ʒ�������
	 * @return
	 */
	public static ActionListener clickGoodsInfoManger() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GoodsInterFrame InternalFrame=new GoodsInterFrame();
				MainFrame.getMainFrame().getContentPane().add(InternalFrame);
				InternalFrame.setVisible(true);
			}
		};
	}
}

