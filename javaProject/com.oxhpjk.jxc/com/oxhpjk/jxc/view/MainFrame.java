package com.oxhpjk.jxc.view;

import static org.junit.Assert.assertNotNull;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.oxhpjk.jxc.model.Operator;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame {
	private static MainFrame mainFrame=null;
	//public static String username=null;
    private static Operator power=null;//保存登录名
    public static Operator operator=null;//保存登录后的数据
	public static String username;
	

	


	
	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * 初始化
	 * @return
	 */
	public static MainFrame getMainFrame() {
		if(mainFrame==null) {
			mainFrame=new MainFrame();
		}
		return mainFrame; 
	}
    
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setBackground(new Color(0, 153, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/com/oxhpjk/jxc/image/jinxiaocun.login.png")));
		setTitle("企业进销存管理系统");//标题
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//标题上的开关按钮
		//锁定视窗
		setResizable(false);
		//获取屏幕的尺寸信息
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/6, screenSize.height/6, screenSize.width*2/3, screenSize.height*2/3);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("基础信息管理");
		menu.setIcon(new ImageIcon(MainFrame.class.getResource("/com/oxhpjk/jxc/image/Basic information management.png")));
		menu.setForeground(new Color(0, 153, 255));
		menuBar.add(menu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("客户信息管理");
		menu.add(mntmNewMenuItem);
		//给客户信息管理设置点击事件
		mntmNewMenuItem.addActionListener(MainAction.clickCustomerInfoManger());
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("商品信息管理"
				+ "");
		menu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(MainAction.clickGoodsInfoManger());
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("供应商信息管理");
		menu.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(MainAction.clickProviderInfoManger());
		
		JMenu mnNewMenu = new JMenu("进货管理");
		mnNewMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/com/oxhpjk/jxc/image/purchase management.png")));
		mnNewMenu.setForeground(new Color(0, 153, 255));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("进货单");
		mnNewMenu.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("进货退货");
		mnNewMenu.add(mntmNewMenuItem_13);
		
		JMenu mnNewMenu_1 = new JMenu("销售管理");
		mnNewMenu_1.setIcon(new ImageIcon(MainFrame.class.getResource("/com/oxhpjk/jxc/image/sales management;.png")));
		mnNewMenu_1.setForeground(new Color(0, 153, 255));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("销售单管理");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("销售退货");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("查询统计");
		mnNewMenu_2.setIcon(new ImageIcon(MainFrame.class.getResource("/com/oxhpjk/jxc/image/query statistics.png")));
		mnNewMenu_2.setForeground(new Color(0, 153, 255));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("客户查询");
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("供应商查询");
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("商品查询");
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("销售查询");
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("销售退货查询");
		mnNewMenu_2.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("入库查询");
		mnNewMenu_2.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("入库退货查询");
		mnNewMenu_2.add(mntmNewMenuItem_11);
		
		JMenu mnNewMenu_3 = new JMenu("库存管理");
		mnNewMenu_3.setIcon(new ImageIcon(MainFrame.class.getResource("/com/oxhpjk/jxc/image/Inventory.png")));
		mnNewMenu_3.setForeground(new Color(0, 153, 255));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("库存盘点");
		mnNewMenu_3.add(mntmNewMenuItem_14);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("价格调整");
		mnNewMenu_3.add(mntmNewMenuItem_15);
		
		JMenu mnNewMenu_4 = new JMenu("系统管理");
		mnNewMenu_4.setForeground(new Color(0, 153, 255));
		mnNewMenu_4.setIcon(new ImageIcon(MainFrame.class.getResource("/com/oxhpjk/jxc/image/system management.png")));
		menuBar.add(mnNewMenu_4);
		//权限处理
		if(operator!=null) {
			if(operator.getPower().equals("超级管理员")) {
			JMenuItem mntmNewMenuItem_16 = new JMenuItem("操作员管理");
			mnNewMenu_4.add(mntmNewMenuItem_16);
			
			JMenuItem mntmNewMenuItem_17 = new JMenuItem("权限管理");
			mnNewMenu_4.add(mntmNewMenuItem_17);
			}else if(operator.getPower().equals("普通管理员")) {
				//可以扩展
			}
			else {
				JOptionPane.showMessageDialog(null, "其他用户","不允许",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
			
		}
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("操作员管理");
		mnNewMenu_4.add(mntmNewMenuItem_16);
		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("权限管理");
		mnNewMenu_4.add(mntmNewMenuItem_17);
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("更改密码");
		mnNewMenu_4.add(mntmNewMenuItem_18);
		desktopPane=new JDesktopPane();
		desktopPane.setBackground(new Color(255, 255, 255));
		desktopPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(desktopPane);
		
		JLabel lblNewLabel = new JLabel("企业进销存管理系统");
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/com/oxhpjk/jxc/image/jinxiaocun.login.png")));
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 25));
		lblNewLabel.setForeground(new Color(0, 153, 255));
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(362)
					.addComponent(lblNewLabel)
					.addContainerGap(830, Short.MAX_VALUE))
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(164)
					.addComponent(lblNewLabel)
					.addContainerGap(459, Short.MAX_VALUE))
		);
		desktopPane.setLayout(gl_desktopPane);
		System.out.println("-------------"+operator);
	}

}
