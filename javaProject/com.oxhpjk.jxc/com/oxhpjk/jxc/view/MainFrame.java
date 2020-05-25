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
    private static Operator power=null;//�����¼��
    public static Operator operator=null;//�����¼�������
	public static String username;
	

	


	
	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * ��ʼ��
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
		setTitle("��ҵ���������ϵͳ");//����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ϵĿ��ذ�ť
		//�����Ӵ�
		setResizable(false);
		//��ȡ��Ļ�ĳߴ���Ϣ
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/6, screenSize.height/6, screenSize.width*2/3, screenSize.height*2/3);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("������Ϣ����");
		menu.setIcon(new ImageIcon(MainFrame.class.getResource("/com/oxhpjk/jxc/image/Basic information management.png")));
		menu.setForeground(new Color(0, 153, 255));
		menuBar.add(menu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("�ͻ���Ϣ����");
		menu.add(mntmNewMenuItem);
		//���ͻ���Ϣ�������õ���¼�
		mntmNewMenuItem.addActionListener(MainAction.clickCustomerInfoManger());
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("��Ʒ��Ϣ����"
				+ "");
		menu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(MainAction.clickGoodsInfoManger());
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("��Ӧ����Ϣ����");
		menu.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(MainAction.clickProviderInfoManger());
		
		JMenu mnNewMenu = new JMenu("��������");
		mnNewMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/com/oxhpjk/jxc/image/purchase management.png")));
		mnNewMenu.setForeground(new Color(0, 153, 255));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("������");
		mnNewMenu.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("�����˻�");
		mnNewMenu.add(mntmNewMenuItem_13);
		
		JMenu mnNewMenu_1 = new JMenu("���۹���");
		mnNewMenu_1.setIcon(new ImageIcon(MainFrame.class.getResource("/com/oxhpjk/jxc/image/sales management;.png")));
		mnNewMenu_1.setForeground(new Color(0, 153, 255));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("���۵�����");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("�����˻�");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("��ѯͳ��");
		mnNewMenu_2.setIcon(new ImageIcon(MainFrame.class.getResource("/com/oxhpjk/jxc/image/query statistics.png")));
		mnNewMenu_2.setForeground(new Color(0, 153, 255));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("�ͻ���ѯ");
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("��Ӧ�̲�ѯ");
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("��Ʒ��ѯ");
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("���۲�ѯ");
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("�����˻���ѯ");
		mnNewMenu_2.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("����ѯ");
		mnNewMenu_2.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("����˻���ѯ");
		mnNewMenu_2.add(mntmNewMenuItem_11);
		
		JMenu mnNewMenu_3 = new JMenu("������");
		mnNewMenu_3.setIcon(new ImageIcon(MainFrame.class.getResource("/com/oxhpjk/jxc/image/Inventory.png")));
		mnNewMenu_3.setForeground(new Color(0, 153, 255));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("����̵�");
		mnNewMenu_3.add(mntmNewMenuItem_14);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("�۸����");
		mnNewMenu_3.add(mntmNewMenuItem_15);
		
		JMenu mnNewMenu_4 = new JMenu("ϵͳ����");
		mnNewMenu_4.setForeground(new Color(0, 153, 255));
		mnNewMenu_4.setIcon(new ImageIcon(MainFrame.class.getResource("/com/oxhpjk/jxc/image/system management.png")));
		menuBar.add(mnNewMenu_4);
		//Ȩ�޴���
		if(operator!=null) {
			if(operator.getPower().equals("��������Ա")) {
			JMenuItem mntmNewMenuItem_16 = new JMenuItem("����Ա����");
			mnNewMenu_4.add(mntmNewMenuItem_16);
			
			JMenuItem mntmNewMenuItem_17 = new JMenuItem("Ȩ�޹���");
			mnNewMenu_4.add(mntmNewMenuItem_17);
			}else if(operator.getPower().equals("��ͨ����Ա")) {
				//������չ
			}
			else {
				JOptionPane.showMessageDialog(null, "�����û�","������",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
			
		}
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("����Ա����");
		mnNewMenu_4.add(mntmNewMenuItem_16);
		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Ȩ�޹���");
		mnNewMenu_4.add(mntmNewMenuItem_17);
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("��������");
		mnNewMenu_4.add(mntmNewMenuItem_18);
		desktopPane=new JDesktopPane();
		desktopPane.setBackground(new Color(255, 255, 255));
		desktopPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(desktopPane);
		
		JLabel lblNewLabel = new JLabel("��ҵ���������ϵͳ");
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/com/oxhpjk/jxc/image/jinxiaocun.login.png")));
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 25));
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
