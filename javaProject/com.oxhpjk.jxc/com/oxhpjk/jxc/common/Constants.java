package com.oxhpjk.jxc.common;
/**
 * 	存放常量与类路径
 * @author pjk
 *
 */
public interface Constants {
	//执行类型
	public static final int PSTM_TYPE=0;	//预处理模式
	public static final int CALL_TYPE=1;	//访问存储过程
	
	//类的完整包名
	String USER_SERVICE_CLASS = "com.oxhpjk.jxc.service.imp.UserImp";
	String CLIENT_SERVICE_CLASS = "com.oxhpjk.jxc.service.imp.ClientImp";
}
