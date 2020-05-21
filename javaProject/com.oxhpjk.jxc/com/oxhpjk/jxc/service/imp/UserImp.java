package com.oxhpjk.jxc.service.imp;
import com.oxhpjk.jxc.dao.UserDao;
import com.oxhpjk.jxc.modle.User;
import com.oxhpjk.jxc.service.UserServive;

public class UserImp implements UserServive{
	
	UserDao _userdao = null;
	
	
	
	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		_userdao = new UserDao();
		return _userdao.login(user);
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
