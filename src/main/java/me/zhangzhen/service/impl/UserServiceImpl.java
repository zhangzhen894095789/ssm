package me.zhangzhen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.zhangzhen.domian.User;
import me.zhangzhen.mapper.UserMapper;
import me.zhangzhen.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public List<User> findUsers() {
		// TODO Auto-generated method stub
		return userMapper.findUsers();
	}

	@Override
	@Transactional(readOnly = false)
	public int createUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.createUser(user);
	}

	@Override
	@Transactional(readOnly = false)
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
	}

	@Override
	@Transactional(readOnly = false)
	public int deleteUserById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.deleteUserById(id);
	}

}
