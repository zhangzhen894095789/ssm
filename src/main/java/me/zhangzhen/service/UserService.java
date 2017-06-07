package me.zhangzhen.service;

import java.util.List;

import me.zhangzhen.domian.User;

public interface UserService {
	
	List<User> findUsers();
	
	int createUser(User user);
	
	int updateUser(User user);
	
	int deleteUserById(Integer id);

}
