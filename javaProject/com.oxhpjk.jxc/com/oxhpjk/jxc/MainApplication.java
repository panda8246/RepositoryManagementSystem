package com.oxhpjk.jxc;

import javax.swing.JFrame;

import com.oxhpjk.jxc.view.LoginFrame;

/**
 * ��������������
 * @author FPF
 *
 */
public class MainApplication {

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);//Ӧ����������
		LoginFrame frame = new LoginFrame();
		frame.setVisible(true);
	}

}