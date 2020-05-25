package com.oxhpjk.jxc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAction {
	/**
	 * 跳转到客户管理界面
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
	 * 跳转到供应商管理界面
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
	 * 跳转到商品管理界面
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

