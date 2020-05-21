package com.oxhpjk.jxc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame.JDesktopIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	
	
	/**
	 * 	����ģʽ
	 */
	private static MainFrame mainFrame;
    public static MainFrame getMainFrame() {
    	if(mainFrame==null) {
    		mainFrame = new MainFrame();
    	}
    	return mainFrame;
    }
	
    public void setVisible(boolean b) {
        super.setVisible(b);
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/image/jinxiaocun.login.png")));
		setTitle("��ҵ���������ϵͳ");//����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����Ŀ��� 
		//��ȡ��Ļ�ߴ���Ϣ
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/6, screenSize.height/6, screenSize.width*2/3, screenSize.height*2/3);//���ô����С
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("������Ϣ����");
		mnNewMenu.setForeground(new Color(0, 153, 255));
		mnNewMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/image/Basic information management.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_6 = new JMenu("��Ӧ�̹���");
		mnNewMenu_6.setForeground(new Color(102, 0, 0));
		mnNewMenu_6.setBackground(new Color(255, 255, 255));
		mnNewMenu.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("��Ʒ����");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("�ͻ���Ϣ����");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("���۹���");
		mnNewMenu_1.setForeground(new Color(0, 153, 255));
		mnNewMenu_1.setIcon(new ImageIcon(MainFrame.class.getResource("/image/sales management;.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("�����嵥");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("�˻��嵥");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("������");
		mnNewMenu_2.setForeground(new Color(0, 153, 255));
		mnNewMenu_2.setIcon(new ImageIcon(MainFrame.class.getResource("/image/Inventory.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("����̵�");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("�۸����");
		mnNewMenu_2.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu_3 = new JMenu("��������");
		mnNewMenu_3.setForeground(new Color(0, 153, 255));
		mnNewMenu_3.setIcon(new ImageIcon(MainFrame.class.getResource("/image/purchase management.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("������");
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("�����˻�");
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_4 = new JMenu("��ѯͳ��");
		mnNewMenu_4.setForeground(new Color(0, 153, 255));
		mnNewMenu_4.setIcon(new ImageIcon(MainFrame.class.getResource("/image/query statistics.png")));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("�ͻ���ѯ");
		mnNewMenu_4.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("��Ʒ��ѯ");
		mnNewMenu_4.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("��Ӧ�̲�ѯ");
		mnNewMenu_4.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("���۲�ѯ");
		mnNewMenu_4.add(mntmNewMenuItem_13);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("�����˻���ѯ");
		mnNewMenu_4.add(mntmNewMenuItem_14);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("����ѯ");
		mnNewMenu_4.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("����˻���ѯ");
		mnNewMenu_4.add(mntmNewMenuItem_16);
		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("��������");
		mnNewMenu_4.add(mntmNewMenuItem_17);
		
		JMenu mnNewMenu_5 = new JMenu("ϵͳ����");
		mnNewMenu_5.setForeground(new Color(0, 153, 255));
		mnNewMenu_5.setIcon(new ImageIcon(MainFrame.class.getResource("/image/system management.png")));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("����Ա����");
		mnNewMenu_5.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("��������");
		mnNewMenu_5.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("Ȩ�޹���");
		mnNewMenu_5.add(mntmNewMenuItem_18);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(desktopPane);
		
		JLabel lblNewLabel = new JLabel("��ӭ������ҵ���������ϵͳ");
		lblNewLabel.setForeground(new Color(0, 153, 255));
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		GroupLayout gl_contentPane = new GroupLayout(desktopPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(466, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
					.addGap(444))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(228)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(364, Short.MAX_VALUE))
		);
		desktopPane.setLayout(gl_contentPane);
	}
}
