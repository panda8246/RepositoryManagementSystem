package com.oxhpjk.jxc.service;
import com.oxhpjk.jxc.model.Operator;;

/**
 * ����Աҵ����ӿ�
 * @author 22161
 *
 */
public interface OperatorService {
	/**
	 * ��ѯ�û����������Ƿ���ȷ
	 * @param operator����װusername��password
	 * @return
	 */
	boolean loginCheck(Operator operator);
	/**
	 * ͨ����¼����ѯ��������Ϣ
	 * @param username
	 * @return
	 */
	public  Operator getOperator(String username) ;
}

