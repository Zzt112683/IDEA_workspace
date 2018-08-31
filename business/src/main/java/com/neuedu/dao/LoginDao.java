package com.neuedu.dao;

import com.neuedu.entity.Account;

//�ӿڸ���ԭ��
public interface LoginDao {

	public void updateAccount(String username,double money);

	public Account LoginLogic(String username, String password);
	
	public void addToken(String token, Account acc);
	
	
	public String findTokenById(int id);

}
