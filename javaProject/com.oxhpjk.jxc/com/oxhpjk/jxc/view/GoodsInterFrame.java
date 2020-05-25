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
		setTitle("商品信息管理");
		setIconifiable(true);//支持窗口最小化显示
		setClosable(true);//支持窗口可关闭
		getContentPane().setLayout(new BorderLayout(0, 0));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/12,screenSize.height/20,screenSize.width/2,screenSize.height/2);
        //创建选项卡
		JTabbedPane tabPane = new JTabbedPane();
		final GoodsAddPanel addPanel = new GoodsAddPanel();//客户信息添加面板
		final GoodsEditPanel editPanel = new GoodsEditPanel();//客户信息编辑面板
		//向选项卡添加面板
		tabPane.addTab("商品信息添加",null,addPanel,"商品信息添加");
		//addPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		tabPane.addTab("商品信息编辑", null,editPanel,"商品信息编辑");
		//向Frame窗口添加选项卡
		getContentPane().add(tabPane);
		//给选项卡设置改变监听
		tabPane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
			    //初始化 编辑界面的下拉列表框
				//editPanel.initComboBox();
			}
		});
		//pack();//通过内部组件自动设置窗口大小
		setVisible(true);//显示窗口
		

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
			JOptionPane.showMessageDialog(null, "请填写全部信息！","温馨提示",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(!ValidationManager.validatePrice(price)) {
			JOptionPane.showMessageDialog(null, "价格不合法！","警告",JOptionPane.WARNING_MESSAGE);
			return;
		}
	}
}
