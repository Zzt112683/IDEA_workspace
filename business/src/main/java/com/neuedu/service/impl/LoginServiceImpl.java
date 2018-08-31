package com.neuedu.service.impl;

import com.neuedu.dao.LoginDao;

import com.neuedu.dao.impl.jdbc.LoginDaoImpl;
import com.neuedu.entity.Account;
import com.neuedu.service.LoginService;

public class LoginServiceImpl implements LoginService {

	LoginDao ld = new LoginDaoImpl();

	public Account LoginLogic(String username, String password) {
		
		//???е??????????????
		LoginDao loginDao = new LoginDaoImpl();
		return loginDao.LoginLogic(username, password);
	}

	@Override
	public void addToken(String token,Account acc) {
		// TODO Auto-generated method stub
	
		ld.addToken(token,acc);
		
		
		
	}

	@Override
	public String findTokenByid(int id) {
		// TODO Auto-generated method stub
		return ld.findTokenById(id);
	}

}
