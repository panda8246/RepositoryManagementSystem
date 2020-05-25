package com.oxhpjk.jxc.service;
import com.oxhpjk.jxc.model.Operator;;

/**
 * 操作员业务处理接口
 * @author 22161
 *
 */
public interface OperatorService {
	/**
	 * 查询用户名，密码是否正确
	 * @param operator，封装username，password
	 * @return
	 */
	boolean loginCheck(Operator operator);
	/**
	 * 通过登录名查询操作者信息
	 * @param username
	 * @return
	 */
	public  Operator getOperator(String username) ;
}

