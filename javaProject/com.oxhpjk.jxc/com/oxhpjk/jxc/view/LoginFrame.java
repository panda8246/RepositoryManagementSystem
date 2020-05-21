package com.oxhpjk.jxc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import com.oxhpjk.jxc.common.Factory;
import com.oxhpjk.jxc.modle.User;
import com.oxhpjk.jxc.service.UserServive;


import javax.swing.UIManager;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/image/jinxiaocun.login.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("登录");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("企业进销存管理系统");
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/login.png")));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(51, 153, 255));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(UIManager.getColor("Button.background"));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
					.addGap(26))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(81)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
							.addGap(69))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/pass.png")));
		btnNewButton.setForeground(new Color(0, 51, 255));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String account = textField.getText().intern();
				String password = textField_1.getText();
				
				
				if(account.length()==0) {
					JOptionPane.showMessageDialog(null, "用户名不能为空","警告",JOptionPane.WARNING_MESSAGE);
				}else if(password.trim().length()==0) {
					JOptionPane.showMessageDialog(null, "密码不能为空","警告",JOptionPane.WARNING_MESSAGE);
				}else {
					UserServive userservive = Factory.getUserServive();
					boolean isPass = userservive.login(new User(account,password));
					if(isPass) {
//						MainFrame.username = usernameStr;
//						MainFrame.operator = service.getOperator(usernameStr);
						MainFrame.getMainFrame().setVisible(true);//跳转主界面
						setVisible(false);//隐藏当前界面
					}else {
						JOptionPane.showMessageDialog(null, "登录失败，用户名或者密码错误！","警告",JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
		});
		
		
		
		
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/cancel.png")));
		btnNewButton_1.setForeground(new Color(0, 51, 255));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(22, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("密码：");
		lblNewLabel_1.setForeground(new Color(0, 153, 255));
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/password.png")));
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(255, 255, 255));
		panel_1.add(textField_1);
		textField_1.setColumns(15);
		
		JLabel lblN = new JLabel("账号：");
		lblN.setBackground(new Color(0, 153, 255));
		lblN.setFont(new Font("宋体", Font.BOLD, 15));
		lblN.setForeground(new Color(0, 153, 255));
		lblN.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/user.png")));
		panel.add(lblN);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setForeground(new Color(255, 255, 255));
		panel.add(textField);
		textField.setColumns(15);
		contentPane.setLayout(gl_contentPane);
	}

}
