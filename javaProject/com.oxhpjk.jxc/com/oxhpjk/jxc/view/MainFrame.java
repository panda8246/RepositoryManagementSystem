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
	 * 	单例模式
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
		setTitle("企业进销存管理系统");//标题
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//标题的开关 
		//获取屏幕尺寸信息
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/6, screenSize.height/6, screenSize.width*2/3, screenSize.height*2/3);//设置窗体大小
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("基础信息管理");
		mnNewMenu.setForeground(new Color(0, 153, 255));
		mnNewMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/image/Basic information management.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_6 = new JMenu("供应商管理");
		mnNewMenu_6.setForeground(new Color(102, 0, 0));
		mnNewMenu_6.setBackground(new Color(255, 255, 255));
		mnNewMenu.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("商品管理");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("客户信息管理");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("销售管理");
		mnNewMenu_1.setForeground(new Color(0, 153, 255));
		mnNewMenu_1.setIcon(new ImageIcon(MainFrame.class.getResource("/image/sales management;.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("销售清单");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("退货清单");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("库存管理");
		mnNewMenu_2.setForeground(new Color(0, 153, 255));
		mnNewMenu_2.setIcon(new ImageIcon(MainFrame.class.getResource("/image/Inventory.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("库存盘点");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("价格调整");
		mnNewMenu_2.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu_3 = new JMenu("进货管理");
		mnNewMenu_3.setForeground(new Color(0, 153, 255));
		mnNewMenu_3.setIcon(new ImageIcon(MainFrame.class.getResource("/image/purchase management.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("进货单");
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("进货退货");
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_4 = new JMenu("查询统计");
		mnNewMenu_4.setForeground(new Color(0, 153, 255));
		mnNewMenu_4.setIcon(new ImageIcon(MainFrame.class.getResource("/image/query statistics.png")));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("客户查询");
		mnNewMenu_4.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("商品查询");
		mnNewMenu_4.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("供应商查询");
		mnNewMenu_4.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("销售查询");
		mnNewMenu_4.add(mntmNewMenuItem_13);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("销售退货查询");
		mnNewMenu_4.add(mntmNewMenuItem_14);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("入库查询");
		mnNewMenu_4.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("入库退货查询");
		mnNewMenu_4.add(mntmNewMenuItem_16);
		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("销售排行");
		mnNewMenu_4.add(mntmNewMenuItem_17);
		
		JMenu mnNewMenu_5 = new JMenu("系统管理");
		mnNewMenu_5.setForeground(new Color(0, 153, 255));
		mnNewMenu_5.setIcon(new ImageIcon(MainFrame.class.getResource("/image/system management.png")));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("操作员管理");
		mnNewMenu_5.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("更改密码");
		mnNewMenu_5.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("权限管理");
		mnNewMenu_5.add(mntmNewMenuItem_18);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(desktopPane);
		
		JLabel lblNewLabel = new JLabel("欢迎来到企业进销存管理系统");
		lblNewLabel.setForeground(new Color(0, 153, 255));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
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
