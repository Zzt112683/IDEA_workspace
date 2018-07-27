package service.impl;

import dao.LoginDao;

import dao.impl.jdbc.LoginDaoImpl;
import entity.Account;
import service.LoginService;

public class LoginServiceImpl implements LoginService {

	LoginDao ld = new LoginDaoImpl();

	public Account LoginLogic(String username, String password) {
		
		//���е�¼��ҵ���߼�����
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
