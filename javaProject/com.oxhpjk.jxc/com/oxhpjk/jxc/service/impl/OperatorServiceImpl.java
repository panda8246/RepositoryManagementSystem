package com.oxhpjk.jxc.service.impl;

import com.oxhpjk.jxc.dao.OperatorDao;
import com.oxhpjk.jxc.model.Operator;
import com.oxhpjk.jxc.service.OperatorService;
/**
 * ������ҵ��ʵ����
 * @author 22161
 *
 */
public  class OperatorServiceImpl implements OperatorService {
	private OperatorDao operatorDao =null;
	/**
	 * ��ѯ�û����������Ƿ���ȷ
	 * @param operator����װusername��password
	 * @return
	 */
	@Override
	public boolean loginCheck(Operator operator) {
		
		operatorDao=new OperatorDao();
		return operatorDao.loginCheck(operator);
	}
	/**
	 * ͨ����¼����ѯ��������Ϣ
	 */
	@Override
	public Operator getOperator(String username) {
		operatorDao=new OperatorDao();
		return  operatorDao.getOperator(username);
	}
	
	/**
	 * 	�޸����룬���֣�Ȩ��
	 * @return
	 */
	public boolean update(Operator operator) {
		operatorDao=new OperatorDao();
		return  operatorDao.update(operator);
	}
	
}
