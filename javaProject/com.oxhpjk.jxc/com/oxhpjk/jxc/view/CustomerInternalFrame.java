package com.oxhpjk.jxc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
/**
 * 客户信息管理界面
 */
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.oxhpjk.jxc.commom.ValidationManager;

import javafx.collections.ListChangeListener.Change;

public class CustomerInternalFrame extends JInternalFrame {

	/**
	 * 初始化视图
	 */
	public CustomerInternalFrame() {
		setTitle("客户信息管理");
		setIconifiable(true);//支持窗口最小化显示
		setClosable(true);//支持窗口可关闭
		getContentPane().setLayout(new BorderLayout(0, 0));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/12,screenSize.height/20,screenSize.width/2,screenSize.height/2);
        //创建选项卡
		JTabbedPane tabPane = new JTabbedPane();
		final CustormerAddpanel addPanel = new CustormerAddpanel();//客户信息添加面板
		final CustomerEditPanel editPanel = new CustomerEditPanel();//客户信息编辑面板
		//向选项卡添加面板
		tabPane.addTab("客户信息添加",null,addPanel,"客户信息添加");
		addPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		tabPane.addTab("客户信息编辑", null,editPanel,"客户信息编辑");
		//向Frame窗口添加选项卡
		getContentPane().add(tabPane);
		//给选项卡设置改变监听
		tabPane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
			    //初始化 编辑界面的下拉列表框
				editPanel.initComboBox();
			}
		});
		//pack();//通过内部组件自动设置窗口大小
		setVisible(true);//显示窗口
	}
	/**
	 * 数据格式校验
	 */
	public static void dataCheck(String name,String address,String shorts,String zip,
			String tel,String fax,String contacts,String phone,String email,String bank,String account) {
		if(name.equals("")||
				address.equals("")||
				shorts.equals("")||
				zip.equals("")||
				tel.equals("")||
				fax.equals("")||
				contacts.equals("")||
			    phone.equals("")||
				email.equals("")||
				bank.equals("")||
				account.equals("")) {
			JOptionPane.showMessageDialog(null, "请填写全部信息！","温馨提示",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(!ValidationManager.validateZip(zip)) {
			JOptionPane.showMessageDialog(null, "邮政编码不合法！","警告",JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(!ValidationManager.validatePhone(phone)) {
			JOptionPane.showMessageDialog(null, "手机号码不合法！","警告",JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(!ValidationManager.validateEmail(email)) {
			JOptionPane.showMessageDialog(null, "电子邮件格式不合法！","警告",JOptionPane.WARNING_MESSAGE);
			return;
		}
	}
	

}
