package com.oxhpjk.jxc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.oxhpjk.jxc.commom.ValidationManager;

public class GoodsInterFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public GoodsInterFrame() {
		setTitle("��Ʒ��Ϣ����");
		setIconifiable(true);//֧�ִ�����С����ʾ
		setClosable(true);//֧�ִ��ڿɹر�
		getContentPane().setLayout(new BorderLayout(0, 0));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/12,screenSize.height/20,screenSize.width/2,screenSize.height/2);
        //����ѡ�
		JTabbedPane tabPane = new JTabbedPane();
		final GoodsAddPanel addPanel = new GoodsAddPanel();//�ͻ���Ϣ������
		final GoodsEditPanel editPanel = new GoodsEditPanel();//�ͻ���Ϣ�༭���
		//��ѡ�������
		tabPane.addTab("��Ʒ��Ϣ���",null,addPanel,"��Ʒ��Ϣ���");
		//addPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		tabPane.addTab("��Ʒ��Ϣ�༭", null,editPanel,"��Ʒ��Ϣ�༭");
		//��Frame�������ѡ�
		getContentPane().add(tabPane);
		//��ѡ����øı����
		tabPane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
			    //��ʼ�� �༭����������б��
				//editPanel.initComboBox();
			}
		});
		//pack();//ͨ���ڲ�����Զ����ô��ڴ�С
		setVisible(true);//��ʾ����
		

}
	public static void dataCheck(String name,String shorts,String place,
			String sizes,String packages,String productCode,String pCode,String price,String memo,String provider) {
		if(name.equals("")||
				shorts.equals("")||
				place.equals("")||
				sizes.equals("")||
				packages.equals("")||
				productCode.equals("")||
				pCode.equals("")||
			    price.equals("")||
				memo.equals("")||
				provider.equals("")) {
			JOptionPane.showMessageDialog(null, "����дȫ����Ϣ��","��ܰ��ʾ",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(!ValidationManager.validatePrice(price)) {
			JOptionPane.showMessageDialog(null, "�۸񲻺Ϸ���","����",JOptionPane.WARNING_MESSAGE);
			return;
		}
	}
}
