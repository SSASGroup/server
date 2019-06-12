package cn.xinxing.service.users;

import java.util.List;

import cn.xinxing.model.Users;

/**
 * 
 */
public interface UserService {
	public List<Users> getAllUsers();
	public void addUser(String id, String name, String password, String money);
	public Users getUserInfoById(String _id);
	public void updateById(String id, String money);
}
