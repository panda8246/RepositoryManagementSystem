package com.oxhpjk.jxc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
/**
 * �ͻ���Ϣ�������
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
	 * ��ʼ����ͼ
	 */
	public CustomerInternalFrame() {
		setTitle("�ͻ���Ϣ����");
		setIconifiable(true);//֧�ִ�����С����ʾ
		setClosable(true);//֧�ִ��ڿɹر�
		getContentPane().setLayout(new BorderLayout(0, 0));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/12,screenSize.height/20,screenSize.width/2,screenSize.height/2);
        //����ѡ�
		JTabbedPane tabPane = new JTabbedPane();
		final CustormerAddpanel addPanel = new CustormerAddpanel();//�ͻ���Ϣ������
		final CustomerEditPanel editPanel = new CustomerEditPanel();//�ͻ���Ϣ�༭���
		//��ѡ�������
		tabPane.addTab("�ͻ���Ϣ���",null,addPanel,"�ͻ���Ϣ���");
		addPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		tabPane.addTab("�ͻ���Ϣ�༭", null,editPanel,"�ͻ���Ϣ�༭");
		//��Frame�������ѡ�
		getContentPane().add(tabPane);
		//��ѡ����øı����
		tabPane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
			    //��ʼ�� �༭����������б��
				editPanel.initComboBox();
			}
		});
		//pack();//ͨ���ڲ�����Զ����ô��ڴ�С
		setVisible(true);//��ʾ����
	}
	/**
	 * ���ݸ�ʽУ��
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
			JOptionPane.showMessageDialog(null, "����дȫ����Ϣ��","��ܰ��ʾ",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(!ValidationManager.validateZip(zip)) {
			JOptionPane.showMessageDialog(null, "�������벻�Ϸ���","����",JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(!ValidationManager.validatePhone(phone)) {
			JOptionPane.showMessageDialog(null, "�ֻ����벻�Ϸ���","����",JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(!ValidationManager.validateEmail(email)) {
			JOptionPane.showMessageDialog(null, "�����ʼ���ʽ���Ϸ���","����",JOptionPane.WARNING_MESSAGE);
			return;
		}
	}
	

}
