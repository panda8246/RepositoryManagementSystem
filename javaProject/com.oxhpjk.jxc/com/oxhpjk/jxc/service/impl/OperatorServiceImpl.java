package com.oxhpjk.jxc.service.impl;

import com.oxhpjk.jxc.dao.OperatorDao;
import com.oxhpjk.jxc.model.Operator;
import com.oxhpjk.jxc.service.OperatorService;
/**
 * 操作中业务实现类
 * @author 22161
 *
 */
public  class OperatorServiceImpl implements OperatorService {
	private OperatorDao operatorDao =null;
	/**
	 * 查询用户名，密码是否正确
	 * @param operator，封装username，password
	 * @return
	 */
	@Override
	public boolean loginCheck(Operator operator) {
		
		operatorDao=new OperatorDao();
		return operatorDao.loginCheck(operator);
	}
	/**
	 * 通过登录名查询操作者信息
	 */
	@Override
	public Operator getOperator(String username) {
		operatorDao=new OperatorDao();
		return  operatorDao.getOperator(username);
	}
	
	/**
	 * 	修改密码，名字，权限
	 * @return
	 */
	public boolean update(Operator operator) {
		operatorDao=new OperatorDao();
		return  operatorDao.update(operator);
	}
	
}
