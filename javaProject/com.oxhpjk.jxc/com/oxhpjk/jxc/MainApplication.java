package com.oxhpjk.jxc;

import javax.swing.JFrame;

import com.oxhpjk.jxc.view.LoginFrame;

/**
 * 整个程序的入口类
 * @author FPF
 *
 */
public class MainApplication {

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);//应用主题设置
		LoginFrame frame = new LoginFrame();
		frame.setVisible(true);
	}

}