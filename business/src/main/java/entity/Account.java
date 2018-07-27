package entity;

public class Account {

	private int id;
	private String username;
	private String password;
	private String ip;
	private String sex;
	
	
	public Account(int id, String username, String password, String ip, String sex) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.ip = ip;
		this.sex = sex;
	}

	/**�����ض����˺Ŷ��� */
	public Account(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Account() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	
	

}
