package com.oxhpjk.jxc.commom;
/**
 * �쳣������
 * @author FPF
 *
 */
public class ErrorManager {
	/**
	 * ���������Ϣ
	 * @param name��ʹ�ø÷���������+������
	 * @param e���������
	 */
     public static void printError(String name,Exception e) {
    	 System.out.println(name+" Error!"+e.getMessage());
    	 e.printStackTrace();
     }
}
