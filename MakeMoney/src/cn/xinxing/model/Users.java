package cn.xinxing.model;

public class Users {
	private String user_id;
	private String user_name;
	private String user_password;
	private int user_money;
	
	public String getId() {
		return user_id;
	}
	public void setId(String _id) {
		this.user_id = _id;
	}
	
	public String getName() {
		return user_name;
	}
	public void setName(String _name) {
		this.user_name = _name;
	}

	public String getPassword() {
		return user_password;
	}
	public void setPassword(String _password) {
		this.user_password = _password;
	}

	public int getMoney() {
		return user_money;
	}
	public void setMoney(int _money) {
		this.user_money = _money;
	}
}
