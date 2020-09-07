package com.global.biz.user.impl;

import com.global.biz.user.UserService;
import com.global.biz.user.UserVO;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}



	@Override
	public UserVO getUser(UserVO vo) {
		// TODO Auto-generated method stub
		return userDAO.getUser(vo);
	}

}
