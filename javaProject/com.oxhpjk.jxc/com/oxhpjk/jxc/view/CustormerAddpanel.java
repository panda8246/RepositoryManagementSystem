package com.oxhpjk.jxc.view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.oxhpjk.jxc.commom.CommonFactory;
import com.oxhpjk.jxc.commom.ValidationManager;
import com.oxhpjk.jxc.model.Customer;
import com.oxhpjk.jxc.service.CustomerService;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
/**
 * 客户信息添加面板
 * @author 22161
 *
 */
public class CustormerAddpanel extends JPanel implements ActionListener {
	private JTextField customerNameTf;
	private JTextField addressTf;
	private JTextField shortsTf;
	private JTextField zipTf;
	private JTextField telTf;
	private JTextField faxTf;
	private JTextField contactsTf;
	private JTextField phoneTf;
	private JTextField emailTf;
	private JTextField bankTf;
	private JTextField accountTf;
    private CustomerService customerService =  null;
	/**
	 * Create the panel.
	 */
	public CustormerAddpanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel = new JPanel();
		add(panel);

		JLabel lblNewLabel = new JLabel("客户全称：");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 15));
		lblNewLabel.setForeground(new Color(0, 153, 255));
		panel.add(lblNewLabel);

		customerNameTf = new JTextField();
		panel.add(customerNameTf);
		customerNameTf.setColumns(25);

		JLabel label_9 = new JLabel("");
		add(label_9);

		JLabel label = new JLabel("");
		add(label);

		JPanel panel_1 = new JPanel();
		add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("客户地址：");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(0, 153, 255));
		panel_1.add(lblNewLabel_1);

		addressTf = new JTextField();
		panel_1.add(addressTf);
		addressTf.setColumns(30);

		JLabel label_10 = new JLabel("");
		add(label_10);

		JLabel label_11 = new JLabel("");
		add(label_11);

		JLabel label_12 = new JLabel("");
		add(label_12);

		JLabel label_13 = new JLabel("");
		add(label_13);

		JLabel label_14 = new JLabel("");
		add(label_14);

		JLabel label_15 = new JLabel("");
		add(label_15);

		JPanel panel_2 = new JPanel();
		add(panel_2);

		JLabel lblNewLabel_2 = new JLabel("客户简称：");
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(0, 153, 255));
		panel_2.add(lblNewLabel_2);

		shortsTf = new JTextField();
		panel_2.add(shortsTf);
		shortsTf.setColumns(25);

		JLabel label_16 = new JLabel("");
		add(label_16);

		JLabel label_1 = new JLabel("");
		add(label_1);

		JPanel panel_3 = new JPanel();
		add(panel_3);

		JLabel lblNewLabel_3 = new JLabel("客户邮编：");
		lblNewLabel_3.setFont(new Font("楷体", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(new Color(0, 153, 255));
		panel_3.add(lblNewLabel_3);

		zipTf = new JTextField();
		panel_3.add(zipTf);
		zipTf.setColumns(30);

		JLabel label_17 = new JLabel("");
		add(label_17);

		JLabel label_18 = new JLabel("");
		add(label_18);

		JLabel label_19 = new JLabel("");
		add(label_19);

		JLabel label_20 = new JLabel("");
		add(label_20);

		JLabel label_21 = new JLabel("");
		add(label_21);

		JLabel label_22 = new JLabel("");
		add(label_22);

		JPanel panel_4 = new JPanel();
		add(panel_4);

		JLabel lblNewLabel_4 = new JLabel("客户电话：");
		lblNewLabel_4.setFont(new Font("楷体", Font.PLAIN, 15));
		lblNewLabel_4.setForeground(new Color(0, 153, 255));
		panel_4.add(lblNewLabel_4);

		telTf = new JTextField();
		panel_4.add(telTf);
		telTf.setColumns(25);

		JPanel panel_5 = new JPanel();
		add(panel_5);

		JLabel lblNewLabel_5 = new JLabel("传    真：");
		lblNewLabel_5.setForeground(new Color(0, 153, 255));
		lblNewLabel_5.setFont(new Font("楷体", Font.PLAIN, 15));
		panel_5.add(lblNewLabel_5);

		faxTf = new JTextField();
		panel_5.add(faxTf);
		faxTf.setColumns(30);

		JLabel label_23 = new JLabel("");
		add(label_23);

		JLabel label_24 = new JLabel("");
		add(label_24);

		JLabel label_25 = new JLabel("");
		add(label_25);

		JLabel label_26 = new JLabel("");
		add(label_26);

		JLabel label_27 = new JLabel("");
		add(label_27);

		JLabel label_28 = new JLabel("");
		add(label_28);

		JLabel label_2 = new JLabel("");
		add(label_2);

		JLabel label_29 = new JLabel("");
		add(label_29);

		JPanel panel_6 = new JPanel();
		add(panel_6);

		JLabel lblNewLabel_6 = new JLabel("联 系 人：");
		lblNewLabel_6.setForeground(new Color(0, 153, 255));
		lblNewLabel_6.setFont(new Font("楷体", Font.PLAIN, 15));
		panel_6.add(lblNewLabel_6);

		contactsTf = new JTextField();
		panel_6.add(contactsTf);
		contactsTf.setColumns(25);

		JLabel label_30 = new JLabel("");
		add(label_30);

		JLabel label_3 = new JLabel("");
		add(label_3);

		JPanel panel_7 = new JPanel();
		add(panel_7);

		JLabel lblNewLabel_7 = new JLabel("联系电话：");
		lblNewLabel_7.setForeground(new Color(0, 153, 255));
		lblNewLabel_7.setFont(new Font("楷体", Font.PLAIN, 15));
		panel_7.add(lblNewLabel_7);

		phoneTf = new JTextField();
		panel_7.add(phoneTf);
		phoneTf.setColumns(30);

		JLabel label_31 = new JLabel("");
		add(label_31);

		JLabel label_32 = new JLabel("");
		add(label_32);

		JLabel label_33 = new JLabel("");
		add(label_33);

		JLabel label_34 = new JLabel("");
		add(label_34);

		JLabel label_35 = new JLabel("");
		add(label_35);

		JLabel label_36 = new JLabel("");
		add(label_36);

		JPanel panel_8 = new JPanel();
		add(panel_8);

		JLabel lblNewLabel_8 = new JLabel("客户邮箱：");
		lblNewLabel_8.setForeground(new Color(0, 153, 255));
		lblNewLabel_8.setFont(new Font("楷体", Font.PLAIN, 15));
		panel_8.add(lblNewLabel_8);

		emailTf = new JTextField();
		panel_8.add(emailTf);
		emailTf.setColumns(64);

		JLabel label_37 = new JLabel("");
		add(label_37);

		JLabel label_38 = new JLabel("");
		add(label_38);

		JLabel label_39 = new JLabel("");
		add(label_39);

		JLabel label_40 = new JLabel("");
		add(label_40);

		JLabel label_41 = new JLabel("");
		add(label_41);

		JLabel label_42 = new JLabel("");
		add(label_42);

		JLabel label_4 = new JLabel("");
		add(label_4);

		JLabel label_43 = new JLabel("");
		add(label_43);

		JLabel label_5 = new JLabel("");
		add(label_5);

		JPanel panel_9 = new JPanel();
		add(panel_9);

		JPanel panel_10 = new JPanel();
		panel_9.add(panel_10);

		JLabel lblNewLabel_9 = new JLabel("开户银行：");
		lblNewLabel_9.setForeground(new Color(0, 153, 255));
		lblNewLabel_9.setFont(new Font("楷体", Font.PLAIN, 15));
		panel_10.add(lblNewLabel_9);

		bankTf = new JTextField();
		panel_10.add(bankTf);
		bankTf.setColumns(25);

		JLabel label_44 = new JLabel("");
		add(label_44);

		JLabel label_45 = new JLabel("");
		add(label_45);

		JLabel label_6 = new JLabel("");
		add(label_6);

		JPanel panel_11 = new JPanel();
		add(panel_11);

		JLabel lblNewLabel_10 = new JLabel("银行账户：");
		lblNewLabel_10.setForeground(new Color(0, 153, 255));
		lblNewLabel_10.setFont(new Font("楷体", Font.PLAIN, 15));
		panel_11.add(lblNewLabel_10);

		accountTf = new JTextField();
		panel_11.add(accountTf);
		accountTf.setColumns(30);

		JLabel label_46 = new JLabel("");
		add(label_46);

		JLabel label_47 = new JLabel("");
		add(label_47);

		JLabel label_48 = new JLabel("");
		add(label_48);

		JLabel label_49 = new JLabel("");
		add(label_49);

		JLabel label_50 = new JLabel("");
		add(label_50);

		JPanel panel_12 = new JPanel();
		add(panel_12);

		JButton saveBtn = new JButton("保存");
		saveBtn.setFont(new Font("楷体", Font.PLAIN, 15));
		saveBtn.addActionListener(this);
		panel_12.add(saveBtn);

		JButton resetBtn = new JButton("重置");
		resetBtn.setFont(new Font("楷体", Font.PLAIN, 15));
		resetBtn.addActionListener(this);
		panel_12.add(resetBtn);

		JLabel label_51 = new JLabel("");
		add(label_51);

		JLabel label_52 = new JLabel("");
		add(label_52);

		JLabel label_53 = new JLabel("");
		add(label_53);

		JLabel label_54 = new JLabel("");
		add(label_54);

		JLabel label_7 = new JLabel("");
		add(label_7);

		JLabel label_8 = new JLabel("");
		add(label_8);

		JLabel label_55 = new JLabel("");
		add(label_55);

		JLabel label_56 = new JLabel("");
		add(label_56);

		JLabel label_57 = new JLabel("");
		add(label_57);
        //初始化service
		customerService = CommonFactory.getCustomerService();
	}
    /**
     * 监听点击事件
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		String target = e.getActionCommand();
		switch (target) {
		case "保存":
			//格式校验
			CustomerInternalFrame.dataCheck(customerNameTf.getText().trim(),
					addressTf.getText().trim(),
					shortsTf.getText().trim(),
					zipTf.getText().trim(),
					telTf.getText().trim(),
					faxTf.getText().trim(),
					contactsTf.getText().trim(),
					phoneTf.getText().trim(),
					emailTf.getText().trim(),
					bankTf.getText().trim(),
					accountTf.getText().trim());
			//获取客户编号
			String id = customerService.getCustomerId();
			//将客户信息添加到数据库
			Customer customer = new Customer(id, customerNameTf.getText().trim(), 
					shortsTf.getText().trim(), addressTf.getText().trim(), 
					zipTf.getText().trim(), telTf.getText().trim(), 
					faxTf.getText().trim(), contactsTf.getText().trim(), 
					phoneTf.getText().trim(), bankTf.getText().trim(), 
					accountTf.getText().trim(), emailTf.getText().trim(), 1);
			boolean result = customerService.addCustomer(customer);
			if(result==true) {
				JOptionPane.showMessageDialog(null, "客户信息添加成功！","提示",JOptionPane.INFORMATION_MESSAGE);
				setNull();
			}else {
				JOptionPane.showMessageDialog(null, "客户信息添加失败！","警告",JOptionPane.WARNING_MESSAGE);			
			}
			break;
		case "重置":
			setNull();
			break;
		default:
			break;
		}

	}
	
	/**
	 * 清空文本框中的值
	 */
	private void setNull() {
		customerNameTf.setText("");
		shortsTf.setText("");
		addressTf.setText("");
		zipTf.setText("");
		telTf.setText("");
		faxTf.setText("");
		contactsTf.setText("");
		phoneTf.setText("");
		bankTf.setText("");
		accountTf.setText("");
		emailTf.setText("");
	}
	
}

