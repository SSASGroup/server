package cn.xinxing.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.xinxing.model.Users;

public class UserBusiness {
	public static List<Users> getAllUsers() {
		List<Users> list = new ArrayList<Users>();
		String sql = null;
		DBHelper db1 = null;
		sql = "select *from user";// SQL
		db1 = new DBHelper(sql);//
		ResultSet ret = null;
		try {
			ret = db1.pst.executeQuery();
			while (ret.next()) {
				String id = ret.getString(1);
				String name = ret.getString(2);
				String password = ret.getString(3);
				int money = ret.getInt(4);
				Users users = new Users();
				users.setId(id);
				users.setName(name);
				users.setPassword(password);
				users.setMoney(money);
				list.add(users);
			} //
			ret.close();
			db1.close();//
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //

		return list;
	}
	

	public static void addUser(String id, String name, String password, String money) {
		String sql = null;
		DBHelper db1 = null;
		sql = "INSERT INTO `zhengxianqian`.`user` (`user_id`, `user_name`, `user_password`, `user_money`) VALUES ("+id+", "+name+", "+password+", "+money+")";
		db1 = new DBHelper(sql);
		try {
			int row = db1.pst.executeUpdate();
			db1.close();// 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 
		return;
	}
	
	public static Users getUserInfoById(String _id) {
		String sql = null;
		DBHelper db1 = null;
		sql = "select * from user where user_id =" + _id;// 
		db1 = new DBHelper(sql);// 
		ResultSet ret = null;
		Users user = new Users();
		try {
			ret = db1.pst.executeQuery();
			while (ret.next()) {
				String id = ret.getString(1);
				String name = ret.getString(2);
				String password = ret.getString(3);
				int money = ret.getInt(4);
				user.setId(id);
				user.setName(name);
				user.setPassword(password);
				user.setMoney(money);
			} // 
			ret.close();
			db1.close();// 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 
		return user;
	}

}




