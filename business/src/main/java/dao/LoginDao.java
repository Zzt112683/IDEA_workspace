package dao;

import entity.Account;

//�ӿڸ���ԭ��
public interface LoginDao {

	public Account LoginLogic(String username, String password);
	
	public void addToken(String token, Account acc);
	
	
	public String findTokenById(int id);

}
