package cn.xinxing.service.users.impl;
import java.util.List;

import cn.xinxing.business.UserBusiness;
import cn.xinxing.model.Users;
import cn.xinxing.service.users.UserService;


public class UserServiceImpl implements UserService{
	@Override

	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return UserBusiness.getAllUsers();
	}
	
	public void addUser(String id, String name, String password, String money) {
		UserBusiness.addUser(id, name, password, money);
	}
	
	public Users getUserInfoById(String _id) {
		return UserBusiness.getUserInfoById(_id);
	}
	
	public void updateById(String id, String money) {
		UserBusiness.updateById(id, money);
	}
}
