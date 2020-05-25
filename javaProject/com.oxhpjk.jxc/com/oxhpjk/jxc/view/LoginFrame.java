package com.oxhpjk.jxc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.oxhpjk.jxc.commom.CommonFactory;
import com.oxhpjk.jxc.model.Operator;
import com.oxhpjk.jxc.service.OperatorService;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame implements ActionListener{
	private JTextField username;
	private JPasswordField password;
	private JButton submit;
	private JButton cancel;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;



	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/com/oxhpjk/jxc/image/jinxiaocun.login.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("��ҵ���������ϵͳ");
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/oxhpjk/jxc/image/login.png")));
		lblNewLabel.setFont(new Font("����", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.ORANGE);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(86)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(63)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
		);
		
		 submit = new JButton("��¼");
		 submit.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/oxhpjk/jxc/image/pass.png")));
		 submit.setForeground(new Color(0, 153, 255));
			submit.addActionListener(this);//�󶨵���¼�
		
			cancel = new JButton("ȡ��");
			cancel.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/oxhpjk/jxc/image/cancel.png")));
			cancel.setForeground(new Color(0, 153, 255));
			cancel.addActionListener(this);//�󶨵���¼�
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(submit)
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addComponent(cancel)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(submit)
						.addComponent(cancel))
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel label_1 = new JLabel("����");
		label_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/oxhpjk/jxc/image/password.png")));
		label_1.setForeground(new Color(0, 153, 255));
		panel_1.add(label_1);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(20);
		
		JLabel label = new JLabel("�˺�");
		label.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/oxhpjk/jxc/image/user.png")));
		label.setForeground(new Color(0, 153, 255));
		panel.add(label);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(20);
		contentPane.setLayout(gl_contentPane);
	}
	/**
	 * ����¼�
	 */
	public  void actionPerformed(ActionEvent e) {
		String btnCode= e.getActionCommand();//��ȡ�����ǰ�ť�ϵ�����
		switch(btnCode) {
		case"��¼":
			String usernameString=textField.getText().trim();
			String passwordStr=String.valueOf(textField_1.getText());
			if(usernameString.length()==0) {
				JOptionPane.showMessageDialog(null, "�û�����Ϊ��","����",JOptionPane.WARNING_MESSAGE);

			}
			else if(passwordStr.trim().length()==0){
				JOptionPane.showMessageDialog(null, "���벻Ϊ��","����",JOptionPane.WARNING_MESSAGE);

			}
			else {
				OperatorService service=CommonFactory.getOperatorService();
				boolean isPass=service.loginCheck(new Operator(usernameString,passwordStr));
				if (isPass) {
					MainFrame.username=usernameString;
					MainFrame.operator=service.getOperator(usernameString);
					//JOptionPane.showMessageDialog(null, "��¼�ɹ�","����",JOptionPane.INFORMATION_MESSAGE);
                    MainFrame.getMainFrame().setVisible(true);//��ת������
                    this.setVisible(false);//���ص�ǰ����
				}
				else {
					JOptionPane.showMessageDialog(null,  "��¼ʧ�ܣ��û��������������","����",JOptionPane.WARNING_MESSAGE);

				}
			}
			break;
        case"ȡ��":
        	System.exit(0);
        	break;
        default:
        	break;
		}
	}
}
