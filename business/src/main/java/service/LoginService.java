package service;

import entity.Account;

public interface LoginService {

	public Account LoginLogic(String username, String password);
	
	public void addToken(String token, Account acc);
	
	String findTokenByid(int id);
}
